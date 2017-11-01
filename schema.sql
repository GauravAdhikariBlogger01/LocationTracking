create database LocationTracking;

use LocationTracking;

create table tracking_Device(
device_id int(11) Not null auto_increment,
device_type VARCHAR(50),
description VARCHAR(50),
PRIMARY KEY (device_Id)
)


INSERT INTO `LocationTracking`.`tracking_device` (`device_id`, `device_type`, `description`) 
VALUES ('1', 'GPS', 'test');

create table tracking_detail(
tracking_id int(11) Not null auto_increment,
device_id int(11) ,
latitude VARCHAR(50)  NOT NULL,
longitude VARCHAR(50)  NOT NULL,
speed int(50)  NOT NULL,
driver_id int(11),
additionalInfo VARCHAR(50) ,
eventtime timestamp,
CONSTRAINT fk_deviceid Foreign key (device_id) references tracking_device(device_id),
PRIMARY KEY (tracking_Id)
)





INSERT INTO `LocationTracking`.`driver` (`driver_id`, `mobileno`, `latitude`, `longitude`, `speed`, `additionalInfo`, `eventtime`)
VALUES ('101', '987654320', '12', '13', '60', 'test', '2017-10-31 06:54:58');



CREATE TABLE current_location (
  driver_id INT NOT NULL,
  mobileno INT NOT NULL,
  latitude VARCHAR(45) NOT NULL,
  longitude VARCHAR(45) NOT NULL,
  speed INT NOT NULL,
  device_id INT(11) ,
  additionalInfo VARCHAR(45) NULL,
  eventtime DATETIME NOT NULL,
  PRIMARY KEY (driver_id, mobileno),
  CONSTRAINT fk_driver_1 FOREIGN KEY (device_id) REFERENCES tracking_device (device_id) ON DELETE NO ACTION
    ON UPDATE NO ACTION);



