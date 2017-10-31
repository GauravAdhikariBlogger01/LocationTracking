package com.turvo.locationtracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turvo.locationtracking.domain.Driver;
import com.turvo.locationtracking.domain.Driverid;

@Repository
public interface DriverDetailRepository extends JpaRepository<Driver,Driverid>{

}

