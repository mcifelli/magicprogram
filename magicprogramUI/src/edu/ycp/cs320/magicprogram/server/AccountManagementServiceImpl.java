package edu.ycp.cs320.magicprogram.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.ycp.cs320.magicprogram.client.AccountManagementService;

public class AccountManagementServiceImpl extends RemoteServiceServlet
implements AccountManagementService {
	private static final long serialVersionUID = 1L;

	@Override
	public boolean verifyAccount(String username, String password) {
//		String userID = Database.getUserID(username);
//		if (userID != null) {
//			return (Database.getPass(userID) == password);
//			
//		}
//		return false;
		
		System.out.println("Attempted login by: " + username + "\n password was: " + password);
		return (username.equals("admin") && password.equals("god"));
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
