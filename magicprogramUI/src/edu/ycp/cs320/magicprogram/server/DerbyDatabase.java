package edu.ycp.cs320.magicprogram.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DerbyDatabase implements IDatabase {
	private static final String DATASTORE = "/MagicProgramDB";

	static {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (Exception e) {
			throw new RuntimeException("Could not load Derby JDBC driver");
		}
	}

	private class DatabaseConnection {
		public Connection conn;
		public int refCount;
	}

	private final ThreadLocal<DatabaseConnection> connHolder = new ThreadLocal<DatabaseConnection>();

	private DatabaseConnection getConnection() throws SQLException {
		DatabaseConnection dbConn = connHolder.get();
		if (dbConn == null) {
			dbConn = new DatabaseConnection();
			dbConn.conn = DriverManager.getConnection("jdbc:derby:" + DATASTORE + ";create=true");
			dbConn.refCount = 0;
			connHolder.set(dbConn);
		}
		dbConn.refCount++;
		return dbConn;
	}

	private void releaseConnection(DatabaseConnection dbConn) throws SQLException {
		dbConn.refCount--;
		if (dbConn.refCount == 0) {
			try {
				dbConn.conn.close();
			} finally {
				connHolder.set(null);
			}
		}
	}

	private<E> E databaseRun(ITransaction<E> transaction) throws SQLException {
		// FIXME: retry if transaction times out due to deadlock

		DatabaseConnection dbConn = getConnection();

		try {
			boolean origAutoCommit = dbConn.conn.getAutoCommit();
			try {
				dbConn.conn.setAutoCommit(false);

				E result = transaction.run(dbConn.conn);
				dbConn.conn.commit();
				return result;
			} finally {
				dbConn.conn.setAutoCommit(origAutoCommit);
			}
		} finally {
			releaseConnection(dbConn);
		}
	}

	void createTables() throws SQLException {
		databaseRun(new ITransaction<Boolean>() {
			@Override
			public Boolean run(Connection conn) throws SQLException {

				PreparedStatement stmt = null;

				try {
					stmt = conn.prepareStatement(
							"create table leaderboard (" +
									"  id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
									"  username VARCHAR(200) NOT NULL, " +
									"  password VARCHAR(200) NOT NULL," +
									"  score INT " +
									")"
							);

					stmt.executeUpdate();

				} finally {
					DBUtil.closeQuietly(stmt);
				}

				return true;
			}
		});
	}

	void createInitialData() throws SQLException {
		databaseRun(new ITransaction<Boolean>() {
			@Override
			public Boolean run( Connection conn) throws SQLException {

				PreparedStatement stmt = null; 
				try{
					stmt = conn.prepareStatement(
							"insert into leaderboard ( username, password, score ) values (?, ?, ?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);

					stmt.setString(1, "Admin");
					stmt.setString(2, "CS320");
					stmt.setInt(3,  99999);
					stmt.addBatch();
					stmt.executeBatch();


				} finally {
					DBUtil.closeQuietly(stmt);
				}

				return true;
			}
		});
	}

	@Override
	public String getUsers(final String name) throws SQLException {
		return databaseRun(new ITransaction<String>() {
			@Override
			public String run(Connection conn) throws SQLException {

				PreparedStatement stmt = null;
				ResultSet resultSet = null;

				try {
					stmt = conn.prepareStatement(
							"select leaderboard.score from leaderboard where leaderboard.username = ?");
					stmt.setString(1,  name);

					resultSet = stmt.executeQuery();


				} finally {
					DBUtil.closeQuietly(stmt);
					DBUtil.closeQuietly(resultSet);
				}

				if (!resultSet.next()) {
					return null;
				}
				return resultSet.getString(1);
			}
		});
	}

	@Override
	public String setUsers(final String name, final int score) throws SQLException {
		return databaseRun(new ITransaction<String>() {
			@Override
			public String run(Connection conn) throws SQLException {

				PreparedStatement stmt = null;
				ResultSet resultSet = null; 

				try {
					stmt = conn.prepareStatement(
							"update leaderboard set score = ? where leaderboard.username = ?", PreparedStatement.RETURN_GENERATED_KEYS);
					stmt.setInt(1, score);
					stmt.setString(2, name);
					stmt.addBatch();
					stmt.executeBatch();

					return name;

				} finally {
					DBUtil.closeQuietly(stmt);
					DBUtil.closeQuietly(resultSet);
				}
			}
		});
	}

	@Override
	public String getPassword(final String username) throws SQLException {
		return databaseRun(new ITransaction<String>() {
			@Override
			public String run(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				String pass = "";

				try {
					stmt = conn.prepareStatement(
							"select leaderboard.password from leaderboard where leaderboard.username = ?");
					stmt.setString(1,  username);
					resultSet = stmt.executeQuery();

				} finally {
					if (!resultSet.next()) {
						return null;
					}
					pass = resultSet.getString(1);
					DBUtil.closeQuietly(stmt);
					DBUtil.closeQuietly(resultSet);
				}

				return pass;

			}
		});
	}

	public boolean addAccount(final String username, final String password) throws SQLException {
		return databaseRun(new ITransaction<Boolean>() {
			@Override
			public Boolean run( Connection conn) throws SQLException{
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				try {
					// check if account exists
					stmt = conn.prepareStatement(
							"select leaderboard.password from leaderboard where leaderboard.username = ?");
					stmt.setString(1,  username);
					resultSet = stmt.executeQuery();
					if (resultSet.next()) {
						return false;
					}
					
					// create account
					stmt = conn.prepareStatement(
							"insert into leaderboard ( username, password, score ) values (?, ?, ?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
					stmt.setString(1, username);
					stmt.setString(2, password);
					stmt.setInt(3, 0);
					stmt.addBatch();
					stmt.executeBatch();
				} finally {
					DBUtil.closeQuietly(stmt);
				}
				return true;
			}
		});
	}

	@Override
	public String[] getRow(int accountID) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getUserID(final String username) throws SQLException {
		return databaseRun(new ITransaction<Integer>() {
			@Override
			public Integer run(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				Integer id = null;

				try {
					stmt = conn.prepareStatement(
							"select leaderboard.id from leaderboard where leaderboard.username = ?");
					stmt.setString(1,  username);
					resultSet = stmt.executeQuery();
					
					if (resultSet.next()) {
						id = resultSet.getInt(1);
					}

				} finally {
					DBUtil.closeQuietly(stmt);
					DBUtil.closeQuietly(resultSet);
				}
				return id;
			}
		});
	}
}
