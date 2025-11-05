# Connex - Backend (Boilerplate)

This scaffold is a starting point for the Connex backend:

- Java 21, Spring Boot
- MySQL for user/auth data
- MongoDB for chat/messages
- WebSocket STOMP for realtime chat
- JWT placeholder (replace with real JWT implementation)

How to run (dev) locally:

1. Configure environment variables if needed or use the defaults in docker-compose.yml
2. Build: mvn -DskipTests package
3. Start services: docker-compose up --build
4. Backend will be available at http://localhost:8080
5. WebSocket endpoint: ws://localhost:8080/ws (SockJS + STOMP)

Notes:

- Replace the placeholder JWT generation in AuthController with a proper JWT util (we can add that next).
- Consider Testcontainers for integration tests.

## Added features

- JWT authentication (real token generation + validation)
- Service layer for user management
- DTOs and MapStruct mapper example
- WebSocket handshake interceptor that can read token from query param `?token=...`
- Testcontainers skeleton for integration testing