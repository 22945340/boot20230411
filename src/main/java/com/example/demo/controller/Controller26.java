package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.*;
import com.example.demo.mapper.*;

@Controller
@RequestMapping("sub26")
public class Controller26 {
	
	@Autowired
	private Mapper06 mapper;
	
	
	// 경로 : /sub26/link1?page=3	-> 3page
	// 경로 : /sub26/link1?page=1	-> 1page	
	// 경로 : /sub26/link1			-> 1page	
	@GetMapping("link1")
	public String method1(@RequestParam(value ="page", defaultValue = "1") Integer page, Model model) {
		
		System.out.println(page);
		
		Integer startIndex = (page-1) * 20;
		
		List<Customer> list = mapper.listCustomer(startIndex);
		
		model.addAttribute("customerList", list);
		
		return "/sub13/link1";
		
	}

}
