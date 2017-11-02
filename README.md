## Setup
-  Mysql 5.7
-  java 1.8
-  eclipse IDE
-  maven


##Build Instruction

-Navigate to project directory through command prompt
-mvn clean install
-mvn spring-boot : run


##Accessing web service


-http://localhost:8084 , Home page(jsp)


post request
-http://localhost:8084/add

{
 
 "deviceId":"2",
  "latitude":"10",
  "longitude":"8",
  "speed":"20",
  "mobileNumber":"123489",
  "driverId":"2",
  "additionalInfo":"test"
}

get request
-http://localhost:8084/getCall/{pass deviceid}

get request
-http://localhost:8084/getCall/{starttime}/{enddate}


## WebService Access for Scenario Current Location 

Post

-http://localhost:8084/addDriverDevice/

Data set

{
 
 "deviceId":"2",
  "latitude":"09",
  "longitude":"80",
  "speed":"20",
  "mobileNumber":"123489",
  "driverId":"2",
  "additionalInfo":"test"
}

##WebService for get call

-/getCall/{starttime}/{endtime}

-/getCall/{deviceid}

-/getCall/{starttime}/{endtime}/{deviceId}

-/getCall/{starttime}/{endtime}/{deviceId}/{driverId}


