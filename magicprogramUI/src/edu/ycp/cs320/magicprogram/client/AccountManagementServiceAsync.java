package edu.ycp.cs320.magicprogram.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
public interface AccountManagementServiceAsync {
	
	void verifyAccount(String username, String password,
			AsyncCallback<Boolean> callback);
	
	void addAccount(String username, String password,
			AsyncCallback<Boolean> callback);
	
	void removeAccount(int accountID, AsyncCallback<Void> callback);

	void getUserID(String username, AsyncCallback<Integer> callback);
	
	void getRow(int accountID, AsyncCallback<String[]> callback);
}
