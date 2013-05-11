package edu.ycp.cs320.magicprogram.client;

import com.google.gwt.core.client.GWT;

public class RPC {
	public static final AccountManagementServiceAsync accountManagementService =
		GWT.create(AccountManagementService.class);
}
