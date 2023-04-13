package com.example.demo.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("sub5")
public class Controller05 {

	// 경로 : /sub5/link1?name=강백호&age=33&score=33.3
	@RequestMapping("link1")
	public void method1(String name, int age, double score) {
		System.out.println(name + "(" + age + "세) 님의 점수는 " + score +"점입니다.");
	}
	
	// 경로 : /sub5/link3?address=seoul&height=170.7&width=39.1
	@RequestMapping("link3")
	public void method03(String address, double height, double width) {
		System.out.println("주소: " + address);
		System.out.println("높이: " + height);
		System.out.println("넓이: " + width);
	}
}
