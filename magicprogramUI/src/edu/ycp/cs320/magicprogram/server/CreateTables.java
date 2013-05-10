package edu.ycp.cs320.magicprogram.server;

import java.sql.SQLException;

public class CreateTables {

	public static void main(String[] args) throws SQLException {
		DerbyDatabase db = new DerbyDatabase();
		db.createTables();
		db.createInitialData();
		System.out.println("Successfully created tables with initial data.");
	}

}
