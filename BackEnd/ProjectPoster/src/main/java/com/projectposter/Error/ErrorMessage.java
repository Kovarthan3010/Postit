package com.projectposter.Error;

import org.springframework.stereotype.Component;

@Component
public class ErrorMessage {
private int ErrorCode;
private String ErrorMessage;
public String getErrorMessage() {
	return ErrorMessage;
}
public void setErrorMessage(String errorMessage) {
	ErrorMessage = errorMessage;
}
public int getErrorCode() {
	return ErrorCode;
}
public void setErrorCode(int errorCode) {
	ErrorCode = errorCode;
}

}
