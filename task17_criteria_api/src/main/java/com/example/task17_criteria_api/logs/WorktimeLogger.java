package com.example.task17_criteria_api.logs;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class WorktimeLogger {

	@Pointcut("within(com.example.task17_criteria_api.controller.*)")
	public void executionServiceMethod() {}

	@Around("executionServiceMethod()")
	public Object timeExecutionServiceMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		long begin = System.currentTimeMillis();
		Object object = joinPoint.proceed();
		long end = System.currentTimeMillis();
		log.info(joinPoint.getSignature().toShortString() + " completed in " + (end - begin) + " ms" );
		return object;
	}
}
