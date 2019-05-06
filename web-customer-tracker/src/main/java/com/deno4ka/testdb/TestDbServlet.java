package com.deno4ka.testdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = "springstudent";
		String pass = "springstudent";
		String jsbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
		String driver = "com.mysql.jdbc.Driver";

		try (PrintWriter out = resp.getWriter()) {
			out.println("Connecting to database: " + jsbcUrl);
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(jsbcUrl, user, pass);
			out.println("SUCCESS!!!");
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
