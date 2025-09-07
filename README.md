# 💳 Banking Application - Full Stack

A secure, scalable banking system built using microservices architecture with a modern Angular frontend and Spring Boot backend services. The application provides authentication, KYC onboarding, account management, transactions, and real-time notifications.

---

## 🚀 Features

### 🌐 Frontend (Angular)

* **Dashboard**: Real-time balances, statistics, and recent transactions
* **Customer Management**: Profile update, KYC uploads, and verification tracking
* **Account Management**: Open savings/current accounts, view balances, debit/credit actions
* **Transactions**:

  * Internal transfers between user accounts
  * External transfers to other banks
  * Transaction history and paginated statements
* **Admin Panel**: KYC approval and customer management
* **Authentication**: Secure login with JWT tokens
* **Notifications**: Real-time SMS/Email alerts
* **Responsive Design**: Mobile-first UI with Angular Material + Bootstrap

### ⚙️ Backend (Spring Boot Microservices)

* **Auth Service (8084)**: User registration, login, and JWT issuance
* **Customer Service (8081)**: Customer profiles and KYC document management
* **Account Service (8094)**: Account creation, debit/credit operations
* **Transaction Service (8089)**: Internal & external transfers, statements, and history
* **Notification Service (8085)**: Email & SMS notifications
* **Audit & Logging**: Activity tracking for compliance
* **Kafka Integration**: Event-driven communication

---

## 🛠️ Technology Stack

### Frontend

* Angular 17
* Angular Material
* Bootstrap 5
* RxJS & TypeScript
* SCSS

### Backend

* Spring Boot (Java)
* Spring Security + JWT
* Spring Data JPA (Hibernate)
* MySQL Database
* Kafka (for events)
* RESTful APIs with Swagger UI

---

## 📋 Prerequisites

* **Node.js** (v18+) & **npm** (v9+)
* **Angular CLI** (v17+)
* **Java 17+**
* **Maven/Gradle**
* **MySQL 8+**
* **Kafka & Zookeeper**

---

## 🚀 Installation & Setup

### Frontend

```bash
git clone <repo-url>
cd banking-application-frontend
npm install
ng serve
```

App available at: **[http://localhost:4200](http://localhost:4200)**

### Backend (each service runs separately)

```bash
cd banking-application-backend/<service-name>
mvn spring-boot:run
```

**Services run on**:

* Auth → **8084**
* Customer → **8081**
* Account → **8094**
* Transaction → **8089**
* Notification → **8085**

### Database Setup

* Create a MySQL DB `bankdb`
* Update credentials in each service’s `application.properties`

### Kafka Setup

```bash
zookeeper-server-start.sh config/zookeeper.properties
kafka-server-start.sh config/server.properties
```

---

## 🏗️ Project Structure

```
banking-application/
├── frontend/                     # Angular Frontend
│   ├── src/app/components/       
│   │   ├── dashboard/
│   │   ├── customers/
│   │   ├── accounts/
│   │   ├── transactions/
│   │   ├── admin/
│   │   └── auth/
│   └── ...
└── backend/                      # Spring Boot Microservices
    ├── auth-service/             # User registration & JWT
    ├── customer-service/         # Profiles & KYC
    ├── account-service/          # Account operations
    ├── transaction-service/      # Transfers & history
    ├── notification-service/     # Emails & SMS
    └── common-libs/              # Shared modules
```

---

## 🔧 API Examples

**Register a new user (Auth Service – 8084)**

```bash
curl -X POST http://localhost:8084/auth/register \
-H "Content-Type: application/json" \
-d '{"email":"user1@bank.test","password":"user123"}'
```

**Create Customer Profile (Customer Service – 8081)**

```bash
curl -X POST http://localhost:8081/customers \
-H "Authorization: Bearer <USER_TOKEN>" \
-d '{"fullName":"John Doe","email":"user1@bank.test","phone":"9998887777"}'
```

**Open Account (Account Service – 8094)**

```bash
curl -X POST http://localhost:8094/accounts \
-H "Authorization: Bearer <USER_TOKEN>" \
-d '{"customerId":1,"type":"SAVINGS"}'
```

**Internal Transfer (Transaction Service – 8089)**

```bash
curl -X POST http://localhost:8089/transactions/internal \
-H "Authorization: Bearer <USER_TOKEN>" \
-d '{"fromAccountId":1,"toAccountId":2,"amount":1000}'
```

---

## 🔒 Security Features

* JWT-based authentication
* Role-based access control (Admin/User)
* KYC checks for onboarding
* XSS/CSRF protection
* Encrypted communication (HTTPS-ready)

---

## 📊 Performance Optimization

* Frontend lazy loading
* Backend microservices scaling
* Kafka for asynchronous messaging
* Caching strategies for faster responses

---

## 📦 Deployment

### Frontend

```bash
ng build --configuration production
```

Deploy `dist/banking-application-frontend` on **Netlify/Vercel/Nginx**.

### Backend (Docker Compose)

```bash
docker-compose up --build
```

**docker-compose.yml**

```yaml
version: "3.9"
services:
  auth-service:
    build: ./backend/auth-service
    ports: ["8084:8084"]

  customer-service:
    build: ./backend/customer-service
    ports: ["8081:8081"]

  account-service:
    build: ./backend/account-service
    ports: ["8094:8094"]

  transaction-service:
    build: ./backend/transaction-service
    ports: ["8089:8089"]

  notification-service:
    build: ./backend/notification-service
    ports: ["8085:8085"]
```

---

## 🤝 Contributing

1. Fork the repo
2. Create a feature branch
3. Add changes + tests
4. Submit a PR

---

## 📄 License

Licensed under **MIT License**.

