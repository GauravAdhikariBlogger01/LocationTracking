package com.turvo.locationtracking.modal;

import java.util.Date;

/**
 * Tracking Details Model.
 * 
 * @author gaurava
 *
 */
public class TrackingDetailModel {

	private Long deviceId;

	private Long latitude;

	private Long Longitude;

	private Long speed;

	private String additionalInfo;

	private Date timeststamp;

	private Long driverId;

	public Long getDriverId() {
		return driverId;
	}

	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}

	public Date getTimeststamp() {
		return timeststamp;
	}

	public void setTimeststamp(Date timeststamp) {
		this.timeststamp = timeststamp;
	}

	public Long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}

	public Long getLatitude() {
		return latitude;
	}

	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}

	public Long getLongitude() {
		return Longitude;
	}

	public void setLongitude(Long Longitude) {
		this.Longitude = Longitude;
	}

	public Long getSpeed() {
		return speed;
	}

	public void setSpeed(Long speed) {
		this.speed = speed;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

}
