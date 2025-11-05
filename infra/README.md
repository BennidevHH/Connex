# Infra (docker-compose) & DevOps learning

This folder contains the docker-compose configuration to run the full Connex stack for development.

Services:

- mysql: MySQL 8 for user/auth data
- mongo: MongoDB for chat data
- backend: Java Spring Boot backend (built from ../backend)
- frontend: Vite React app (built from ../frontend)

How to run locally:

1. Build backend jar (from /backend): mvn -DskipTests package
2. Build frontend (from /frontend):
   - npm install
   - npm run build
   - (optional) to run in dev mode: npm run dev
3. From /infra: docker-compose up --build

Environment variables:

- MYSQL_USER, MYSQL_PASSWORD, MYSQL_JDBC_URL — used by backend
- MONGODB_URI — MongoDB connection string
- JWT_SECRET — set a secure secret (at least 32 chars)
- VITE_BACKEND_URL — frontend will use this to contact backend

Notes & learning:

- The docker-compose orchestrates containers for local dev. In CI/CD you'll want separate deployments (Kubernetes, ECS, etc).
- For production: use a managed DB (RDS/Cloud SQL + Atlas), use secrets manager, use an external STOMP broker (RabbitMQ) or Redis for scaling WebSocket sessions.
