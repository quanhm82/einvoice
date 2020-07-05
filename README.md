# Getting Started

### Introduction
eInvoice service expose APIs (HATEOAS) for read/save resources such as Invoice. Swagger-ui is rendered at runtime to make it easier to call APIs.


### Guides
Building jar file by maven
```sh
$ mvn clean install
```
Starting eOrder instance with "dev" profile.
```sh
$ cd target
...
$ java -jar e-invoice-{version}.jar --spring.profiles.active=dev
```
Access eInvoice by http://localhost:9899/swagger-ui.html

### Noted CURL
-Create an Invoice
```sh
curl -X POST "http://localhost:9899/invoice" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"customerName\": \"George Bane\", \"orderId\": \"order_id\", \"status\": \"init\", \"totalAmount\": 700}"
```
-Update Invoice Status to confirmed
```sh
curl -X PATCH "http://localhost:9899/invoice/invoice_id" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"status\": \"confirmed\"}"
```