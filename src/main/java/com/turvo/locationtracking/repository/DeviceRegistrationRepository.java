package com.turvo.locationtracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turvo.locationtracking.domain.DeviceRegistration;

/**
 * Device registration repository.
 * 
 * @author gaurava
 *
 */
@Repository
public interface DeviceRegistrationRepository extends JpaRepository<DeviceRegistration, Long> {

}
