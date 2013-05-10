package edu.ycp.cs320.magicprogram.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface UserServiceAsync {
	public void getUserScore(String input, AsyncCallback<String> callback)
			throws IllegalArgumentException;
	
	public void setUserScore(String input, int score, AsyncCallback<String> callback)
			throws IllegalArgumentException;
}
