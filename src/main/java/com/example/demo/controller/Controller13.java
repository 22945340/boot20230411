package com.example.demo.controller;

import java.sql.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.*;

@Controller
@RequestMapping("sub13")
public class Controller13 {

	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String name;
	@Value("${spring.datasource.password}")
	private String password;

	@RequestMapping("link1")
	public void method1(Model model) {
		String sql = """
				SELECT CustomerID, CustomerName, Address
				FROM Customers
				""";
		List<Customer> customerList = new ArrayList<>();
		// 1.

		// 2.
		try {
			Connection connection = DriverManager.getConnection(url, name, password);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			try (connection; statement; resultSet) {

				while (resultSet.next()) {
					int id = resultSet.getInt("customerId");
					String name = resultSet.getString("customerName");
					String address = resultSet.getString("Address");

					Customer customer = new Customer();
					customer.setId(id);
					customer.setName(name);
					customer.setAddress(address);
					customerList.add(customer);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// 3. add attribute
		model.addAttribute("customerList", customerList);
		// 4.
	}

	@RequestMapping("link2")
	public void method2(Model model) {
		// Employee 클래스 작성 (프로퍼티 : id(int), lastName(String), firstName(String))

		String sql = """
				SELECT EmployeeId, LastName, FirstName
				FROM Employees
				""";

		List<Employee> employeeList = new ArrayList<>();

		try {

			Connection connection = DriverManager.getConnection(url, name, password);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			try (connection; statement; resultSet) {
				while (resultSet.next()) {
					Employee employee = new Employee();
					employee.setId(resultSet.getInt(1));
					employee.setLastName(resultSet.getNString(2));
					employee.setFirstName(resultSet.getString(3));

					employeeList.add(employee);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		model.addAttribute("employeeList", employeeList);

	}

	@RequestMapping("link3")
	public String method3(@RequestParam String id, Model model) throws Exception {
		List<Customer> list = new ArrayList<>();
		String sql = """
				SELECT CustomerId, CustomerName, Address
				FROM Customers
				WHERE CustomerId =
				""";
		sql += id;

//		System.out.println(sql);

		Connection con = DriverManager.getConnection(url, name, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		try (con; stmt; rs;) {
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getInt("customerid"));
				customer.setAddress(rs.getString("address"));
				customer.setName(rs.getString("customerName"));

				list.add(customer);
			}

		}

		model.addAttribute("customerList", list);

		return "/sub13/link1";
	}

	@RequestMapping("link4")
	public String method4(@RequestParam String id, Model model) throws Exception {
		List<Customer> list = new ArrayList<>();
		String sql = """
				SELECT CustomerId, CustomerName, Address
				FROM Customers
				WHERE CustomerId = ?
				""";

//		System.out.println(sql);

		Connection con = DriverManager.getConnection(url, name, password);
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, id);
		ResultSet rs = stmt.executeQuery();

		try (con; stmt; rs;) {
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getInt("customerid"));
				customer.setAddress(rs.getString("address"));
				customer.setName(rs.getString("customerName"));

				list.add(customer);
			}

		}

		model.addAttribute("customerList", list);

		return "/sub13/link1";
	}

	@RequestMapping("link5")
	public String method5(String id, Model model) throws Exception {
		// 사용자에게 직원 id 입력 받아서 쿼리 완성하고 실행 후에 /sub13/link2로 포워드해서 직원 1명 출력

		List<Employee> employeeList = new ArrayList<>();

		String sql = """
				SELECT EmployeeId, lastName, firstName
				FROM Employees
				WHERE EmployeeId = ?
				""";
		Connection connection = DriverManager.getConnection(url, name, password);
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();

		try (connection; preparedStatement; resultSet) {
			if (resultSet.next()) {
				Employee employee = new Employee();
				employee.setId(resultSet.getInt("employeeId"));
				employee.setLastName(resultSet.getString("lastName"));
				employee.setFirstName(resultSet.getString("firstName"));

				employeeList.add(employee);
			}
		}

		model.addAttribute("employeeList", employeeList);
		return "/sub13/link2";
	}
}
