# base64diff

## https://app.swaggerhub.com/apis/rantidev1/api-documentation/1.0

This project is created as per the requirements of the assignment provided by WAES.
The purpose of this project is to compare the base64 encoded binary data via the
REST API which accepts/produces JSON input/output. 

### Design Principles :
This api has been developed using SOLID design principles. More info about SOLID 
design principles can be found on https://en.wikipedia.org/wiki/SOLID

### Requirements:
	
The assignment

• Provide 2 http endpoints that accepts JSON base64 encoded binary data on both endpoints

	o <host>/v1/diff/<ID>/left and <host>/v1/diff/<ID>/right
• The provided data needs to be diff-ed and the results shall be available on a third end point
	o <host>/v1/diff/<ID>
	
• The results shall provide the following info in JSON format

	o If equal return that
	o If not of equal size just return that
	o If of same size provide insight in where the diffs are, actual diffs are not needed.
		§ So mainly offsets + length in the data
• Make assumptions in the implementation explicit, choices are good but need to be communicated

## Tech Stack

* Since I am java programmer and I've been using spring framework from past 9 years . The choice was quite obvious to use Spring Boot .
Other than spring boot , maven , junit, docker , lombok, h2 database, swagger, apache commons, tomcat were used. 

## Installation

This project is java-based. So It requires Jdk 11 (or later) and Maven 3.6.3 (or later)  to run.

```sh
$ cd base64diff
$ mvn package
$ java -jar target/base64-diff-api-1.0.0.jar 
```
Another way to run this api is to use docker (latest image is already pushed to docker hub)

```sh
$ docker run -p 8080:8080 rantidev7/base64-diff-api:latest

```
Or if there is need to build new image then it can also be build and pushed to 
docker hub via 

```sh
$ cd base64diff
$ mvn jib:build
```
And then run 
```
$ docker run -p 8080:8080 rantidev7/base64-diff-api:latest
```


## Running tests
After changes you can run tests using Maven command:
```sh
$ cd base64diff
$ mvn test
```

## Rest API

 As required, this API has three endpoints :
  1. /v1/diff/{id}/left
  2. /v1/diff/{id}/right
  3. /v1/diff/{id}

## Testing API
1. API can be tested using Postman/Soap Ui
2. Swagger is also included in api , I would suggest to use swagger then there is no need to perform extra work.

## Things included in current version :
1. JavaDocs are aslo included, to generate javadocs use 
	```
	$cd base64diff
	$ mvn javadoc:javadoc
	```
	Then go to the folder /target/site/apidocs

2. Googles code convention is being forced via the checkstyle.xml.
3. Swagger is included and automatic updation of swagger specification is done.

## Things to be included in future version :
1. There should be another version of API for example V2 where user can post left and right side of 
	data in one api call.
2. CI/CD should also be implemented for this api.
3. If we want to move to microservioces architecture then probably we can look for Netflix OSS
    (apigateway , service descovery , cloud config etc.)
4. Current version doen't support maven/spring profiles , which needs to be implemented.
