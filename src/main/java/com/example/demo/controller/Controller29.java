package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.*;
import com.example.demo.mapper.*;

import lombok.experimental.*;

@Controller
@RequestMapping("sub29")
public class Controller29 {

	@Autowired Mapper09 mapper;
	
	@RequestMapping("link1")
	public void method1() {	
		mapper.sql1(List.of("UK", "USA"));
		
	}
	
	@GetMapping("link2")
	public void method2() {
		List<Supplier> list1 = mapper.sql2(List.of("UK", "USA", "Japan"));
		list1.forEach(System.out::println);
		
		List<Supplier> list2 = mapper.sql2(List.of("Brazil", "Germany"));
		list2.forEach(System.out::println);
	}
	
	@GetMapping("link3")
	public void method3() {
		// sub28/link3.jsp
		
	}
	
	@GetMapping("link4")
	public void method4(@RequestParam(value="country", required = false) List<String> country) {
		
		System.out.println(country);
		mapper.sql2(country).forEach(System.out::println);
	}
	
}
