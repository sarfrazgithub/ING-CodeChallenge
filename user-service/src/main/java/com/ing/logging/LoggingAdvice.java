package com.ing.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class LoggingAdvice {

	 Logger log = LoggerFactory.getLogger(LoggingAdvice.class);
	
	 @Pointcut(value="execution(* com.ing.controller.UserController.*(..) )")
	 public void myPointCut() {
		 
	 }
	 
	 @Around("myPointCut()")
	public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		String methodName = pjp.getSignature().getName();
		String className = pjp.getTarget().getClass().getName();
		Object[] args = pjp.getArgs();
		log.info(className+":"+ " Entering Method:"+methodName+"()"+" arguments:"+mapper.writeValueAsString(args));
		Object object=pjp.proceed();
		log.info(className+":"+ " Exiting Method:"+methodName+"()"+" response:"+mapper.writeValueAsString(object));
		return object;
	}
}
