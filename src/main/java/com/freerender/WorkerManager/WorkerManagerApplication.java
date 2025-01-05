package com.freerender.WorkerManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WorkerManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkerManagerApplication.class, args);
	}

}
