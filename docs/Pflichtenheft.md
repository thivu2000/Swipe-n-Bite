# Pflichtenheft – Snack ´N´ Bite

## 1. Architektur
- **Frontend:** Flutter (Android & iOS), Sprache: Dart
- **Backend:** Firebase (Auth, Firestore, Storage, Hosting)
- **APIs:** Google Maps & Places, Yelp, ggf. Rabatt-APIs
- **Hosting:** Firebase Hosting oder eigener Server

## 2. Umsetzung der Anforderungen

### Nutzerverwaltung
- Login & Registrierung via Firebase Auth
- Profilinfos in Firestore
- Passwort-Reset über Firebase

### Gruppenfunktionen
- Firestore Collections für Gruppen
- Beitritt per Einladungscode oder Link
- Admin-Funktionen: Mitglieder verwalten, Gruppe löschen
- Optional: Gruppenchat

### Swiping-Funktion
- Karten mit Bild & Text
- Wischbewegung links/rechts
- Likes/Dislikes speichern
- Matching für Gruppen-Favoriten

### Gruppenergebnisse
- Firestore Query für Favoriten
- Anzeige: Favoritenliste & Mitgliederübersicht

### Standort & Restaurants
- Standort via Google Location Services
- Restaurants über Google Places API & Yelp
- Filter: Entfernung, Preis, Bewertung
- Anzeige: Bilder, Bewertungen, Öffnungszeiten, Links

### Rabatte & Angebote
- Deals über API abrufen
- Eigene Rabatt-Datenbank in Firestore

### Social-Discovery
- Sichtbarkeit speichern
- Nearby-Users-Query (Radius & Standortfreigabe)
- Anzeige in extra Screen

### Nicht-funktionale Anforderungen
- Ladezeit <2 Sekunden beim Swipen
- Verschlüsselung (TLS + Firestore Security Rules)
- Intuitive Navigation

### MVP
- Flutter-App mit Firebase Auth & Firestore
- Swipen von Dummy-Gerichten
- Speicherung der Likes/Dislikes
- Gruppenergebnisse abrufbar
- Standortabfrage & erste Restaurants
