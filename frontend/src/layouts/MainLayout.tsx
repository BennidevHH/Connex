import React from "react";

export default function MainLayout({ children }: { children: React.ReactNode }) {
  return (
    <div className="min-h-screen flex flex-col">
      <header className="bg-white shadow p-4">
        {/* Hier könntest eine Navbar einfügen */}
        <div className="container mx-auto">Connex</div>
      </header>
      <main className="flex-1 container mx-auto p-4">{children}</main>
      <footer className="bg-gray-100 p-4 text-center">
        &copy; {new Date().getFullYear()} Connex
      </footer>
    </div>
  );
}