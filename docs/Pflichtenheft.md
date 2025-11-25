# Pflichtenheft: Snack 'N' Bite

## 1. Einleitung
Dieses Dokument beschreibt die **technische Umsetzung** der Anforderungen aus dem Lastenheft.

---

## 2. Systemarchitektur
- **Frontend:** Flutter (Android & iOS, Sprache: Dart)
- **Backend:** Firebase (Auth, Firestore, Storage, Hosting)
- **APIs:** Google Maps & Places, Yelp API, ggf. Rabatt-APIs
- **Hosting:** Firebase Hosting oder eigener Cloud-Server

---

## 3. Umsetzung der Anforderungen

### Nutzerverwaltung
- Firebase Auth für Login (E-Mail, Google, anonym)
- Firestore für Profildaten (Name, Bild, Nutzer-ID)
- Passwort-Reset über Firebase

### Gruppenfunktionen
- Firestore Collections für Gruppen (ID, Name, Mitglieder)
- Gruppenzuordnung über Einladungslink / Code
- Admin-Funktionen: Gruppe löschen, Mitglieder verwalten
- Optional: Gruppenchat über Realtime Database

### Swiping-Funktion
- Karten mit Bildern & Text in Flutter
- Gestensteuerung (rechts/links)
- Speicherung von Likes/Dislikes in Firestore
- Matching-Logik für Gruppenfavoriten

### Standort & Restaurants
- Standort via Google Location Services
- Restaurantdaten über Google Places & Yelp
- Filterung nach Entfernung, Preis, Bewertung
- Darstellung mit Bildern, Bewertungen, Öffnungszeiten

### Social-Discovery
- Sichtbarkeitsstatus in Firestore speichern
- Nearby-Users-Query (max. Radius, Standortfreigabe)
- Darstellung in eigenem Screen

---

## 4. Nicht-funktionale Anforderungen
- Ladezeiten < 2 Sekunden beim Swipen
- Verschlüsselung aller Daten (TLS, Firestore Security Rules)
- UI/UX Design: intuitive Navigation, modernes Layout
