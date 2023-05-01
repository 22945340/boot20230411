package com.example.demo.mapper;

import java.util.*;

import org.apache.ibatis.annotations.*;

import com.example.demo.domain.*;

@Mapper
public interface Mapper06 {

	@Select("""
			SELECT 
				CustomerId id, 
				CustomerName name,
				Contactname,
				Address  
			FROM Customers
			ORDER BY CustomerId DESC
			Limit #{startIndex}, #{num}
			""")
	List<Customer> listCustomer(Integer startIndex, Integer num);

	@Select("""
			SELECT COUNT(*) FROM Customers
			""")
	Integer size();

}
