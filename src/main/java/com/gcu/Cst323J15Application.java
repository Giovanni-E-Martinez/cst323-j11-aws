package com.gcu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan ({ "com.gcu" })
@SpringBootApplication
public class Cst323J15Application 
{

	public static void main(String[] args) 
	{
		SpringApplication.run(Cst323J15Application.class, args);
	}

}
	