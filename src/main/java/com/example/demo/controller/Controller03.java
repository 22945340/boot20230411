package com.example.demo.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("sub3")
public class Controller03 {
	
	// sprint mvc request handler method
	// 
	
	@RequestMapping("link1")
	public void method01() {
		System.out.println("/sub3/link1 - method01();");
	}
	
	@RequestMapping("link2")
	public void method02() {
		System.out.println("/sub3/link2 - method02();");
	}

}
