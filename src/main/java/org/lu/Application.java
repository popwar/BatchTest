package org.lu;

import org.lu.config.AppConfig;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
	public static void runApplication() {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfig.class);
		ctx.refresh();

		JobLauncher jobLauncher = (JobLauncher) ctx.getBean("jobLauncher");
		System.out.println(jobLauncher);
	}

	public static void main(String[] args) {
		Application.runApplication();
	}
}
