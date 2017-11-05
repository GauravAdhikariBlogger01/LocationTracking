package com.turvo.locationtracking.exception;

/**
 * Custom exception Detail not found.
 * 
 * @author gaurava
 *
 */
public class DetailNotFoundException extends RuntimeException {
	private Long resourceId;

	public DetailNotFoundException(Long resourceId, String message) {
		super(message);
		this.resourceId = resourceId;

	}

}
