package edu.ycp.cs320.magicprogram.server;

import java.sql.SQLException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.ycp.cs320.magicprogram.client.AccountManagementService;

public class AccountManagementServiceImpl extends RemoteServiceServlet
implements AccountManagementService {
	private static final long serialVersionUID = 1L;

	@Override
	public boolean verifyAccount(String username, String password) {
		String passDB = null;
		try {
			passDB = DBUtil.instance().getPassword(username);
		} catch (SQLException e) {
			throw new RuntimeException("SQLException",e);
		}
		if (passDB == null) {
			return false;
		}
		return (passDB.equals(password));
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getUserID(String username) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String[] getRow(int accountID) {
		String[] row = null;
		try {
			row = DBUtil.instance().getRow(accountID);
		} catch (SQLException e) {
			throw new RuntimeException("SQLException",e);
		}
		if (passDB == null) {
			return false;
		}
		
		
		return row;
	}

}
