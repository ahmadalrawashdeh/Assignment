# RESTful API Assignment


## Configuration:
To setup the environment, please install the following:
- _Maven_ (apache-maven-3.8.6) [https://maven.apache.org/install.html]
- _Httpie_ (version 3.2.1) [https://httpie.io/docs/cli/installation]
- _Java 18_ (jdk-18.0.2.1) [https://openjdk.org/install/]

##### Other information:
General information about the project:
- _Spring Boot_ version: 2.7.3
- Added dependencies to the _Spring Boot_ project:
-- _Lombok_
-- _Spring Web_
-- _Validation_

## Testing the project:

Navigate to the root directory, this directory contains a set of other directories and files such as: "_src_" directory and "_pom.xml_" file.

To run all tests, for Windows operating system, please type in the terminal:

```sh
> mvn test
```

for Linux, use the following command:

```sh
~$ ./mvnw test
```

## Running the project:

To run the project, for Windows, type in the terminal:

```sh
> mvn spring-boot:run
```

for Linux, use the following command:

```sh
~$ ./mvnw spring-boot:run
```

## HTTP verbs:

### GET

After running the project, to generate new shipment with unique id, in the terminal, please type:

```sh
http :8080/shipments/new
```

Or, using your favorite web browser, please go to:
http://localhost:8080/shipments/new




### POST

To post new shipment, for each of the following cases, please type in the terminal (Examples of different scenarios):

##### Valid test case:

Two examples of valid cases, notice that the "_correct_" field is equal to "_true_":

```sh
http POST :8080/orders carrierID=fedex width=10 length=20 height=30 weight=40 serviceID=fedexGround
```

```sh
http POST :8080/orders carrierID=ups width=10 length=20 height=30 weight=40 serviceID=UPSExpress
```

##### Inconsistent carrierID and serviceID:

An example of invalid case, in this example, the "_serviceID_" must be equal to "_fedexGround_" or "_fedexAIR_" because "_carrierID_" is equal to "_fedex_", as a result, the "_correct_" field is "_false_":

```sh
http POST :8080/orders carrierID=fedex width=10 length=20 height=30 weight=40 serviceID=UPS2DAY
```

##### Negative value:

An example of wrong values, in this example, a negative value is set for "_width_"):

```sh
http POST :8080/orders carrierID=ups width=-10 length=20 height=30 weight=40 serviceID=UPSExpress
```

##### Null field:

An example of setting "_null_" to some fields ("_serviceID_" in this example):

```sh
http POST :8080/orders carrierID=ups width=10 length=10 height=30 weight=40 serviceID=
```

##### Setting the values of all fields:

An example of setting the values of all fields, in this example, we also set the values for "_id_", "_userId_", and "_email_":

> Note: we can also set the value of the "_name_" field, but it is not a part of the JSON object.

```sh
http POST :8080/orders id=1000 userId=2000 email=hello@example.com carrierID=ups width=10 length=20 height=30 weight=40 serviceID=UPS2DAY
```






