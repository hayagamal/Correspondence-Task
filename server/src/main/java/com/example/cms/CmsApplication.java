package com.example.cms;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//import com.example.cms.Service.CService;
@SpringBootApplication
public class CmsApplication {
	@Autowired

	public static void main(String[] args) {
		
		SpringApplication.run(CmsApplication.class, args);
		
	}
	
	

}
