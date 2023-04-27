package com.example.demo.controller;

import java.util.*;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.*;

@Controller
@RequestMapping("sub25")
public class Controller25 {

	@RequestMapping(value="link1", method=RequestMethod.POST)
	public void metho1() {
		System.out.println("/sub25/link1 에서 메소드 일함");
	}
	
	
	@GetMapping("link2") //@RequestMapping(value = "link2", method = RequestMethod.GET)
	public void method2() {
		System.out.println("/sub25/link2 GET에서 메소드 일함"); 
	}
	
	@PostMapping("link3") //@RequestMapping(value = "link3", method = RequestMethod.POST)
	public void method3() {
		System.out.println("/sub25/link3 POST에서 메소드 일함");
	}
	
	// /sub25/link4/abc
	@GetMapping("link4/{var1}")
	public void method4(@PathVariable("var1") String p1) {
		System.out.println("var1 : +"  + p1);
	}
	
	// /sub25/link5/abc/55
	@GetMapping("link5/{id}/{age}")
	public void method5(@PathVariable ("id") String id,
						@PathVariable ("age") int age) {
		System.out.println(id + ", " + age);
	}
	
	// /sub25/link6/id/3/name/son
	@GetMapping("link6/id/{var1}/name/{var2}")
	public void method6(@PathVariable("var1") String id,
						@PathVariable("var2") String name) {
		System.out.println(id + "," + name);
	}
	
	
	@GetMapping("link7")
	public String method7() {
		return "hello";
	}
	
	@GetMapping("link8")
	public String method8() {
		return "redirect:/sub25/link7";
	}
	
	
	@GetMapping("link9")
	public String method9(Model model) {
		model.addAttribute("attr1", "value1");
		return "redirect:link10";
	}
	
	
	@GetMapping("link10")
	public void method10() {
		
	}
	
	@GetMapping("link11")
	public String method11(RedirectAttributes rttr) {
		rttr.addFlashAttribute("attr1", "redirect attribute!!");
		return "redirect:link10";
	}
	
	@GetMapping("link12")
	public String method12(RedirectAttributes rttr) {
		List<String> list = List.of("hi", "hello");
		rttr.addFlashAttribute("list", list);
		return "redirect:link13";
	}
	
	@GetMapping("link13")
	public void method13() {
		
	}
	
	
	@GetMapping("link14")
	public String method14(RedirectAttributes rttr) {
		// rttr.addFlashAttribute(null, rttr); 목적지의 Model Attribute로 	
		rttr.addAttribute("address", "seoul"); // 쿼리스트링으로 붙여서
		return "redirect:link15";
	}
	
	@GetMapping("link15")
	public String method15(RedirectAttributes rttr, String address) {
		rttr.addAttribute("email", "java@gmail.com");
		rttr.addAttribute("location", address);
		
		
		return "redirect:link16";
	}
	
	@GetMapping("link16")
	public void method16(@RequestParam("email") String email,
			@RequestParam("location") String location) {
		System.out.println("email : " + email);
		System.out.println("location : " + location );
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
