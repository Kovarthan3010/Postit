package com.projectposter.Advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
class LoggerTool {
private static Logger logger=null;

private LoggerTool()
{
	
}
public synchronized static Logger getlogger()
{

	if(logger==null)
	{
		logger = LoggerFactory.getLogger(LoggerTool.class);
		return logger;
	}
	else {
		return logger;
	}

}
}
