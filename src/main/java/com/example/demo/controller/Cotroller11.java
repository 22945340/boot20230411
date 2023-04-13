package com.example.demo.controller;

import java.sql.*;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("sub11")
public class Cotroller11 {

	@RequestMapping("link1")
	public void method1() {
		// 2. business logic (SELECT CustomerName FROM Customers WHERE CustomerID = 1;)
				
		String sql = "SELECT CustomerName FROM Customers WHERE CustomerID = 1"; 
		// DB 연결
		Connection connection = DriverManager.getConnection(url, name, password);
		// Statement 객체 생성
		Statement statement = connection.createStatement();
		// Query 실행
		
		// Query 실행 결과 수집
		ResultSet resultSet = statement.executeQuery(sql);
	
		// Query 실행 결과 가공
		if (resultSet.next()) {
			String name = resultSet.getString("CustomerName");
		}
		
	}
}
