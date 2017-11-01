package com.turvo.locationtracking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Global Exception handler.
 * 
 * @author gaurava
 *
 */
@ControllerAdvice
public class LocationTrackingControllerAdvice {
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public String exception(Exception e) {

		return "Some thing went wrong please try after some time";
	}

}
