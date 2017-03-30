# spring-cloud

This project contains implementation taken from "http://callistaenterprise.se/blogg/teknik/2015/05/20/blog-series-building-microservices/" and some of my implementation. The whole project contains following:

1. discovery-server: This is the generic discovery server where all services register.
2. edge server: The front server for all incoming request.
3. monitor-dashboard: This contains monitor dashboard. Plain and simple.
4. OAuthServer: This is where OAuth2.0 is implemented. It validates user from database however for simplicity most of the things are hard-coded.
5. product-composite-service: This is front-end service and internally calls product-service for actual implementation. Please note that this service is secured with OAuth 2.0.
6. product-service: This service is where actual implementation of product is there. The return is hard coded but can be extended to get data from database.
7. vik-service: This service is a dummy service which is unsecured.


How to Use:

To get token call following url:
http://my-client-with-secret:secret@localhost:9999/uaa/oauth/token
with following data:
{"grant_type":"password"}
{"username":"roy"}
{"password":"password"}
{"Content-Type":"application/x-www-form-urlencoded"} and
{"charset":"utf-8"}

Calling of above will give a token in return. The token acquired will be used to call following service (this is secured web service):
http://localhost:8765/productcomposite/product/1

with following data set in header:
{"Accept":"application/json"}
{"Authorization":"Bearer <Token from above call>"}


The unsecured service is called like this:
http://localhost:8765/vikash/vik
