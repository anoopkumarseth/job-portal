package com.jobportal.forMCA.job_search_engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JobSearchPortalApplication implements CommandLineRunner {
	@Autowired
	DB db;
	public static void main(String[] args) {
		SpringApplication.run(JobSearchPortalApplication.class, args);
	}

	@Override
	public void run(String... args)  {
		System.out.println(db.getData());
	}
}
