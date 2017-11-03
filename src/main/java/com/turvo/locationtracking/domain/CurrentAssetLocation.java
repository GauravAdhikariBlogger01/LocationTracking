package com.turvo.locationtracking.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;
import javax.persistence.TemporalType;

/**
 * Entity Class for current location.
 * 
 * @author gaurava
 *
 */
@Entity
@Table(name = "current_Location")
public class CurrentAssetLocation implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DriverId driver_id;

	@Column(name = "latitude")
	private long latitude;

	@Column(name = "longitude")
	private long longitude;

	@Column(name = "speed")
	private long speed;

	@Column(name = "device_id")
	private long deviceid;

	public long getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(long deviceid) {
		this.deviceid = deviceid;
	}

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

	public DriverId getDriver() {
		return driver_id;
	}

	public void setDriver(DriverId driverid) {
		this.driver_id = driverid;
	}

}
