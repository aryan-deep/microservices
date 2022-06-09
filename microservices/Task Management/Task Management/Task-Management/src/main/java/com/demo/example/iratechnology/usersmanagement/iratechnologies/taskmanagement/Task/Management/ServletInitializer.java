package com.demo.example.iratechnology.usersmanagement.iratechnologies.taskmanagement.Task.Management;

import com.demo.example.iratechnology.usersmanagement.iratechnologies.TaskManagementApplication;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TaskManagementApplication.class);
	}

}
