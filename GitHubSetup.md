# 🌍 3. GitHub Setup

## 🔒 Grundstruktur

Main Branch: geschützt (PRs erforderlich)

Dev Branch: gemeinsamer Entwicklungszweig

Feature Branches: jeder Entwickler arbeitet im eigenen Feature-Branch

GitHub Projects / Kanban: für Aufgaben & Fortschritt

GitHub Actions: für CI/CD (Build + Test + Docker Publish)

.gitignore sauber konfigurieren (Node, Java, IDEs, Docker, envs)

## Beispiel Workflow

## Neues Feature starten

git checkout dev
git pull
git checkout -b feat/realtime-notifications

## Änderungen pushen

git add .
git commit -m "feat(realtime): implement socket.io channel events"
git push origin feat/realtime-notifications

## Pull Request öffnen -> Code Review -> Merge in dev
