package com.turvo.locationtracking.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity class for tracking detail table.
 * 
 * @author gaurava
 *
 */
@Entity
@Table(name = "tracking_Detail")
public class TrackingDetail implements Serializable {

	/**
	 * Domain mapping class for tracking detail table.
	 */
	private static final Long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tracking_id")
	private Long trackingId;

	@Column(name = "device_id")
	private Long deviceId;

	@Column(name = "latitude")
	private Float latitude;

	@Column(name = "Longitude")
	private Float Longitude;

	@Column(name = "speed")
	private Long speed;

	@Column(name = "driver_id")
	private Long driverId;
	@Column(name = "additionalinfo")
	private String additionalInfo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "eventtime")
	private Date timestamp;

	public Long getDriverId() {
		return driverId;
	}

	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Long getTrackingId() {
		return trackingId;
	}

	public void setTrackingId(Long trackingId) {
		this.trackingId = trackingId;
	}

	public Long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Float getLongitude() {
		return Longitude;
	}

	public void setLongitude(Float Longitude) {
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
