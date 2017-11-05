package com.turvo.locationtracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.turvo.locationtracking.domain.DriverVehicleRegistration;

/**
 * Drive and vechile registration repository.
 * 
 * @author gaurava
 *
 */
@Repository
public interface DriverVehicleRegistrationRepository extends JpaRepository<DriverVehicleRegistration, Long> {
	@Query("SELECT p FROM DriverVehicleRegistration p WHERE p.vehicleId = :vehicleId and p.status=:status")
	DriverVehicleRegistration findByVechileIdAndStatus(@Param(value = "vehicleId") Long vehicleId,
			@Param(value = "status") boolean status);

	@Query("SELECT p FROM DriverVehicleRegistration p WHERE p.mobileNo = :assetId and p.status=:status")
	DriverVehicleRegistration findByAssetId(@Param(value = "assetId") Long assetId,
			@Param(value = "status") boolean status);

}
