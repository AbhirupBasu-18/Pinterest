package com.pinterest.FollowMS.utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.pinterest.FollowMS.exception.FollowException;

@Component
@Aspect
public class LoggingAspect {
	private static final Logger LOGGER =    
			LogManager.getLogger(LoggingAspect.class);
	@AfterThrowing(pointcut = "execution(* com.pinterest.FollowMS.service.*Impl.*(..))", throwing = "exception")
	public void afterThrowing(FollowException exception) throws FollowException {
		LOGGER.error(exception.getMessage(), exception);
	}
}
