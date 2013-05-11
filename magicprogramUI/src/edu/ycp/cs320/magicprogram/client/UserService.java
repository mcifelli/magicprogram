package edu.ycp.cs320.magicprogram.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("userService")
public interface UserService extends RemoteService {
	
	public String getUserScore(String name) throws IllegalArgumentException;
	
	public String setUserScore(String name, int score) throws IllegalArgumentException;
	
}
