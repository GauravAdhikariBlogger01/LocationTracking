## Setup
-  Mysql 5.7
-  java 1.8
-  eclipse IDE
-  maven


##Build Instruction

1-Navigate to project directory through command prompt
2-mvn clean install
3-mvn spring-boot : run


##Access


1-http://localhost:8084 , Home page(jsp)


post request
2-http://localhost:8084/add

{
 "deviceId":"1",
  "latitude":"1",
  "longitude":"2",
  "speed":"20",
  "additionalInfo":"test"
}

get request
3-http://localhost:8084/getCall/{pass deviceid}

get request
4-http://localhost:8084/getCall/{starttime}/{enddate}



