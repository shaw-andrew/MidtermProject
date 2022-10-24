package com.skilldistillery.cmms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.skilldistillery.cmms.data.ToolDAOImpl;

@SpringBootApplication
public class CmmsApplication {
	public static void main(String[] args) {
		SpringApplication.run(CmmsApplication.class, args);
	}

}
