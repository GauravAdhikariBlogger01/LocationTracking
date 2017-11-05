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

@Entity
@Table(name = "tracking_detail_summary")
public class TrackingDetails implements Serializable {

	/**
	 * Domain mapping class for tracking detail summary.
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tracking_id")
	private Long trackingId;

	@Column(name = "device_id")
	private Long deviceId;

	@Column(name = "vechile_id")
	private Long vehicleId;

	@Column(name = "device_type")
	private String deviceType;

	@Column(name = "driver_name")
	private String driverName;

	@Column(name = "latitude")
	private Float latitude;

	@Column(name = "longitude")
	private Float longitude;

	@Column(name = "speed")
	private Float speed;

	@Column(name = "additionalInfo")
	private String additionalInfo;

	@Column(name = "eventtime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date eventtime;

	@Column(name = "driver_id")
	private Long driverId;

	public Long getDriverId() {
		return driverId;
	}

	public void setDriverId(Long driverId) {
		this.driverId = driverId;
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

	public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public Float getSpeed() {
		return speed;
	}

	public void setSpeed(Float speed) {
		this.speed = speed;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public Date getEventtime() {
		return eventtime;
	}

	public void setEventtime(Date eventtime) {
		this.eventtime = eventtime;
	}

}
