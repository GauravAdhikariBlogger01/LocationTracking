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

2-http://localhost:8084/add


## Useful Snippets and References


created database schema,
1-Table holds details of all asset
2-Used to store all detail publish by Iot devices. for the time being we are using mysql database,
MongoDB will be more prefarable for this task.Because Data push by IOT device will gradually increase and in future if we required to add new field or information.if we have to capture from devices so it can be easily added to our reporting data source.

From My SQL 5.7 onwards a new  "json" has to be added, which can use if required in future to add more data.

First task:

created a restful web service, which are exposed to IOT devices, IOT devices or asset will publish their data to the exposed web service.
All devices need to be register in master table with specified details

Post  http://localhost:8084/add

Body

{
 "deviceId":"1",
  "latitude":"1",
  "longitude":"2",
  "speed":"20",
  "additionalInfo":"test"
}

#######################################################################################

