package com.turvo.locationtracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.turvo.locationtracking.domain.TrackingDetail;

@Repository
public interface DeviceDetailsRepository extends JpaRepository<TrackingDetail, Long> {

	
	
	//@Query("SELECT p FROM TrackingDetail p WHERE p.timestamp BETWEEN startDate AND endDate")
	@Query("select b from TrackingDetail b " +
	         "where b.timestamp between ?1 and ?2")
	List<TrackingDetail> findByTime(@Param("starttime") java.util.Date starttime,
			@Param("endtime") java.util.Date endtime);

	
	 
	
	@Query("SELECT p FROM TrackingDetail p WHERE p.deviceId = :deviceid")
	List<TrackingDetail> findByDeviceId(@Param(value = "deviceid") Long deviceid);
}
