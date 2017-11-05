
DROP TABLE IF EXISTS device_registration;
CREATE TABLE `device_registration` (
  `device_id` bigint(10) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(255) DEFAULT NULL,
  `vehicle_id` bigint(10) UNIQUE NOT NULL,
  PRIMARY KEY (`device_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;



DROP TABLE IF EXISTS tracking_detail_summary;
CREATE TABLE `tracking_Detail_summary` (
  `tracking_id` bigint(10) NOT NULL AUTO_INCREMENT,
  `device_id` bigint(10) NOT NULL,
   `vehicle _id` bigint(10) NOT NULL,
  `device_type` VARCHAR(20) NOT NULL,
  `driver_name` VARCHAR(10) NOT NULL,
  `latitude` DECIMAL(10,6) NOT NULL,
  `longitude` DECIMAL(10,6) NOT NULL,
  `speed` DECIMAL(3,2) NOT NULL,
  `additionalInfo` VARCHAR(45) NULL,
  `eventtime` TIMESTAMP NOT NULL,
  `driver_id` bigint(20) NOT NULL,
  PRIMARY KEY (`tracking_id`))
  ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `driver_vehicle_registration` (
  `driver_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `driver_name` varchar(255) DEFAULT NULL,
  `mobile_no` bigint(20) UNIQUE DEFAULT NULL,
  `registration_time` datetime DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `vehicle_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`driver_id`)
) ENGINE=InnoDB AUTO_INCREMENT=502 DEFAULT CHARSET=latin1;





