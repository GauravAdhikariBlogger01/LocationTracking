package com.turvo.locationtracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turvo.locationtracking.domain.CurrentAssetLocation;
import com.turvo.locationtracking.domain.Driverid;

@Repository
public interface CurrentAssetLocationDetailRepository extends JpaRepository<CurrentAssetLocation,Driverid>{

}

