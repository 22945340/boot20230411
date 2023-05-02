package com.example.demo.domain;

import java.util.*;

import lombok.*;

@Data
public class Supplier {
	private int id;
	private String name;
	private String contactName;
	private String address;
	private String city;
	private String postalCode;
	private String country;
	private String phone;

	private List<Product> products;
}
