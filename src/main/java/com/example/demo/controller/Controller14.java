package com.example.demo.controller;

import java.sql.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.*;

@Controller
@RequestMapping("sub14")
public class Controller14 {

	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String name;
	@Value("${spring.datasource.password}")
	private String password;

	// /sub14/link1?keyword=or
	@RequestMapping("link1")
	public String method1(String keyword, Model model) throws Exception  {
		List<Customer> customerList = new ArrayList<>();
		String sql = """
				SELECT CustomerID, CustomerName, Address, contactName
				FROM Customers
				WHERE CustomerName LIKE ? 
					OR ContactName LIKE ? 
				""";
		Connection connection = DriverManager.getConnection(url, name, password);
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, "%" + keyword + "%");
		preparedStatement.setString(2, "%" + keyword + "%");
		ResultSet resultSet = preparedStatement.executeQuery();
		
		try(connection; preparedStatement; resultSet){
			while(resultSet.next()) {
				Customer customer = new Customer();
				customer.setId(resultSet.getInt("customerId"));
				customer.setAddress(resultSet.getString("address"));
				customer.setName(resultSet.getString("customerName"));
				customer.setContactName(resultSet.getString("contactName"));
				
				customerList.add(customer);
			}
		}
		
		model.addAttribute("customerList", customerList);
		return "sub13/link1";
	}
}
