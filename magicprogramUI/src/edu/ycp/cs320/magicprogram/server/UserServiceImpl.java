package edu.ycp.cs320.magicprogram.server;

import edu.ycp.cs320.magicprogram.client.UserService;
import edu.ycp.cs320.magicprogram.shared.FieldVerifier;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.sql.SQLException;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class UserServiceImpl extends RemoteServiceServlet implements
UserService {

	public String getUserScore(String input) throws IllegalArgumentException {
		try {
			return DBUtil.instance().getUsers(input);
		} catch (SQLException e) {
			throw new RuntimeException("SQLException",e);
		}
	}
	
	public String setUserScore(String name, int score) throws IllegalArgumentException {
		try {
			return DBUtil.instance().setUsers(name, score);
		} catch (SQLException e) {
			throw new RuntimeException("SQLException",e);
		}
	}

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;");
	}
}
