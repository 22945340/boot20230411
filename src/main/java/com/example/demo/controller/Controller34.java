package com.example.demo.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import lombok.*;

@Controller
@RequestMapping("sub34")
public class Controller34 {

	@GetMapping("ajax1")
	public void ajax1() {
		
	}
	
	@GetMapping("link1")
	@ResponseBody
	public String method1() {
		System.out.println("헬로 ajax");
		
		return "첫번째 응답 데이터";
	}
	
	@GetMapping("link2")
	public void method2() {
		System.out.println("get 요청 link2");
		
	}
	
	@GetMapping("link3")
	public void method3(@RequestParam("name") String name) {
		System.out.println("쿼리스트링 요청 link3");
		System.out.println("name: " + name); 
		
	}
	
	@GetMapping("link4")
	public void method4(String address) {
		System.out.println("link4메소드 일함");
		System.out.println("address: " + address);
	}
	
	
	// /sub34/link5?name=손&age=22
	@GetMapping("link5")
	public void method5(String name, Integer age) {
		System.out.println("name: " + name);
		System.out.println("age: " + age);
	}
	
	@GetMapping("link6")
	public void method6(String food, Double price) {
		System.out.println("food: " + food);
		System.out.println("price: " + price);
	}
	
	static class Dto1 {
		private String address;
		private String name;
		private Integer age;
	}
	
	
	// /sub34/link7?address=seoul&name=son&age=33
	@GetMapping("link7")
	public void method7(@ModelAttribute Dto1 dto) {
		System.out.println(dto);
	}
	
	@Data
	static class Dto2 {
		private Double price;
		private String product;
		private String category;
	}
	
	@GetMapping("link8")
	public void method8(Dto2 dto) {
		System.out.println(dto);
	}
	
	
	
	
}
