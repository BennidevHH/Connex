import ErrorLayout from "../layouts/ErrorLayout";
import { Button } from "../components/ui/button";
import { Link } from "react-router-dom";

export default function NotFoundPage() {
  return (
    <ErrorLayout>
      <div className="text-center p-8">
        <h1 className="text-5xl font-bold mb-4">404</h1>
        <p className="mb-6">Seite nicht gefunden</p>
        <Link to="/">
          <Button>Zur Startseite</Button>
        </Link>
      </div>
    </ErrorLayout>
  );
}