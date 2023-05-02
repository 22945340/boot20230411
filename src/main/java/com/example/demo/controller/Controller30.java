package com.example.demo.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.mapper.*;

@Controller
@RequestMapping("sub30")
public class Controller30 {

	@Autowired
	private Mapper10 mapper;

	@GetMapping("link1")
	public void method1() {
		// A 고객의 돈 500원 차감
		mapper.minusA();

		// B 고객의 돈 500원 증가
		mapper.plusB();

	}

	@GetMapping("link2")
	public void method2() {
		// A 고객의 돈 500원 차감
		mapper.minusA();
		
		int a = 3 / 0; // runtime exception

		// B 고객의 돈 500원 증가
		mapper.plusB();
	}
	
	@GetMapping("link3")
	@Transactional
	public void method3() {
		// A 고객의 돈 500원 차감
		mapper.minusA();
		
		int a = 3 / 0; // runtime exception

		// B 고객의 돈 500원 증가
		mapper.plusB();
	}
	
	
	
	@GetMapping("link4")
	@Transactional
	public void method4() throws Exception {
		// A 고객의 돈 500원 차감
		mapper.minusA();
		
		Class.forName("java.lang.String2"); // checked exception

		// B 고객의 돈 500원 증가
		mapper.plusB();
	}
	
	
	@GetMapping("link5")
	@Transactional(rollbackFor = Exception.class)
	public void method5() throws Exception {
		// A 고객의 돈 500원 차감
		mapper.minusA();
		
		Class.forName("java.lang.String2"); // checked exception

		// B 고객의 돈 500원 증가
		mapper.plusB();
	}
	
	
}
