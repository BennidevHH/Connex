import React from "react";

export default function ErrorLayout({ children }: { children: React.ReactNode }) {
  return (
    <div className="min-h-screen flex items-center justify-center bg-red-50">
      {children}
    </div>
  );
}