package edu.ycp.cs320.magicprogram.server;

import java.sql.SQLException;
import java.util.List;


public interface IDatabase {
	public String getUsers(String name) throws SQLException;

	public String setUsers(String name, int score) throws SQLException;

	public String getPassword(String username) throws SQLException;
	
}
