package edu.ycp.cs320.magicprogram.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("accountManagementService")
public interface AccountManagementService extends RemoteService{
	public int verifyAccount(String username, String password); 
	public boolean addAccount(String username, String password);
	public void removeAccount(int accountID);
	public int getUserID(String username);
	public int getHighScore(int ID);
	public String[] getRow(int accountID);
}
