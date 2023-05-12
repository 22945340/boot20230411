package com.example.demo.controller;

import org.springframework.security.access.prepost.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("sub33")
public class Controller33 {

	@GetMapping("mylogin")
	public void loginForm() {
		
	}
	
	
	@GetMapping("loginSuccess")
	public void loginSucess() {
		
	}
	
	@GetMapping("viewAuth")
	public void viewAuth(Authentication authentication) {
		System.out.println("로그인정보 확인 하기");
		System.out.println(authentication);
		System.out.println(authentication.getName());
	}
	
	@GetMapping("customCheck")
	@PreAuthorize("@securityUtil.checkBoardWriter(authentication, #id)")
	public void customCheck() {
		System.out.println("customCheck");
	}
}