# Team-Kennzeichnung
Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic und Johannes Meyerhoff bearbeitet worden.
# 1
## Aktivitätsdiagramm in UML
<p>
<img src="images/Abgabe.svg" alt="Aktivitätsdiagramm"
	title="Aktivitätsdiagramm der Abgabe" width="100%" height="80%" style="max-height:1400px" />
</p>

## Anmerkungen zum Diagramm
Der Vorschlag unsererseits ist, dass wenn ein Dringendes Projekt einen Fehler im Fachkonzept hat, das Fachkonzept mit Vorbehalt verabschiedet wird, nachdem der Software-Architekt das Fachkonzept ein letzes mal korrigiert hat.
# 2
## Programmierung der Member-Container
Aufgabenstellung fordert fünf Klassen:
- Member Interface
- Container Klasse
- Container Test
- ContainerException
- zum Testen: Instanzierbare Implementiierung der Memberklasse
  
  </br>

Explizit: __keine__ ID-Klasse 

Anforderungen an die Containerklasse: 
- Verwendung einer ``ContainerException``
- keine HashMap verwenden

Anforderungen an die Member-Unterklasse: 
- toString-Ausgabe: Member (ID = [hier die ID des Members])
- das Setzen eines Schlüsselattributes
- das Sicherstelllen der Eindeutigkeit dieses Attributs

Format-Anforderung an die Container-Exception:
- Das Member-Objekt mit der ID [hier die ID des Objekts] ist bereits vorhanden!
