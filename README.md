# Connect Spring Sample
[![Java CI with Maven](https://github.com/enosix/connect-spring-sample/actions/workflows/maven.yml/badge.svg)](https://github.com/enosix/connect-spring-sample/actions/workflows/maven.yml)

## Description
The Connect Spring Sample is a Spring Boot MVC application as a demonstration of the [enosix SAP Front-End Integration solution](https://enosix.com/sap-front-end-integration/). The application makes use of the [EnosixCustomer API endpoint](https://apis.connect.enosix.io/index.html#operations-_-_EnosixCustomer_Search-Search_EnosixCustomer_Search). 

## Running the example
The sample is built on JDK 11 using Spring Boot 2.7.3. The steps to execute the example running against your environment are:
1. Deploy an application with the `EnosixCustomer Search` API in [enosix Connect](https://console.connect.enosix.io) using PassThrough authentication.
  - Assume the url to the deployed application is https://my-deployed-app.cfapps.us10.hana.ondemand.com
2. Configure the [application.properties](src/main/resources/application.properties) `enosix.rest` properties  
```
enosix.rest.username=<username_to_your_SAP>
enosix.rest.password=<password_to_your_SAP>
enosix.rest.root-uri=https://my-deployed-app.cfapps.us10.hana.ondemand.com/api
```
3. Run the sample from your editor of choice (a dev container file is provided to make working in VSCode simpler), or using the Maven command `mvn spring-boot:run`
4. Open https://localhost:8080 to see the list of customers retrieved from your SAP system

## Anatomy of the sample
- Data Transfer Objects (DTOs) used for communicating with your deployed Connect app are located in the [dtos package](src/main/java/io/enosix/connect/dtos). They were generated from the JSON schema provided at https://my-deployed-app.cfapps.us10.hana.ondemand.com/swagger/v1/swagger.json and were created using [JSON2CSharp's JSON to POJO converter](https://json2csharp.com/code-converters/json-to-pojo).
- API calls made to the Connect app are handled via a RestTemplate with the root uri, authorization, and content type headers configured in the [RestConfig.java](/src/main/java/io/enosix/connect/configuration/RestConfig.java).
- The requests to the Connect app are abstracted from the [CustomerController](/src/main/java/io/enosix/connect/controllers/CustomerController.java) using an injected [CustomerService](/src/main/java/io/enosix/connect/services/CustomerServiceImpl.java). This service also does the simple mapping form the [EnosixCustomerSearch.Result](/src/main/java/io/enosix/connect/dtos/enosixCustomerSearch/response/Result.java) to the [Customer resource](/src/main/java/io/enosix/connect/resources/Customer.java) used by the MVC model.
