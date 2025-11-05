# Connex - Fullstack Project (Boilerplate)

Structure:
- backend/  — Spring Boot backend (Java 21, Maven)
- frontend/ — Vite + React + TypeScript + Tailwind
- infra/    — docker-compose & DevOps learning docs

Quickstart (recommended dev flow):
1. Backend
   - cd backend
   - mvn -DskipTests package
2. Frontend (dev)
   - cd frontend
   - npm install
   - npm run dev
3. Or full stack with Docker:
   - cd infra
   - docker-compose up --build
4. Set `JWT_SECRET` env var (in infra/docker-compose.yml or your environment) to a secure value (>=32 chars).
5. Signup: POST /api/v1/auth/signup with JSON { "username":"test", "password":"pass" }
6. Login: POST /api/v1/auth/login -> returns { token: "..." } store it in localStorage under "token"
7. Connect WebSocket (frontend example does this): the client connects to ws endpoint with token as query param. The backend requires token for WS.

Notes:
- MapStruct requires annotation processing during build; run mvn package to generate mappers.
- Tests: backend includes Testcontainers deps. Expand tests under src/test to use containers.

If you want, I can:
- Add concrete integration tests that run signup->login->verify JWT and DB writes using Testcontainers.
- Harden production configs and add Kubernetes manifests.
