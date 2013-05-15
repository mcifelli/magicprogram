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
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.user.client.ui.Label;

public class LoginView extends Composite{
	private TextBox username;
	private PasswordTextBox password;
	private Button logIn;

	public LoginView() {
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setSize("250px", "150px");

		username = new TextBox();
		username.addFocusHandler(new FocusHandler() {
			public void onFocus(FocusEvent event) {
				username.setText("");
			}
		});
		absolutePanel.add(username, 64, 0);
		username.setSize("176px", "16px");

		password = new PasswordTextBox();
		password.addFocusHandler(new FocusHandler() {
			public void onFocus(FocusEvent event) {
				password.setText("");
			}
		});
		absolutePanel.add(password, 64, 34);
		password.setSize("176px", "16px");

		logIn = new Button("Log In");
		absolutePanel.add(logIn, 0, 68);
		logIn.setSize("250px", "34px");
		logIn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				logIn.setText("Logging In");
				RPC.accountManagementService.verifyAccount(username.getValue(), password.getValue(), new AsyncCallback<Integer>(){
					public void onFailure(Throwable caught){
						GWT.log("RPC call failed: " + caught.getMessage());
					}
					@Override
					public void onSuccess(Integer result){
						if (result > 0) {
							username.setText("");
							password.setText("");
							logIn.setText("Success");
							GWT.log("RPC pass");
							MagicprogramUI.changeView(new MenuView(result));
						}
						else {
							username.setText("Login Failed");
							password.setText("");
						}
						logIn.setText("Log In");
					}
				});
			}
		});

		initWidget(absolutePanel);

		Label lblUsername = new Label("Username");
		absolutePanel.add(lblUsername, 0, 3);

		Label lblPassword = new Label("Password");
		absolutePanel.add(lblPassword, 1, 40);

		final Button btnSignUp = new Button("Sign up");
		btnSignUp.setText("Create new account");
		absolutePanel.add(btnSignUp, 0, 108);
		btnSignUp.setSize("250px", "30px");
		btnSignUp.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				btnSignUp.setText("Creating account");
				RPC.accountManagementService.addAccount(username.getText(), password.getText(), new AsyncCallback<Boolean>() {

					@Override
					public void onFailure(Throwable caught) {
						
					}

					@Override
					public void onSuccess(Boolean result) {
						if (result) {
							username.setText("Account created");
							password.setText("");
							GWT.log("RPC pass");
						}
						else {
							username.setText("Username taken");
							password.setText("");
						}
						logIn.setText("Log In");
					}
				});
			}
		});
	}
}
