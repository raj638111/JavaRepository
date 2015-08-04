package com.rj.a9_AOP;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExecutionTimeLoggingSpringAOP {

	final static Logger logger = Logger.getLogger(ExecutionTimeLoggingSpringAOP.class);
	
	ExecutionTimeLoggingSpringAOP() {
		logger.debug("hello");
	}
	
	@Around("execution(* com.rj.*.*.*(..))")
	public void around(ProceedingJoinPoint jp) throws Throwable {
		String className = jp.getTarget().getClass().getCanonicalName();
		String methodName = jp.getSignature().getName();
		logger.debug("Before : " + className + ":" + methodName + "()");
		jp.proceed();
		logger.debug("After : " + className + ":" + methodName + "()");
	}
	
}


//@Around("execution(public * *(..))")
//@Around("execution(public * com.rj.*.*.*(..))")
