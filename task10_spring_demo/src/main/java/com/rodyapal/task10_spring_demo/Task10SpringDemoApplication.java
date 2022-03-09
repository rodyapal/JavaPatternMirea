package com.rodyapal.task10_spring_demo;

import com.rodyapal.task10_spring_demo.programmers.IProgrammer;
import com.rodyapal.task10_spring_demo.programmers.Junior;
import com.rodyapal.task10_spring_demo.programmers.Middle;
import com.rodyapal.task10_spring_demo.programmers.Senior;
import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Task10SpringDemoApplication {

	public static void main(String[] args) {
//		SpringApplication.run(Task10SpringDemoApplication.class, args);
		runTask10();
	}

	private static void runTask10() {
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
		IProgrammer junior = context.getBean(Junior.class);
		IProgrammer middle = context.getBean(Middle.class);
		IProgrammer senior = context.getBean(Senior.class);
		junior.doCoding();
		middle.doCoding();
		senior.doCoding();
	}

}
