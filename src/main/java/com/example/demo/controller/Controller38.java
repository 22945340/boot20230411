package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.*;
import com.example.demo.mapper.*;

//@Controller
//@ResponseBody
@RestController
@RequestMapping("sub38")
public class Controller38 {

	@Autowired
	Mapper02 mapper02;
	
	@GetMapping("link20")
	public List<String> method20() {
		
		return mapper02.sql1();
	}
	
	@GetMapping("link21")
	public List<Dto07> method21(){
		return mapper02.sql3();
	}
	
	@GetMapping("link22")
	public List<Dto08> method22(Integer cid){
		return mapper02.sql7(cid);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


