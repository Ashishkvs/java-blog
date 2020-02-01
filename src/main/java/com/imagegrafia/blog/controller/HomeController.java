package com.imagegrafia.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imagegrafia.blog.model.Product;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api")
public class HomeController {

	@GetMapping
	@ApiOperation(value = "Find developer info",
	notes = "This is additional info under api url to provide some info", response = String.class)
	public String[] getInfo() {
		return new String[] { "Ashish", "Blog Application" };
	}

	@GetMapping("/{id}")
	public Product getProduct(
			@ApiParam(value = "Id value for contact info", required = true)
			@PathVariable("id") Long id) {
		return new Product(id, "Any Product ", "Your Product is fantastic");
	}
}
