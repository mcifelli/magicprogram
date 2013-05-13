package edu.ycp.cs320.magicprogram.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("accountManagementService")
public interface AccountManagementService extends RemoteService{
	public boolean verifyAccount(String username, String password); 
	public boolean addAccount(String username, String password);
	public void removeAccount(int accountID);
	public int getUserID(String username);
	public String[] getRow(int accountID);
}
