package org.lu.controller;

import javax.annotation.Resource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@Autowired
	JobLauncher jobLauncher;

	@Resource(name = "job1")
	Job job;

	@RequestMapping("/")
	@ResponseBody
	public String home() {
		return "hello world";
	}

	@RequestMapping("/doBatch")
	@ResponseBody
	public String doBatch() throws JobExecutionAlreadyRunningException,
			JobRestartException, JobInstanceAlreadyCompleteException,
			JobParametersInvalidException {
		long a = System.currentTimeMillis();
		jobLauncher.run(job, new JobParameters());
		long b = System.currentTimeMillis() - a;
		return String.valueOf(b);
	}
}
