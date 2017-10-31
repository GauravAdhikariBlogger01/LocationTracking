create database LocationTracking;

use LocationTracking;

create table Tracking_Device(
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
additionalInfo VARCHAR(50) ,
eventtime timestamp,
Constraint fk_deviceid Foreign key (device_id) references tracking_device(device_id),
PRIMARY KEY (tracking_Id)
)