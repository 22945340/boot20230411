package com.example.demo.controller;

import java.sql.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.*;

@Controller
@RequestMapping("sub15")
public class Controller15 {

	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String name;
	@Value("${spring.datasource.password}")
	private String password;
	
	@RequestMapping("link1")
	public void method1() throws Exception {
		// 새 고객 데이터 추가
		String sql = """
				INSERT INTO Customers (CustomerID, CustomerName, City)
				VALUES (93, '서태웅', '부산')				
				""";
		
		// INSERT, UPDATE, DELETE는 Statement executeUpdate 메소드 사용
		// 리턴값은 영향을 미친 레코드 수
	
		Connection con = DriverManager.getConnection(url, name, password);
		Statement stmt = con.createStatement();
		int count = stmt.executeUpdate(sql);
		try (con; stmt;){
		}
		System.out.println(count + "개 행 추가 됨");
		
		
	}
	// 경로 : /sub15/link2
	// 10번째 직원 추가
	// 컬럼 : EmployeeID, LastName, FirstName
	
	
	@RequestMapping("link2")
	public void method2() throws Exception {
		String sql = """
				INSERT INTO Employees
				VALUES (10, '흥민', '손', '1995-10-10', 'EmpI10.pic', '신입사원')
				""";
		Connection con = DriverManager.getConnection(url, name, password);
		Statement stmt = con.createStatement();
		int count = stmt.executeUpdate(sql);
		
		try (con; stmt){
		}
		System.out.println(count + "개 행 추가 완료");
	}
	
	
	@RequestMapping("link3")
	public void method3(
			@RequestParam("customerName") String customerName,
			@RequestParam("city") String city,
			@RequestParam("country") String country
			) throws Exception {
		String sql = """
				INSERT INTO Customers
				(CustomerName, City, Country)
				VALUES
				(?, ?, ?)
				""";
		try(
				Connection con = DriverManager.getConnection(url, name, password);
				PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setString(1, customerName);
			pstmt.setString(2, city);
			pstmt.setString(3, country);
			
			int count = pstmt.executeUpdate();
			System.out.println(count + "개 행 추가 완료");
		}
		
		
	}
	
	
	// /sub15/link4?firstName=박지성&lastName=두개의심장
	// 직원정보 추가
	
	@RequestMapping("link4")
	public void method4(
			@RequestParam String firstName,
			@RequestParam String lastName
			) throws Exception {
		String sql = """
				INSERT INTO Employees
				(firstName, lastName)
				VALUES 
				(?,?)
				""";
		Connection con = DriverManager.getConnection(url, name, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		int count = pstmt.executeUpdate();
		
		try(con; pstmt){
			pstmt.setString(1, firstName);
			pstmt.setString(2, lastName);
		}
		System.out.println(count + "개 행 추가 완료");
	}
	
	
	@RequestMapping("link5")
	public void method5() {
		// form이 있는 view로 포워드
		// view : /WEB-INF/views/sub5/link5.jsp
	}
	
	@RequestMapping("link6")
	public void metho6(
			@RequestParam("firstName") String firstName, 
			@RequestParam("lastName") String lastName,
			Model model ) throws Exception {
		
		String sql = """
				INSERT INTO Employees
				(firstName, lastName)				
				VALUES
				(?, ?)
				""";
		
		String selectSql = """
				SELECT * FROM Employees
				ORDER BY 1 DESC
				""";
		
		List<Employee> employeeList = new ArrayList<>();
		try(
				Connection con = DriverManager.getConnection(url, name, password);
				PreparedStatement pstmt = con.prepareStatement(sql);
				Statement stmt = con.createStatement();
				)
		{
			pstmt.setString(1,firstName);
			pstmt.setString(2,lastName);
			pstmt.executeUpdate();
			ResultSet rs = stmt.executeQuery(selectSql);
			
			System.out.println("직원 추가 (" + firstName + ", " + lastName + ")");
			
			while(rs.next()) {
				Employee employee = new Employee();
				employee.setId(rs.getInt(1));
				employee.setLastName(rs.getNString(2));
				employee.setFirstName(rs.getString(3));

				employeeList.add(employee);
			}
			
		}
		
		
		model.addAttribute("employeeList",employeeList);
	}
	
	
	
	// 경로 : /sub15/link7
	// 폼이 있는 jsp로 포워드
	@RequestMapping("link7")
	public void method7() {
		
	}
	
	// 경로 : /sub15/link8
	@RequestMapping("link8")
	public void method8(
			@RequestParam("name") String name,
			@RequestParam("city") String city,
			@RequestParam("country") String country,
			Model model
			) throws Exception {
		String sql = """
				INSERT INTO Suppliers
				(SupplierName, City, Country)
				VALUES 
				(?, ?, ?)
				""";
		Connection con = DriverManager.getConnection(url, this.name, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		try(con; pstmt){
			pstmt.setString(1, name);
			pstmt.setString(2, city);
			pstmt.setString(3, country);
			int count = pstmt.executeUpdate();
		}
		
		System.out.println(name + "/" + city + "/" + country + " 추가 완료");
	}
	
	
	@RequestMapping("link9")
	public void method9() {
		
	}
	
	@RequestMapping("link10")
	public void method10(@ModelAttribute("customer") Customer customer) throws Exception {
		String sql = """
				INSERT INTO Customers
				(CustomerName, ContactName, Address)
				VALUES 
				(?, ?, ?)
				""";
		Connection con = DriverManager.getConnection(url, name, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		try(con; pstmt){
			
			pstmt.setString(1, customer.getName());
			pstmt.setString(2, customer.getContactName());
			pstmt.setString(3, customer.getAddress());
			pstmt.executeUpdate();
		}
		
	}
	
	// 경로 : /sub15/link11
	@RequestMapping("link11")
	public void method11() {
		
	}
	
	// 경로 : /sub15/link12
	@RequestMapping("link12")
	public void method12(Supplier supplier) throws Exception {
		String sql = """
				INSERT INTO Suppliers
				(SupplierName, ContactName, Address, City, PostalCode, Country, Phone)
				VALUES
				(?,?,?,?,?,?,?)
				""";
		Connection con = DriverManager.getConnection(url, name, password);
		PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		try(con; pstmt;){
			pstmt.setString(1, supplier.getName());
			pstmt.setString(2, supplier.getContactName());
			pstmt.setString(3, supplier.getAddress());
			pstmt.setString(4, supplier.getCity());
			pstmt.setString(5, supplier.getPostalCode());
			pstmt.setString(6, supplier.getCountry());
			pstmt.setString(7, supplier.getPhone());
			pstmt.executeUpdate();
			
			// 자동생성된 컬럼(키) 값을 얻기
			ResultSet key =  pstmt.getGeneratedKeys();
			int keyValue = 0;
			if(key.next()) {
				keyValue=  key.getInt(1);
			}
			
			System.out.println(keyValue + "번 공급자 생성됨");
			
		}
		
	}
	
}
