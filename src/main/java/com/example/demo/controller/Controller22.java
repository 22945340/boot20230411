package com.example.demo.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.*;
import com.example.demo.mapper.*;

@Controller
@RequestMapping("sub22")
public class Controller22 {

	@Autowired
	private Mapper03 mapper;
	
	@RequestMapping("link1")
	public void method1(Integer val1, String val2) {
		int cnt1 = mapper.sql1(77, "java");
		int cnt2 = mapper.sql1(66, "Spring");
		int cnt3 = mapper.sql1(88, "css");
		
		System.out.println(cnt1);
		System.out.println(cnt2);
		System.out.println(cnt3);
	}
	
	@RequestMapping("link2")
	public void method2() {
		int cnt = mapper.sql2(3.3, "hi");
		
		System.out.println(cnt);
	}
	
	@RequestMapping("link3")
	public void method3(Double val1, String val2) {
		System.out.println(mapper.sql2(val1, val2));
	}
	
	@RequestMapping("link4")
	public void method4() {
		Dto09 o = new Dto09();
		o.setProp1(33);
		o.setProp2("bye");
		o.setProp3(3.14);
		
		System.out.println(mapper.sql3(o));
	}
	
	@RequestMapping("link5")
	public void method5() {
		Dto10 o = new Dto10();
		o.setAge(27);
		o.setName("손흥민");
		o.setScore(8.7);
		
		System.out.println(mapper.sql4(o));
	}
	
	// /sub22/link6?age=77&name=park&score=9.3
	@RequestMapping("link6")
	public void method6(@ModelAttribute Dto10 dto) {
		int cnt = mapper.sql4(dto);
		
		System.out.println(cnt + "개 행 입력됨");
	}
	
	
	@RequestMapping("link7")
	public void method7(@ModelAttribute Dto09 dto) {
		int cnt = mapper.sql3(dto);
		
		System.out.println(cnt + "개 행 입력됨");
	}
	
	@RequestMapping("link8")
	public void method8() {
		Dto09 dto1 = new Dto09();
		Dto10 dto2 = new Dto10();
		dto1.setProp1(345);
		dto2.setName("서태웅");
		dto1.setProp3(9.8);
		
		int cnt = mapper.sql5(dto1, dto2);
		
		System.out.println(cnt + "개 행 입력됨");
		
	}
	
	@RequestMapping("link9")
	public void method9() {
		Dto09 dto1 = new Dto09();
		Dto10 dto2 = new Dto10();
		
		dto1.setProp1(123);
		dto1.setProp2("hi");
		dto1.setProp3(1.23);
		
		dto2.setAge(33);
		dto2.setName("강백호");
		dto2.setScore(3.14);
		
		int cnt = mapper.sql6(dto1, dto2);
		
		System.out.println(cnt + "개 행 입력됨");
		
	}
	
	
	// /sub22/link10?prop1=7&prop2=lunch&prop3=3.14&age=8&name=song&score=3.14
	@RequestMapping("link10")
	public void method10(Dto09 p1, Dto10 p2) {
		int cnt = mapper.sql6(p1, p2);
		System.out.println(cnt + "개 행 입력됨");
	}
	
	// /sub22/link11?prop2=mybatis&prop3=300
	@RequestMapping("link11")
	public void method11(Dto11 dto) {
		System.out.println("prop1: " + dto.getProp1());
		int cnt = mapper.sql7(dto);
		System.out.println(cnt + "행 입력 완료!!");
		System.out.println("prop1 : " + dto.getProp1());
		
		
	}
	
	// /sub22/link12?age=40&name=son&score=9.9 요청시
	// Mytable40에 데이터 추가 되도록 코드
	@RequestMapping("link12")
	public void method12(Dto12 dto) {
		System.out.println(mapper.sql8(dto) + "행 입력 완료");
	}
	
	
	
	
	
}
