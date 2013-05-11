package edu.ycp.cs320.magicprogram.server;

import java.sql.SQLException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.ycp.cs320.magicprogram.client.AccountManagementService;

public class AccountManagementServiceImpl extends RemoteServiceServlet
implements AccountManagementService {
	private static final long serialVersionUID = 1L;

	@Override
	public boolean verifyAccount(String username, String password) {
		System.out.println("User input: " + username + ", " + password);
		String passDB = "";
		
		try {
			passDB = DBUtil.instance().getPassword(username);
		} catch (SQLException e) {
			throw new RuntimeException("SQLException",e);
		}
		return (passDB.equals(password));
	}

	@Override
	public void createAccount(String usr, String password, String email) {
		// TODO Auto-generated method stub
		
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

}
