package edu.ycp.cs320.magicprogram.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.FocusEvent;

public class LoginView extends Composite{
	private TextBox txtbxUsername;
	private TextBox txtbxPassword;
	private Button btnLogIn;
	
	public LoginView() {
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		initWidget(absolutePanel);
		absolutePanel.setSize("500px", "500px");
		
		txtbxUsername = new TextBox();
		txtbxUsername.addFocusHandler(new FocusHandler() {
			public void onFocus(FocusEvent event) {
				txtbxUsername.setText("");
			}
		});
		txtbxUsername.addMouseUpHandler(new MouseUpHandler() {
			public void onMouseUp(MouseUpEvent event) {
				txtbxUsername.setText("");
			}
		});
		txtbxUsername.setText("Username");
		absolutePanel.add(txtbxUsername, 155, 133);
		
		txtbxPassword = new TextBox();
		txtbxPassword.setText("Password");
		absolutePanel.add(txtbxPassword, 155, 173);
		
		btnLogIn = new Button("Log In");
		absolutePanel.add(btnLogIn, 155, 213);
		btnLogIn.setSize("173px", "34px");
	}
}
