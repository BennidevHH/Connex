import { Routes, Route, Navigate } from "react-router-dom";
import LoginPage from "./pages/Login";
import HomePage from "./pages/Home";
import NotFoundPage from "./pages/NotFound";

export default function App() {
  // Hier könntest du Auth-Status aus Context oder localStorage/checkToken holen
  const isAuthenticated = !!localStorage.getItem("accessToken");

  return (
    <Routes>
      {/* Wenn nicht eingeloggt: zeige Login */}
      <Route
        path="/"
        element={
          isAuthenticated ? <Navigate to="/home" replace /> : <LoginPage />
        }
      />
      {/* Geschützte Seite */}
      <Route
        path="/home"
        element={
          isAuthenticated ? <HomePage /> : <Navigate to="/" replace />
        }
      />
      {/* 404 */}
      <Route path="*" element={<NotFoundPage />} />
    </Routes>
  );
}