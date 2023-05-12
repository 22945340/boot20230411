package com.example.demo.controller;

import java.util.*;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import lombok.*;

@Controller
@RequestMapping("sub36")
public class Controller36 {
	
	@GetMapping("view")
	public void method() {
		
	}
	
	@Data
	static class Dto1{
		private String name;
		private Integer age;
	}
	
	@PostMapping("link1")
	public void method1(@RequestBody Dto1 dto) {
		System.out.println(dto);
	}
	
	@Data
	static class Dto2{
		private String name;
		private String email;
		private Double score;
		private Boolean married;
	}
	
	@PostMapping("link2")
	public void method2(@RequestBody Dto2 dto) {
		System.out.println(dto);
	}
	
	@Data
	static class Dto3{
		private String name;
		private List<String> hobby;
	}
	
	
	@PostMapping("link3")
	public void method3(@RequestBody Dto3 dto) {
		System.out.println(dto);
	}
	
	@Data
	static class Dto4{
		// 코드 작성
		private String name;
		private List<String> phone;
	}
	
	@PostMapping("link4")
	public void method4(@RequestBody Dto4 dto) {
		System.out.println(dto.getPhone().get(2)); // 값 출력
		
	}
	
	@Data
	static class Dto5{
		private String title;
		private String publicsher;
//		private Map<String, Object> writer;
		private Dto1 writer;
	}
	
	@PostMapping("link5")
	public void method5(@RequestBody Dto5 dto) {
		System.out.println(dto);
	}
	
	@Data
	static class Dto6{
		private String city;
		private Integer price;
		private Dto2 etc;
	}
	
	@PostMapping("link6")
	public void method6(@RequestBody Dto6 dto) {
		System.out.println(dto);
	}
	
	
	@PostMapping("link7")
	public void method7(@RequestBody List<Dto1> dto) {
		dto.forEach(System.out::println);
	}
	
}
