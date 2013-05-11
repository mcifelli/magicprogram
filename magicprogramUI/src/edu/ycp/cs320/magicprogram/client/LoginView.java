package edu.ycp.cs320.magicprogram.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.FocusEvent;

public class LoginView extends Composite{
	private TextBox username;
	private PasswordTextBox password;
	private Button logIn;
	
	public LoginView() {
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setSize("500px", "500px");
		
		username = new TextBox();
		username.addFocusHandler(new FocusHandler() {
			public void onFocus(FocusEvent event) {
				username.setText("");
			}
		});

		username.setText("Username");
		absolutePanel.add(username, 155, 133);
		
		password = new PasswordTextBox();
		password.addFocusHandler(new FocusHandler() {
			public void onFocus(FocusEvent event) {
				password.setText("");
			}
		});
		password.setText("Password");
		absolutePanel.add(password, 155, 173);
		
		logIn = new Button("Log In");
		absolutePanel.add(logIn, 155, 213);
		logIn.setSize("173px", "34px");
		logIn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				logIn.setText("LOGGING IN");
				RPC.accountManagementService.verifyAccount(username.getValue(), password.getValue(), new AsyncCallback<Boolean>(){
					public void onFailure(Throwable caught){
						GWT.log("RPC call failed: " + caught.getMessage());
					}
					public void onSuccess(Boolean result){
						if (result) {
							username.setText("");
							password.setText("");
							logIn.setText("Success");
							GWT.log("RPC pass");
							MagicprogramUI.changeView(new MenuView());
						}
						else {
							username.setText("");
							password.setText("");
							logIn.setText("Fail");
						}
						
					}
				});
			}
		});
		
		initWidget(absolutePanel);
	}
}
