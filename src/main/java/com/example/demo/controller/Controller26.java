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

	// 경로 : /sub26/link1?page=3 -> 3page
	// 경로 : /sub26/link1?page=1 -> 1page
	// 경로 : /sub26/link1 -> 1page
	@GetMapping("link1")
	public String method1(@RequestParam(value = "page", defaultValue = "1") Integer page,
							@RequestParam(value="num", defaultValue = "10") Integer num, 
							Model model) {

		// 쿼리에서 사용하는 시작 인덱스
		Integer startIndex = (page - 1) * num;

		// 페이지네이션 가장 왼쪽 번호, 오른쪽번호 구하기
		Integer leftPageNumber = (page - 1) / 10 * 10 + 1;
		Integer rightPageNumber = leftPageNumber + 9;

		// 이전버튼 페이지 번호 구하기
		Integer prevPageNumber = leftPageNumber - 10;
		Integer nextPageNumber = rightPageNumber + 1;

		// 마지막 페이지 구하기
		Integer size = mapper.size();
		Integer lastPageNumber = (size - 1) / num + 1;

		// 오른쪽 페이지 번호가 마지막 페이지 번호보다 클 수 없음
		rightPageNumber = Math.min(rightPageNumber, lastPageNumber);

		List<Customer> list = mapper.listCustomer(startIndex, num);

		model.addAttribute("customerList", list);
		model.addAttribute("begin", leftPageNumber);
		model.addAttribute("end", rightPageNumber);
		model.addAttribute("prevPageNumber", prevPageNumber);
		model.addAttribute("nextPageNumber", nextPageNumber);
		model.addAttribute("lastPageNumber", lastPageNumber);
		model.addAttribute("currentPageNumber", page);
		
		System.out.println(num);

		return "/sub13/link1";

	}

}
