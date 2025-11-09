# Dependencies

## Setup Frontend

npm -i

### Vite + TailwindCSS

1. npm create vite@latest
2. npm intall tailwindcss @tailwindcss/vite
3. Everything in the index.css replaced with: @import "tailwindcss";
4. Configs Edited for TailwindCSS:
    - tsconfig.json
    - tsconfig.app.json
5. npm install -D @types/node
    - vite.config.ts

### ShadCN UI

1. npx shadcn@latest init
    - components.json
Example: npx shadcn@latest add button

### React Router DOM

1. npm install react-router-dom

2. npm install --save-dev @types/react-router-dom

### Frontend Starten

1. npm run dev
2. http://localhost:5173
