## 📸 Application Preview

<p align="center">
  <img src="resources/Jumbo_3A.jpg" alt="Inventory View" width="23%" />
  <img src="resources/Jumbo_3B.jpg" alt="Order View" width="23%" />
  <img src="resources/Jumbo_3C.jpg" alt="Client View" width="23%" />
  <img src="resources/Jumbo_3D.jpg" alt="Ledger View" width="23%" />
</p>

## Enterprise Microservice Dashboard

> A four-tabbed unified operational portal designed to consume, aggregate, and publish real-time inventory, order, client profile, and financial ledger data across microservices.

[![Azure Cloud](https://img.shields.io/badge/Cloud-Microsoft%20Azure-0089D6?logo=microsoftazure&logoColor=white)](#)
[![Kubernetes](https://img.shields.io/badge/Orchestration-Kubernetes-326CE5?logo=kubernetes&logoColor=white)](#)
[![Spring Cloud](https://img.shields.io/badge/Architecture-Spring%20Cloud-6DB33F?logo=spring&logoColor=white)](#)
[![Backend Spring Boot](https://img.shields.io/badge/Backend-Spring%20Boot-6DB33F?logo=springboot&logoColor=white)](#)
[![Frontend AngularJS](https://img.shields.io/badge/Frontend-AngularJS-DD0031?logo=angularjs&logoColor=white)](#)

---

## 🌐 Live Application

* **Live Azure Container App:** [https://web-frontend.happybay-e6741d92.southeastasia.azurecontainerapps.io/](https://web-frontend.happybay-e6741d92.southeastasia.azurecontainerapps.io/)

---

## 📐 System Architecture & Workflow

The portal follows a distributed **Microservices Architecture** modernized with Spring Cloud components. The AngularJS single-page client issues AJAX HTTP requests through a Spring Cloud API Gateway, which handles service routing and load balancing via Netflix Eureka Discovery Server. Backend services interact directly with persistent MySQL data sources using raw JDBC for optimal query control.
```
                                         +----------------------------------+
                                         |  Eureka Discovery Server (8761)  |
                                         +----------------------------------+
                                                          ^
                                                          | Registration & Discovery
                                                          v
+------------------+     AJAX / HTTP     +----------------------------------+
|                  | ------------------> |                                  | ---> Inventory Service (8081)
| AngularJS Client |                     |   Spring Cloud API Gateway       | ---> Order Service (8082)
| (4-Tab Dashboard)| <------------------ |   (Port 9090)                    | ---> Client Service
+------------------+     JSON Data       +----------------------------------+ ---> Ledger Service
    (Port 8080)                                                                            |
                                                                                           | JDBC Persistence
                                                                                           v
                                                                                  +------------------+
                                                                                  |  MySQL Database  |
                                                                                  |  (Port 3306)     |
                                                                                  +------------------+
```

---

## ✨ Key Features & Capabilities

* **Inventory Tracking Tab:** Publishes live stock levels, item classifications, and performs dynamic backend availability checks.
* **Order & Invoice Management Tab:** Aggregates active purchase references, dynamic order statuses, and calculated invoice costs.
* **Client Profile Directory Tab:** Displays persistent client master data including user names, account IDs, and verified contact emails.
* **Financial Ledger Tab:** Visualizes financial accounting records with payment transaction amounts, dates, and execution status.
* **Background Live Stock Validation:** Executes silent polling and automated background verification for critical inventory thresholds.

---

## 🛠️ Tech Stack & Dependencies

* **Back-End:** Java JRE, Spring Boot, Spring Cloud (Gateway, Eureka Discovery)
* **Front-End:** AngularJS, JavaScript (ES5/ES6), HTML5/CSS3
* **Database & Persistence:** MySQL, JDBC
* **Cloud & Infrastructure:** Docker Desktop, Microsoft Azure Container Apps, Kubernetes (k8s)

---

## 🔌 Port Configuration & Environment Setup

| Service / Component | Default Port | Protocol / Description |
| :--- | :--- | :--- |
| **Front-End Portal** | `8080` | AngularJS Web UI |
| **API Gateway** | `9090` | Spring Cloud Gateway Routing |
| **Discovery Server** | `8761` | Eureka Registry Server |
| **Inventory Service** | `8081` | Microservice Endpoint |
| **Order Service** | `8082` | Microservice Endpoint |
| **MySQL Database** | `3306` | Central Data Source |

---

## 💻 Local Getting Started

### Prerequisites
* Java Development Kit (JDK 11+)
* Apache Maven 3.6+
* MySQL Server 8.0+
* Docker Desktop

---

### 1. Database Setup

Create the target database in MySQL:

```sql
CREATE DATABASE microservice_dashboard_db;
```

Configure application JDBC connection settings in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/microservice_dashboard_db?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=your_password
eureka.client.service-url.defaultZone=http://localhost:8761/eureka/
```

---

### 2. Run Infrastructure & Microservices

Run the services in the following order:

```bash
# 1. Start Eureka Discovery Server (Port 8761)
cd discovery-server
./mvnw spring-boot:run

# 2. Start API Gateway (Port 9090)
cd ../api-gateway
./mvnw spring-boot:run

# 3. Start Backend Services (Ports 8081, 8082)
cd ../inventory-service
./mvnw spring-boot:run
```

---

### 3. Run Frontend Application

Launch the AngularJS portal on port 8080:

```bash
cd ../frontend-ui
# Serve using preferred HTTP server or Maven container wrapper
python3 -m http.server 8080
```

Access dashboard locally at `http://localhost:8080`.

---

## 🚀 Cloud Deployment

1. **Docker Containerization:** Dockerfile specs build images for Eureka, API Gateway, Microservice nodes, and AngularJS web server.
2. **Kubernetes Orchestration:** Cluster manifests configure ingress controllers and internal cluster IP routing.
3. **Azure Container Apps:** Deployed directly onto Azure Container Apps environment with auto-scaling enabled.