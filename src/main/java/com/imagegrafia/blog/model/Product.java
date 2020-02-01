package com.imagegrafia.blog.model;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description ="Detail about Product Model")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	private Long id;
	private String name;
	private String descriptions;
}
