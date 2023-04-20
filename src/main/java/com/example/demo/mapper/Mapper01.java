package com.example.demo.mapper;

import java.sql.*;
import java.time.*;

import org.apache.ibatis.annotations.*;

import com.example.demo.domain.*;

@Mapper
public interface Mapper01 {
	
	@Select("""
			SELECT CustomerName 
			FROM Customers
			WHERE CustomerID = 1
			""")
	String method1();
	
	@Select("""
			SELECT FirstName
			FROM Employees
			WHERE EmployeeId = 1
			""")
	String method2();
	
	@Select("""
			SELECT SupplierName
			FROM Suppliers
			WHERE SupplierId = 1
			""")
	String method3();
	
	@Select("""
			SELECT CustomerName
			FROM Customers
			WHERE CustomerID = #{id}
			""")
	String method4(Integer id);

	
	@Select("""
			SELECT lastName 
			FROM Employees
			WHERE EmployeeId = #{id}
			""")
	String method5(Integer id);
	
	@Select("""
			SELECT Price
			FROM MyTable33
			LIMIT 1
			""")
	Integer method6();
	
	@Select("""
			SELECT weight
			FROM MyTable33
			LIMIT 1
			""")
	Double method7();
	
	@Select("""
			SELECT published
			FROM MyTable33
			LIMIT 1
			""")
	LocalDate method8();
	
	
	@Select("""
			SELECT Updated
			FROM MyTable33
			LIMIT 1
			""")
	LocalDateTime method9();
	
	@Select("""
			SELECT Title,
				   Published,
				   Price,
				   Updated,
				   Weight
			From MyTable33
			LIMIT 1
			""")
	// 컬럼명과 (대소문자 구분없이) 매치되는 빈의 프로퍼티명  
	Dto06 method10();
	
	@Select("""
			SELECT 
				Name,
				Age,
				Price,
				Birth,
				Inserted
			FROM MyTable32
			LIMIT 1
			""")
	Dto05 method11();
	
	@Select("""
			SELECT 
				CustomerID AS id, 
				CustomerName name, 
				ContactName, 
				Address, City,
				PostalCode, 
				Country
			FROM Customers
			WHERE CustomerId = 7
		
			""")
	Customer method12();
	
	@Select("""
			SELECT 
				SupplierID id, 
				SupplierName name, 
				ContactName, 
				Address, 
				City, 
				PostalCode, 
				Country, 
				Phone
			FROM Suppliers
			WHERE SupplierId = #{id}
			""")
	Supplier method13(Integer id);
	
	
	@Select("""
			SELECT
				EmployeeID id, 
				LastName, 
				FirstName, 
				BirthDate birth, 
				Photo, 
				Notes	
			FROM Employees
			WHERE EmployeeId = 5			
			""")
	Employee method14();
}
