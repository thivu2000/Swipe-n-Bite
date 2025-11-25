# Anforderungsanalyse – Snack ´N´ Bite

## 1. Nutzerverwaltung
- Login via Firebase Auth (E-Mail, Google, anonym)
- Profildaten in Firestore (Name, Bild, Nutzer-ID)
- Passwort zurücksetzen über Firebase

## 2. Gruppenfunktionen
- Firestore Collections für Gruppen (ID, Name, Mitglieder)
- Gruppenbeitritt über Einladungscode oder Link
- Admin kann Mitglieder verwalten und Gruppe löschen
- Optional: Gruppenchat via Realtime Database

## 3. Swiping-Funktion
- Karten mit Bild & Text
- Wischbewegung links/rechts
- Likes/Dislikes speichern
- Matching-Logik für gemeinsame Favoriten

## 4. Standort & Restaurants
- Standort via Google Location Services
- Restaurantdaten via Google Places API & Yelp
- Filter: Entfernung, Preis, Bewertung
- Darstellung: Bilder, Bewertungen, Öffnungszeiten, Links

## 5. Rabatte & Angebote
- API-Integration für Deals
- Eigene Rabatt-DB in Firestore

## 6. Social-Discovery
- Status speichern
- Nearby-Users-Query (Radius & Standortfreigabe)
- Darstellung in extra Screen

## 7. Nicht-funktionale Anforderungen
- Ladezeiten <2 Sekunden beim Swipen
- Verschlüsselung (TLS + Firestore Security Rules)
- UI/UX soll intuitiv sein

## 8. MVP
- Flutter-App mit Firebase Auth & Firestore
- Swipen von Dummy-Gerichten
- Likes/Dislikes speichern
- Gruppenergebnisse anzeigen
- Standortabfrage + erste Restaurants
