package com.example.demo.controller;

import java.io.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import software.amazon.awssdk.auth.credentials.*;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.*;
import software.amazon.awssdk.services.s3.*;
import software.amazon.awssdk.services.s3.model.*;

@Controller
@RequestMapping("sub32")
public class Controller32 {
	
	@Value("${aws.accessKeyId}")
	private String accessKey;
	
	@Value("${aws.secretAccessKey}")
	private String secretKey;
	
	@Value("${aws.s3.bucketName}")
	private String bucketName;
	
	
	@GetMapping("link1")
	public void method1() {
		System.out.println(accessKey);
		System.out.println(secretKey);
		// s3 생성
		Region region = Region.AP_NORTHEAST_2;
		String key = "test/myFile.txt";
		
		String content = "새로운 파일 내용물";
		
		AwsCredentials credentials = AwsBasicCredentials.create(accessKey, secretKey);
		AwsCredentialsProvider provider = StaticCredentialsProvider.create(credentials);
		
		S3Client s3 = S3Client.builder()
					.credentialsProvider(provider)
	                .region(region)
	                .build();
		
		// s3에 파일 업로드
		 PutObjectRequest objectRequest = PutObjectRequest.builder()
	                .bucket(bucketName)
	                .acl(ObjectCannedACL.PUBLIC_READ)
	                .key(key)
	                .build();

	        s3.putObject(objectRequest, RequestBody.fromBytes(content.getBytes()));
		
		
	}
	

}
