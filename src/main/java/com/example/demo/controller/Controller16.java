package com.example.demo.controller;

import java.sql.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("sub16")
public class Controller16 {
	
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String name;
	@Value("${spring.datasource.password}")
	private String password;
	
	
	@RequestMapping("link1")
	public void method1(@RequestParam("id") int id) throws Exception {
		String sql = """
				DELETE FROM Suppliers
				WHERE SupplierId = ?
				""";
		try(
				Connection con = DriverManager.getConnection(url, name, password);
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setInt(1, id);
			int cnt = pstmt.executeUpdate();
			
			System.out.println(cnt + "개 데이터 삭제 됨");
			
		}
	}
	
	
	// 경로 /sub16/link2?id=30
	// 고객 테이블의 데이터 삭제 메스도 작성
	@RequestMapping("link2")
	public void method2(int id) throws Exception {
		String sql = """
				DELETE FROM Customers
				WHERE CustomerId = ?
				""";
		try(
				Connection con = DriverManager.getConnection	(url, name, password);
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setInt(1, id);
			int cnt = pstmt.executeUpdate();
			
			if (cnt >= 1) {
				System.out.println(id + "번 아이디 고객 데이터 삭제됨.(삭제 된 고객 데이터 수 : " + cnt + "개)");
			} else {
				System.out.println(id + "번 아이디를 가진 고객 데이터가 없습니다.");
			}
		}
		
		
	}
	
}
