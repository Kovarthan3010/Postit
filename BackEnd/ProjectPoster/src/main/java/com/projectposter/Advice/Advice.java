package com.projectposter.Advice;



import java.time.LocalDateTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class Advice {
	
	@Autowired
	LoggerTool logger;
	Logger log=LoggerTool.getlogger();
	
	
	
	//Logger - Advice for posting content
	
	@AfterReturning(pointcut="execution(* com.projectposter.Service.PosterServiceImpl.post(..))",returning="result")
	public void postlogger(JoinPoint joinpoint,String result)
	{
		log.info(result+" Class Name : "+joinpoint.getSignature().getDeclaringType().getName()+" Method name : "+joinpoint.getSignature().getName());
	}
	
	//Logger - Advice for deleting content
	
		@AfterReturning(pointcut="execution(* com.projectposter.Service.PosterServiceImpl.deletebyid(..))",returning="result")
		public void deleteloggerreturning(JoinPoint joinpoint,String result)
		{
			log.info(result+" Class Name : "+joinpoint.getSignature().getDeclaringType().getName()+" Method name : "+joinpoint.getSignature().getName());
		}
		@AfterThrowing(pointcut="execution(* com.projectposter.Service.PosterServiceImpl.deletebyid(..))",throwing="exception")
		public void deleteloggerthrowing(JoinPoint joinpoint,Exception exception)
		{
			log.info(exception.getMessage()+" Class Name : "+joinpoint.getSignature().getDeclaringType().getName()+" Method name : "+joinpoint.getSignature().getName());
		}
		
		
	//Logger - Advice for getting postings by id,author,title
		
		
		//id
		
		@AfterReturning(pointcut="execution(* com.projectposter.Service.PosterServiceImpl.postingbyId(..))")
		public void postingbyId(JoinPoint joinpoint)
		{
			log.info("Required Post was fetched and returned "+"Class Name : "+joinpoint.getSignature().getDeclaringType().getName()+" Method name :"+joinpoint.getSignature().getName());
		}
		@AfterThrowing(pointcut="execution(* com.projectposter.Service.PosterServiceImpl.postingbyId(..))",throwing="exception")
		public void postingbyIdthrowing(JoinPoint joinpoint,Exception exception)
		{
			log.info(exception.getMessage()+" Class Name : "+joinpoint.getSignature().getDeclaringType().getName()+" Method name :"+joinpoint.getSignature().getName());
		}
		
		//title
		
		@AfterReturning(pointcut="execution(* com.projectposter.Service.PosterServiceImpl.postingbytitle(..))")
		public void postingbytitle(JoinPoint joinpoint)
		{
			log.info("Required Post was fetched and returned"+" Class Name : "+joinpoint.getSignature().getDeclaringType().getName()+" Method name :"+joinpoint.getSignature().getName());
		}
		@AfterThrowing(pointcut="execution(* com.projectposter.Service.PosterServiceImpl.postingbytitle(..))",throwing="exception")
		public void postingbytitlethrowing(JoinPoint joinpoint,Exception exception)
		{
			log.info(exception.getMessage()+" Class Name : "+joinpoint.getSignature().getDeclaringType().getName()+" Method name :"+joinpoint.getSignature().getName());
		}
		
		//author
		
		
		@AfterReturning(pointcut="execution(* com.projectposter.Service.PosterServiceImpl.postingbyauthor(..))")
		public void postingbyauthor(JoinPoint joinpoint)
		{
			log.info("Required Post was fetched and returned"+" Class Name : "+joinpoint.getSignature().getDeclaringType().getName()+" Method name :"+joinpoint.getSignature().getName());
		}
		@AfterThrowing(pointcut="execution(* com.projectposter.Service.PosterServiceImpl.postingbyauthor(..))",throwing="exception")
		public void postingbyauhorthrowing(JoinPoint joinpoint,Exception exception)
		{
			log.info(exception.getMessage()+" Class Name : "+joinpoint.getSignature().getDeclaringType().getName()+" Method name :"+joinpoint.getSignature().getName());
		}
		
		
		//Logger - Advice for update post
		
		@AfterReturning(pointcut="execution(* com.projectposter.Service.PosterServiceImpl.update(..))",returning="result")
		public void updatereturnlogger(JoinPoint joinpoint,String result)
		{
			log.info(result+" Class Name : "+joinpoint.getSignature().getDeclaringType().getName()+" Method Name :"+joinpoint.getSignature().getName());
		}
		@AfterThrowing(pointcut="execution(* com.projectposter.Service.PosterServiceImpl.update(..))",throwing="exception")
		public void updatethrowinglogger(JoinPoint joinpoint,Exception exception)
		{
			log.info(exception.getMessage()+" Class Name : "+joinpoint.getSignature().getDeclaringType().getName()+" Method Name :"+joinpoint.getSignature().getName());
		}
}
