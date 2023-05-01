package com.example.demo.controller;

import java.io.*;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;

@Controller
@RequestMapping("sub28")
public class Controller28 {

	// 경로 /sub28/link1?name=son&age-33
	@GetMapping("link1")
	public void method1() {
		// /sub28/link1.jsp
	}

	@PostMapping("link2")
	public void method2(@RequestParam("myfile") MultipartFile file) {
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
	}

	@GetMapping("link3")
	public void method3() {
		// 파일 Input이 있는 form을 포함한 뷰(link3.jsp)로 포워드
	}

	@PostMapping("link4")
	public void method4(@RequestParam("files") MultipartFile[] file) {
		for (MultipartFile f : file) {
			System.out.println(f.getOriginalFilename());
			System.out.println(f.getSize());

		}
	}

	@GetMapping("link5")
	public void method5() {

	}

	@PostMapping("link6")
	public void method6(@RequestParam("files") MultipartFile[] file) {
		for (MultipartFile f : file) {
			System.out.println(f.getOriginalFilename());
			System.out.println(f.getSize());

		}
	}

	@GetMapping("link7")
	public void method7() {

	}

	@PostMapping("link8")
	public void method8(String name,
			Integer age,
			@RequestParam("files") MultipartFile[] files) {
		System.out.println(name);
		System.out.println(age);

		for (MultipartFile file : files) {
			System.out.println(file.getOriginalFilename());
			System.out.println(file.getSize());
		}
	}

	@GetMapping("link9")
	public void method9() {

	}

	@PostMapping("link10")
	public void method10(@RequestParam("file1") MultipartFile file) {
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());

		try (InputStream fis = file.getInputStream();
				BufferedInputStream bis = new BufferedInputStream(fis);) {
			String targetFileName = "copy_" + file.getOriginalFilename();
			try (FileOutputStream fos = new FileOutputStream(targetFileName);
					BufferedOutputStream bos = new BufferedOutputStream(fos);) {
				byte[] datas = new byte[1024];
				int len = 0;
				while ((len = bis.read(datas)) != -1) {
					bos.write(datas, 0, len);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@PostMapping("link11")
	public void method11(@RequestParam("file1") MultipartFile file) throws Exception {

		File target = new File("C:/study/copy11_" + file.getOriginalFilename());
		file.transferTo(target);
	}
}
