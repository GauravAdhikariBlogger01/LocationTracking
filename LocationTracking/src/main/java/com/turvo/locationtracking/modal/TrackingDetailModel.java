package com.turvo.locationtracking.modal;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class TrackingDetailModel {

	private long deviceId;

	private long latitude;

	private long longitude;

	private long speed;

	private String additionalInfo;
	
	private Date timeststamp;

	
	public Date getTimeststamp() {
		return timeststamp;
	}

	public void setTimeststamp(Date timeststamp) {
		this.timeststamp = timeststamp;
	}

	public long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(long deviceId) {
		this.deviceId = deviceId;
	}

	public long getLatitude() {
		return latitude;
	}

	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}

	public long getLongitude() {
		return longitude;
	}

	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}

	public long getSpeed() {
		return speed;
	}

	public void setSpeed(long speed) {
		this.speed = speed;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

}
