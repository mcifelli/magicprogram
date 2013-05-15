package edu.ycp.cs320.magicprogram.server;

import java.sql.SQLException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.ycp.cs320.magicprogram.client.AccountManagementService;

public class AccountManagementServiceImpl extends RemoteServiceServlet
implements AccountManagementService {
	private static final long serialVersionUID = 1L;

	@Override
	public int verifyAccount(String username, String password) {
		String passDB = null;
		try {
			passDB = DBUtil.instance().getPassword(username);
			System.out.print(1);
			if (passDB.equals(password)) {
				return DBUtil.instance().getUserID(username);
			}
			else {
				return -1;
			}
		} catch (SQLException e) {
			throw new RuntimeException("SQLException",e);
		}
	}

	@Override
	public boolean addAccount(String username, String password) {
		try {
			return DBUtil.instance().addAccount(username, password);
		} catch (SQLException e) {
			throw new RuntimeException("SQLException",e);
		}
	}

	@Override
	public void removeAccount(int accountID) {

	}

	@Override
	public int getUserID(String username) {
		try {
			return DBUtil.instance().getUserID(username);
		} catch (SQLException e) {
			throw new RuntimeException("SQLException",e);
		}
	}

	@Override
	public String[] getRow(int accountID) {
		String[] row = null;
		try {
			row = DBUtil.instance().getRow(accountID);
		} catch (SQLException e) {
			throw new RuntimeException("SQLException",e);
		}


		return row;
	}

	@Override
	public int getHighScore(int ID) {
		// TODO Auto-generated method stub
		return 0;
	}

}
