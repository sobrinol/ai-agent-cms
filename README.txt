# 🧠 AI Agent CMS - Booking Management System

This is a full-stack **AI-enabled booking CMS** built using **Spring Boot** (Java) for the backend and **React** (with Vite + Tailwind CSS) for the frontend. It allows users (or AI agents) to create, view, and manage client bookings.

## 🚀 Features

- 📅 Create and store booking records (name, date, time, contact info)
- 📜 View all bookings in a clean, sortable table
- ⏳ Bookings are listed from soonest to latest
- 🔄 REST API for frontend/backend communication
- 🌐 CORS enabled for frontend at `http://localhost:5173`
- 📊 Ready for extension with dashboards, charts, and calendar visualizations

## 🛠️ Tech Stack

### Backend
- Java 21
- Spring Boot 3.5
- Spring Web, JPA, PostgreSQL
- Jackson (for JSON serialization)
- HikariCP (connection pooling)

### Frontend
- React + TypeScript
- Vite
- Tailwind CSS

## 📦 Project Structure

ai-agent-cms/
├── backend/
│   ├── controller/       # BookingController.java
│   ├── model/            # Booking.java (JPA entity)
│   ├── repository/       # BookingRepository.java
│   ├── service/          # BookingService.java
│   └── application       # BackendApplication.java
│
├── frontend/
│   ├── src/
│   │   └── BookingList.tsx
│   │   └── App.tsx
│   │   └── index.tsx
│   └── vite.config.ts
│
└── README.md

## 🧑‍💻 Getting Started

### 🔧 Prerequisites
- Java 21+ - https://adoptium.net/
- Node.js 18+ - https://nodejs.org/en/download
- VSCode
 - Extensions:
   -Extension Pack for Java
   -Spring Boot Tools
- Supabase - https://supabase.com/
- Maven

### 🗃️ Setup Database

Access Supabase

Create `application.properties` in resources folder and configure:

spring.application.name=backend
spring.datasource.url=jdbc:postgresql://aws-0-us-east-2.pooler.supabase.com:5432/postgres?sslmode=require
spring.datasource.username=postgres.rdccdpssywybpkullfrt
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.show-sql=true

## ▶️ Running the App

### Backend

Open terminal in project folder and run:

cd backend
./mvnw spring-boot:run

### Frontend

Open terminal in project folder and run:

cd frontend
npm install
npm run dev


Visit the frontend at: [http://localhost:5173](http://localhost:5173)

## 📬 API Endpoints

| Method | Endpoint             | Description               |
|--------|----------------------|---------------------------|
| GET    | `/api/bookings`      | Get all bookings          |
| POST   | `/api/bookings`      | Create a new booking      |

Request body example:
{
  "client_name": "Luis",
  "email": "luis@example.com",
  "phone": "1234567890",
  "address": "123 Main St",
  "booking_date": "2025-06-06",
  "booking_time": "14:00"
}

## 📈 Upcoming Features

- 📆 Calendar view of bookings
- 📊 Business insights & charts
- 🔐 Authentication (JWT or OAuth2)
- 👥 Multi-business support (multi-tenancy)
- 🎙️ AI voice agent integration

## ✨ Author

Created by **Luis S.**
