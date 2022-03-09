package com.rodyapal.task10_spring_demo.programmers;

import org.springframework.stereotype.Component;

@Component
public class Senior implements IProgrammer{
	@Override
	public void doCoding() {
		System.out.println("Senior is coding");
	}
}
