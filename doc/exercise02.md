# 1
## Aktivitätsdiagramm in UML
![Aktivitätsdiagramm >](images/Abgabe.svg)

# 2
## Programmierung der Member-Container
Aufgabenstellung fordert fünf Klassen:
- Member Interface
- Container Klasse
- Container Test
- ContainerException
- __keine__ ID-Klasse 
- zum Testen: Instanzierbare Implementiierung der Memberklasse

Anforderungen an die Containerklasse: 
- Verwendung einer ``Containerexception``

Anforderungen an die Member-Unterklasse: 
- toString-Ausgabe: Member (ID = [hier die ID des Members])
- das Setzen eines Schlüsselattributes
- das Sicherstelllen der Eindeutigkeit dieses Attributs

Format-Anforderung an die Container-Exception:
- Das Member-Objekt mit der ID [hier die ID des Objekts] ist be-reits vorhanden!
