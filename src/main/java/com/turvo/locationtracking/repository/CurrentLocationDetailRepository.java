package com.turvo.locationtracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turvo.locationtracking.domain.CurrentAssetLocation;
import com.turvo.locationtracking.domain.DriverId;

/**
 * Repository to store current location data.
 * 
 * @author gaurava
 *
 */
@Repository
public interface CurrentLocationDetailRepository extends JpaRepository<CurrentAssetLocation, DriverId> {

}
