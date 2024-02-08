package com.mystore.testcases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcconnection {

	String host = "localhost";
	String port = "3306";
	String url = "jdbc:mysql://" + host + ":"+ port + "/qadbt";
	String dbUsername = "root";
	String dbPassword = "Vinayak@9284";

	public String username() throws SQLException {

		Connection conn =  DriverManager.getConnection(url, dbUsername, dbPassword);

		Statement s = conn.createStatement();

		ResultSet rs =  s.executeQuery("select * from qadbt.OrgDetails where name = 'vinayak';");

		rs.next();

		String username = rs.getString("username");

		return username;
	}

	public String password() throws SQLException {

		Connection conn =  DriverManager.getConnection(url, dbUsername, dbPassword);

		Statement s = conn.createStatement();

		ResultSet rs =  s.executeQuery("select * from qadbt.OrgDetails where name = 'vinayak';");

		rs.next();

		String password = rs.getString("password");

		return password;
	}

}
