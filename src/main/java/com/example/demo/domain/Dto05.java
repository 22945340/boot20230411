package com.example.demo.domain;

import java.time.*;

import lombok.*;

@Data
public class Dto05 {
	private String name;
	private int age;
	private double price;
	private LocalDate birth;
	private LocalDateTime inserted;
}
