# Anforderungsanalyse: Snack 'N' Bite

## 1. Ziel
Die App soll die gemeinsame Essensentscheidung vereinfachen, Gruppenfavoriten ermitteln und Restaurantempfehlungen bereitstellen.

---

## 2. Analyse der Anforderungen

### Funktionale Anforderungen
- Nutzer-Login & Profilverwaltung
- Gruppen erstellen & verwalten
- Swipen von Gerichten mit Like/Dislike
- Speicherung der Bewertungen in der Datenbank
- Gemeinsame Favoriten anzeigen
- Standortbasierte Restaurantvorschläge (API: Google Places / Yelp)
- Social-Discovery Funktion (optional)

### Nicht-funktionale Anforderungen
- Intuitive Bedienung
- Schnelle Ladezeiten (< 2 Sek.)
- Skalierbarkeit (Gruppen bis 15 Personen)
- Plattformen: Android & iOS
- Datenschutzkonformität (DSGVO)

### Risiken & Herausforderungen
- Ungenaue Standortdaten
- Matching-Logik bei großen Gruppen
- Lückenhafte Restaurantdaten

---

## 3. MVP
**Fokus auf Kernfunktionen:**
1. Nutzerregistrierung & Login
2. Gruppen erstellen & beitreten
3. Swipen von Gerichten mit Speicherung der Likes/Dislikes
4. Anzeige von gemeinsamen Favoriten innerhalb der Gruppe
5. Restaurant-Suche via API
