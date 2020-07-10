# spring-mongodb-multitenant
Sample implementation of multi tenant with spring boot and mongo-db

## Start MongoDB with docker

`docker run --name mongo -d mongo:4.2.8-bionic`

## Tenants

application.properties configures two tenants: localhost and 127.0.0.1

Access sample by http://localhost:8080/users or http://127.0.0.1:8080/users
