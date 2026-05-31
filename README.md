# Stock Trading Order Engine

## Overview

Stock Trading Order Engine is a Spring Boot REST API application that simulates a stock trading platform. Users can create accounts, manage stocks, place buy and sell orders, execute trades, and view trade history.

The project follows a layered architecture using Controller, Service, Repository, DTO, Entity, Exception Handling, and Utility classes.

---

## Technologies Used

* Java 17
* Spring Boot 3.5.14
* Spring Web
* Spring Data JPA
* MySQL
* Lombok
* ModelMapper
* Swagger OpenAPI
* Maven

---

## Features

* User Management
* Stock Management
* Buy Order Placement
* Sell Order Placement
* Order Cancellation
* Order Tracking
* Trade Execution
* Trade History
* Global Exception Handling
* Swagger Documentation
* DTO-Based API Design

---

## Project Structure

stock-trading-order-engine

src/main/java/com/example/stocktrading

config

* ModelMapperConfig
* SwaggerConfig

controller

* UserController
* StockController
* OrderController
* TradeController

dto

* UserRequestDto
* UserResponseDto
* OrderRequestDto
* OrderResponseDto
* TradeResponseDto
* StockResponseDto

entity

* User
* Stock
* Order
* Trade
* OrderType
* OrderStatus

exception

* ResourceNotFoundException
* OrderNotFoundException
* InsufficientBalanceException
* GlobalExceptionHandler

repository

* UserRepository
* StockRepository
* OrderRepository
* TradeRepository

service

* UserService
* StockService
* OrderService
* TradeService
* MatchingEngineService

serviceimpl

* UserServiceImpl
* StockServiceImpl
* OrderServiceImpl
* TradeServiceImpl
* MatchingEngineServiceImpl

util

* OrderBookUtil

---

## Database Setup

Create MySQL Database:

```sql
CREATE DATABASE stockdb;
```

---

## application.yml

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/stockdb
    username: root
    password: root

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true

server:
  port: 8080
```

---

## API Endpoints

### User APIs

Create User

POST

```http
http://localhost:8080/users
```

Request

```json
{
  "name": "Swathi",
  "balance": 100000
}
```

Get All Users

GET

```http
http://localhost:8080/users
```

---

### Stock APIs

Create Stock

POST

```http
http://localhost:8080/stocks
```

Request

```json
{
  "symbol": "AAPL",
  "companyName": "Apple Inc",
  "currentPrice": 200
}
```

Get All Stocks

GET

```http
http://localhost:8080/stocks
```

---

### Order APIs

Place Buy Order

POST

```http
http://localhost:8080/orders/buy
```

Request

```json
{
  "userId": 1,
  "stockId": 1,
  "price": 200,
  "quantity": 100
}
```

Place Sell Order

POST

```http
http://localhost:8080/orders/sell
```

Request

```json
{
  "userId": 1,
  "stockId": 1,
  "price": 200,
  "quantity": 100
}
```

Cancel Order

DELETE

```http
http://localhost:8080/orders/1
```

Get User Orders

GET

```http
http://localhost:8080/orders/user/1
```

---

### Trade APIs

Get Trades By Stock

GET

```http
http://localhost:8080/trades/stock/AAPL
```

Response

```json
[
  {
    "id": 1,
    "price": 200,
    "quantity": 100
  }
]
```

---

## Swagger Documentation

```http
http://localhost:8080/swagger-ui/index.html
```

---

## Build Project

```bash
mvn clean install
```

Run Application

```bash
mvn spring-boot:run
```

---

## Sample Trade Flow

1. Create User
2. Create Stock
3. Place Buy Order
4. Place Sell Order
5. Matching Engine Executes Trade
6. Trade Stored in Database
7. View Trade History

---

## Future Enhancements

* JWT Authentication
* Spring Security
* Role Based Access Control
* Kafka Integration
* Docker Deployment
* Unit Testing
* Integration Testing
* Real-Time Stock Updates

---

## Author

Swathi Palla

Stock Trading Order Engine Project using Spring Boot, MySQL, JPA, Lombok, Swagger, DTO, Repository Pattern, and REST APIs.
