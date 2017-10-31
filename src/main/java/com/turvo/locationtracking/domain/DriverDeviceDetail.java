package com.turvo.locationtracking.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "driver")
public class DriverDeviceDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private Driverid driver_id;

	@Column(name = "latitude")
	private long latitude;

	@Column(name = "longitude")
	private long longitude;

	@Column(name = "speed")
	private long speed;

	@Column(name = "device_id")
	private long deviceid;

	@Column(name = "additionalinfo")
	private String additionalInfo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "eventtime")
	private Date timestamp;

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
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

	public Driverid getDriver() {
		return driver_id;
	}

	public void setDriver(Driverid driverid) {
		this.driver_id = driverid;
	}

	public long getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(long deviceid) {
		this.deviceid = deviceid;
	}

}