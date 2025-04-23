# Patient Management System

A backend-focused, cloud-ready *Java microservices platform* designed to manage patient data and healthcare-related workflows. The system is composed of secure, containerized microservices for *patient management, **billing, **analytics, and **authentication, communicating via **gRPC* and *Apache Kafka, and orchestrated through a centralized **API Gateway*.

## 🧩 Architecture Overview

This project follows a *microservices architecture*, where each service handles a specific domain:

- *Auth Service* – Handles user login, JWT authentication, and token validation  
- *Patient Service* – Manages patient data (create, update, delete, get)  
- *Billing Service* – Processes billing accounts through a gRPC server  
- *Analytics Service* – Consumes Kafka events and processes patient analytics  
- *API Gateway* – Central entry point with routing, security filters, and request handling  

All services are containerized with *Docker* and designed for deployment on *AWS ECS, tested locally using **LocalStack*.

## 🚀 Technologies Used

| Layer                 | Stack & Tools                                              |
|----------------------|------------------------------------------------------------|
| Language             | *Java 21*                                                |
| Framework            | Spring Boot, Spring Security                               |
| Inter-Service Comm.  | gRPC, Apache Kafka                                         |
| Auth & Security      | JWT, Spring Security                                       |
| Infrastructure       | Docker, AWS ECS, RDS, MSK, ALB, LocalStack                 |
| API Gateway          | Spring Cloud Gateway                                       |
| Project Build        | Maven                                                      |

## 📁 Project Structure


project-root/
│
├── auth-service/             # JWT-based authentication service
│   ├── src/main/java/com/pm/authservice/
│   │   ├── config/           # Spring Security configuration
│   │   ├── controller/       # AuthController (login, token)
│   │   ├── dto/              # LoginRequestDTO, LoginResponseDTO
│   │   ├── model/            # User entity
│   │   ├── repository/       # UserRepository
│   │   └── service/          # AuthService, UserService
│   └── Dockerfile
│
├── patient-service/          # Patient CRUD operations and Kafka publisher
│   ├── src/main/java/com/pm/patientservice/
│   │   └── ...               # Controller, Service, Repository layers
│   └── Dockerfile
│
├── billing-service/          # gRPC-based billing account service
│   ├── src/main/java/com/pm/billingservice/
│   │   └── grpc/             # gRPC server logic
│   ├── proto/                # billing_service.proto
│   └── Dockerfile
│
├── analytics-service/        # Kafka consumer processing patient events
│   ├── src/main/java/com/pm/analyticsservice/
│   │   └── kafka/            # Kafka listener logic
│   ├── proto/                # patient_event.proto
│   └── Dockerfile
│
├── api-gateway/              # Spring Cloud Gateway for routing and filtering
│   ├── src/main/java/com/pm/apigateway/
│   └── Dockerfile
│
├── grpc-requests/            # Sample gRPC client requests (e.g., billing-service)
├── api-requests/             # Sample HTTP requests (REST endpoints)
│
├── docker-compose.yml        # Optional: Compose file for local orchestration
├── README.md
└──




## 🔒 Security

- *JWT Authentication* handled by the Auth Service  
- *API Gateway Filters* for request validation and token propagation  
- *Role-based access* control (RBAC) where applicable  

## 🐳 Deployment

Each service includes a Dockerfile and is designed for deployment using:

- *Docker* for containerization  
- *AWS ECS* for container orchestration  
- *RDS* for relational data storage  
- *MSK (Kafka)* for asynchronous messaging  
- *ALB (Application Load Balancer)* for service exposure  
- *LocalStack* for local AWS simulation and infrastructure testing  

---

## 🛠️ Future Enhancements:

- High-Performance API Caching with Redis  
- React UI with TanStack   
- Real-Time Monitoring with Prometheus & Grafana
