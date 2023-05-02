package com.example.demo.domain;

import java.util.*;

import lombok.*;

@Data
public class Category {
	private Integer id;
	private String name;
	private String description;
	
	private List<Product> products;
}
