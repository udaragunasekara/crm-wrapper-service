# Contract First Api design demonstration

1. Api design is done in swagger-hub and can be found in the following url

https://app.swaggerhub.com/apis/udaragunasekara9/crm-api-design/1.0.0

The exported open api schema definition can be found in the /resources/design/openapi.yml 

2. High level proposed architecture for implementing the this project can be found /resources/design/high-level-design.yml file

There is an api gateway sitting in front of the crm wrapper microservice which encapsulate any transformation logic to communicate with the legacy crm application. 

3. For securing the application JWT token based security is suggested. Microservice will use the JWT token to authenticate and authorise requests. 
All requests coming from the api gateway should carry the 'Authorize' header with the 'Bearer' jwt token. Client applications can obtain the jwt token via the OAuth2 Authorization 
grant flow mechanism from a OAuth2 authorization server. This set up is described in the high level architecture.

For the demonstration purposes, crm-wrapper-service has implemented jwt authentication filter. But in a proper set up this filter will talk to the central ouath2 server to obtain the public key to validate the jwt token. 

This setup reduce the need for auth server being referred for each down stream request.





