package com.example.demo.domain;

import java.time.*;

import lombok.*;

@Data
public class Dto06 {
	private String title;
	private LocalDate published;
	private int price;
	private double weight;
	private LocalDateTime updated;
}
