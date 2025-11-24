// import { Input } from "../ui/input";
// import { Button } from "../ui/button";
// import api from "../../lib/api";
// import { setTokens } from "../../lib/auth";
// import { useNavigate } from "react-router-dom";

// export default function LoginForm() {
//   const [email, setEmail] = useState("");
//   const [password, setPassword] = useState("");
//   const [loading, setLoading] = useState(false);
//   const [error, setError] = useState<string | null>(null);
//   const navigate = useNavigate();

//   async function onSubmit(e: React.FormEvent) {
//     e.preventDefault();
//     setLoading(true);
//     setError(null);
//     try {
//       const res = await api.post("/auth/login", { email, password });
//       const { accessToken, refreshToken } = res.data;
//       setTokens(accessToken, refreshToken);
//       navigate("/home");
//     } catch (err: any) {
//       setError(err.response?.data?.message ?? "Fehler beim Anmelden");
//     } finally {
//       setLoading(false);
//     }
//   }

//   return (
//     <form onSubmit={onSubmit} className="space-y-4">
//       <Input
//         label="E-Mail"
//         type="email"
//         value={email}
//         onChange={e => setEmail(e.target.value)}
//         required
//       />
//       <Input
//         label="Passwort"
//         type="password"
//         value={password}
//         onChange={e => setPassword(e.target.value)}
//         required
//       />
//       {error && (
//         <div className="text-red-600 text-sm">
//           {error}
//         </div>
//       )}
//       <Button type="submit" disabled={loading}>
//         {loading ? "Anmelden..." : "Anmelden"}
//       </Button>
//     </form>
//   );
// }