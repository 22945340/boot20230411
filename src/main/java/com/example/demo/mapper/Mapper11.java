package com.example.demo.mapper;

import org.apache.ibatis.annotations.*;

import com.example.demo.domain.*;

@Mapper
public interface Mapper11 {

	@Select("""
			SELECT 
				c.CategoryId,
				c.CategoryName,
				c.Description,
				p.ProductName
			FROM Categories c JOIN Products p 
				ON c.CategoryId = p.CategoryId
			WHERE c.CategoryId = #{id}
			""")	
	@ResultMap("categoryResult")
	Category sql1(int i);

	
	@Select("""
			SELECT 
				c.CategoryId,
				c.CategoryName,
				c.Description,
				p.ProductName
			FROM Categories c JOIN Products p 
							ON c.CategoryId = p.CategoryId
			WHERE c.CategoryId = #{id}
			""")
	@ResultMap("categoryResultMap")
	Category sql2(int id);


	@Select("""
			SELECT 
				s.supplierId,
				s.supplierName,
				s.contactName,
				s.Address, 
				s.City, 
				s.PostalCode, 
				s.Country, 
				s.Phone, 
				p.ProductName, 
				p.Price
			FROM Suppliers s JOIN Products p
				ON s.SupplierId = p.SupplierId
			WHERE 
				s.supplierId = #{id}
			""")
	@ResultMap("supplierResult")
	Supplier sql3(int id);
}
