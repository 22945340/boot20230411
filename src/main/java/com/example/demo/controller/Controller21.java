package com.example.demo.controller;

import java.util.*;

import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.*;
import com.example.demo.mapper.*;

@Controller
@RequestMapping("sub21")
public class Controller21 {
	
	@Autowired
	private Mapper02 mapper;

	
	@RequestMapping("link1")
	public void method1() {
		List<String> list = mapper.sql1();
		
//		System.out.println(list);
		list.forEach(System.out::println);
	}
	
	// 경로 : /sub21/link2
	// 모든 직원의 lastName 출력
	
	@RequestMapping("link2")
	public void method2() {
		List<String> list = mapper.sql2();
		
		list.forEach(System.out::println);
	}
	
	@RequestMapping("link3")
	public void method3() {
		List<Dto07> fullNames = mapper.sql3();
		
		fullNames.forEach(System.out::println);
	}
	
	// 상품의 이름, 가격을 조회해서 콘솔에 출력
	@RequestMapping("link4")
	public void method4() {
		List<Dto08> productInfoes = mapper.sql4();
		
		productInfoes.forEach(System.out::println);
		
	}
	
	@RequestMapping("link5")
	public void method5(@RequestParam("cid") Integer cid) {
		List<String> names = mapper.sql5(cid);
		names.forEach(System.out::println);
		
	}
	
	// /sub21/link6?country=uk 
	// /sub21/link6?country=canada
	// 각 국가에 있는 고객명이 콘솔에 출력
	@RequestMapping("link6")
	public void method6(String country) {
		List<String> names = mapper.sql6(country);
		
		names.forEach(System.out::println);
	}
	
	
	@RequestMapping("link7")
	public void method7(Integer cid) {
		List<Dto08> productInfoes = mapper.sql7(cid);
	
		productInfoes.forEach(System.out::println);
	}
	
	
	
	
	
	
}


