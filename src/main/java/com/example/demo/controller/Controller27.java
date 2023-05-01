package com.example.demo.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.mapper.*;

@Controller
@RequestMapping("sub27")
public class Controller27 {

	@Autowired
	private Mapper07 mapper;
	
	
	// 경로 : /sub27/link1?s=ell
	@GetMapping("link1")
	public String method1(Model model,
			@RequestParam(value = "s", defaultValue = "") String keyword) {
		
		model.addAttribute("customerList", mapper.sql1(keyword));
		
		return "/sub13/link1";
	}
	
	// 경로 : /sub27/link2?search=ev
	@GetMapping("link2")
	public String method2(@RequestParam(value = "search", defaultValue = "") String search,
							Model model) {
		
		model.addAttribute("employeeList", mapper.sql2(search));
		
		return "/sub13/link2"; // 직원 lastName, firstName
	}
	
	
	
	@GetMapping("link3")
	public void method3() {
		mapper.sql3();
	}
	
	@GetMapping("link4")
	public void method4() {
		mapper.sql4("eve");
	}
	
	@GetMapping("link5")
	public void method5() {
		mapper.sql4(null);
	}
	
	@GetMapping("link6")
	public void mehtod6() {
		// 3번 카테고리 상품의 평균 가격
		Double avg = mapper.sql5(3);
	}

	@GetMapping("link7")
	public void method7() {
		// 모든 상품의 평균 가격
		Double avg = mapper.sql5(0);
	}	
	
}







