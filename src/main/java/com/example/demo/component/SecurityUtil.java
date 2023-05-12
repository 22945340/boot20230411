package com.example.demo.component;

import org.springframework.security.core.*;
import org.springframework.stereotype.*;

@Component
public class SecurityUtil {

	public boolean checkBoardWriter(Authentication authentication, String id) {
		System.out.println("게시물 작성자 확인 메소드");
		System.out.println(authentication.getName());
		System.out.println(id);
		
		if(authentication.getName().equals(id)) {
			System.out.println("작성자 일치!");
			return true;
		} else {
			System.out.println("작성자 불일치..");
			return false;
		}
			
		
	}
	
	
}
