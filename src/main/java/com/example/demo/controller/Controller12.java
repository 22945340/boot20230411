package com.example.demo.controller;

import java.sql.*;
import java.util.*;
import org.eclipse.tags.shaded.org.apache.xalan.xsltc.dom.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("sub12")
public class Controller12 {
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String name;
	@Value("${spring.datasource.password}")
	private String password;

	@RequestMapping("link1")
	public void method1() {
		String sql = """
				SELECT LastName From Employees
				""";

		try (
				Connection connection = DriverManager.getConnection(url, name, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql);) {
			System.out.println(resultSet.next()); // true
			String name1 = resultSet.getString("lastName");
			System.out.println(name1);
			System.out.println();
			System.out.println(resultSet.next()); // true
			String name2 = resultSet.getString("lastName");
			System.out.println(name2);
			System.out.println();
			System.out.println(resultSet.next()); // true
			String name3 = resultSet.getString("lastName");
			System.out.println(name3);
			System.out.println();
			System.out.println(resultSet.next()); // true
			String name4 = resultSet.getString("lastName");
			System.out.println(name4);
			System.out.println();
			System.out.println(resultSet.next()); // true
			String name5 = resultSet.getString("lastName");
			System.out.println(name5);
			System.out.println();
			System.out.println(resultSet.next()); // true
			String name6 = resultSet.getString("lastName");
			System.out.println(name6);
			System.out.println();
			System.out.println(resultSet.next()); // true
			String name7 = resultSet.getString("lastName");
			System.out.println(name7);
			System.out.println();
			System.out.println(resultSet.next()); // true
			String name8 = resultSet.getString("lastName");
			System.out.println(name8);
			System.out.println();
			System.out.println(resultSet.next()); // true
			String name9 = resultSet.getString("lastName");
			System.out.println(name9);
			System.out.println();
			System.out.println(resultSet.next()); // false
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@RequestMapping("link2")
	public void method2() {
		String sql = """
				SELECT LastName From Employees
				""";
		try {
			Connection connection = DriverManager.getConnection(url, name, password);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			try (connection; statement; resultSet) {
				while (resultSet.next()) {
					System.out.println(resultSet.getString("lastName"));

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@RequestMapping("link3")
	public void method3(Model model) {
		String sql = """
				SELECT ShipperName FROM Shippers
				""";
		List<String> ShipperNameList = new ArrayList<>();

		try {
			Connection connection = DriverManager.getConnection(url, name, password);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			try (connection; statement; resultSet) {
				while (resultSet.next()) {
					System.out.println(resultSet.getString("ShipperName"));
					ShipperNameList.add(resultSet.getString("ShipperName"));
				}
				model.addAttribute("ShipperName", ShipperNameList);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("link4")
	public void method4() {
		String sql = """
				SELECT * FROM Customers
				""";
		try {
			Connection connection = DriverManager.getConnection(url, name, password);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			try (connection; statement; resultSet) {
				resultSet.next();
				System.out.println(resultSet.getString("customerName"));
				System.out.println(resultSet.getString("contactName"));
				System.out.println(resultSet.getString("country"));
				System.out.println();
				resultSet.next();
				System.out.println(resultSet.getString("customerName"));
				System.out.println(resultSet.getString("contactName"));
				System.out.println(resultSet.getString("country"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@RequestMapping("link5")
	public void method5() {
		String sql = """
				SELECT * FROM Customers
				""";
		try {
			Connection connection = DriverManager.getConnection(url, name, password);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			try (connection; statement; resultSet) {
				while (resultSet.next()) {
					System.out.println("################");
					System.out.println(resultSet.getString("customerName"));
					System.out.println(resultSet.getString("contactName"));
					System.out.println(resultSet.getString("country"));

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("link6")
	public void method6() {
		String sql = """
				SELECT * FROM Products
				WHERE ProductId <= 3
				""";
		try {
			Connection connection = DriverManager.getConnection(url, name, password);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			try (connection; statement; resultSet) {
				while (resultSet.next()) {
					System.out.println(resultSet.getInt("ProductID"));
					System.out.println(resultSet.getString("ProductName"));
					System.out.println(resultSet.getDouble("Price"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("link7")
	public void method7() {
		String sql = """
				SELECT * FROM Customers
				WHERE CustomerId < 4
				""";
		try {
			Connection connection = DriverManager.getConnection(url, name, password);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			try (connection; statement; resultSet) {
				while (resultSet.next()) {
					/*
					 * System.out.println(resultSet.getInt("CustomerID"));
					 * System.out.println(resultSet.getString("CustomerName"));
					 */
					System.out.println(resultSet.getInt(1));
					System.out.println(resultSet.getString(2));
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@RequestMapping("link8")
	public void method8() {
		String sql = """
				SELECT LastName, FirstName
				FROM Employees
				WHERE EmployeeID <4
				""";
		try {
			Connection connection = DriverManager.getConnection(url, name, password);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			try (connection; statement; resultSet) {
				while (resultSet.next()) {
					String lastName = resultSet.getString(1);
					String firstName = resultSet.getString(2);

					System.out.println(lastName + " " + firstName);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("link9")
	public void method9() {
		String sql = """
				SELECT customerId, customerName, country
				FROM Customers
				""";

		try {
			Connection connection = DriverManager.getConnection(url, name, password);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			try (connection; statement; resultSet) {

				while (resultSet.next()) {
					int customerId = resultSet.getInt(1);
					String customerName = resultSet.getString(2);
					String country = resultSet.getString(3);

					System.out.println("[" + customerId + "] " + customerName + " : " + country);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
