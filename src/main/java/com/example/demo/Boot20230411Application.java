package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.*;

import com.example.demo.component.*;
import com.example.demo.domain.*;

@SpringBootApplication
public class Boot20230411Application {

	public static void main(String[] args) {
		// Spring Beans : 스프링이 관리하는 객체들
		ApplicationContext context = SpringApplication.run(Boot20230411Application.class, args);
		
//		Object o = context.getBean("bean1");
//		System.out.println(o);
//		
//		Object o2 = context.getBean("employee");
//		Object o3 = context.getBean("employee");
//		System.out.println(o2);
//		
//		System.out.println(System.identityHashCode(o2));
//		System.out.println(System.identityHashCode(o3));
//		
//		
//		Object o4 = context.getBean("bean2");
//		Object o5 = context.getBean("bean3");
//		
//		System.out.println(o4);
//		System.out.println(o5);
//		
//		ComponentA c1 = (ComponentA) o4;
//		System.out.println(c1.GetComp());
//		
//		ComponentC c3 = (ComponentC) context.getBean("bean4");
//		System.out.println(c3.GetComp());		
//		
//		ComponentD c4 = (ComponentD) context.getBean("componentD");
//		System.out.println(c4);
//		
//		ComponentE c5 = (ComponentE) context.getBean("componentE");
//		System.out.println(c5.getComp());
//		
		
	}
	
	// 우리가 객체를 직접 만들 때
	public void legacy() {
		Object O = new Object(); // 직접 만든 객체
		Employee e = new Employee(); // 직접 만든 객체
		
		e.setId(100); // 프로퍼티 직접 할당
	}

}
