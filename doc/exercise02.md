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

## Tests
Tabelle der Tests
| Test Case No. | Category (pos; neg) | Äquivalenzklassen        | input | output (erwartet)  |
|---------------|---------------------|--------------------------|-------|--------------------|
| 1             | pos                 | gÄK1: leere Liste        | m1    | OK / Size = 1      |
| 2             | pos                 | gÄK2: neues Element       | m2    | OK / Size = 2      |
| 3             | neg                 | gÄK3: bestehendes Element | m1    | NOT OK / Exception |
| 4            | neg                 | gÄK4: bestehendes Element nach Exception | m1    | NOT OK / Exception |

Es ist möglich, dass der Fall welcher beim Hinzufügen eine Exception auslöst zusätzlich die Datenstruktur __fälschlicherweise__ abändert, sodass ein folgender Aufruf nicht zu einer Exception führt.

Äquivalenzklassen:
| Parameter | Äquivalenzklasse | Repräsentant |
| -- | --   | -- |
| m1 | gÄK1: leere Liste | ExampleMember1 -> Container1 |
| m2 | gÄK2: neues Element | ExampleMember2 -> Container1 |
| m2 | gÄK3: bestehendes Element | ExampleMember2 -> Container1 |
| m2 | gÄK4: bestehendes Element nach Exception | ExampleMember2 -> Container1 |



| Sonderfall Null | input | output |
| --| -- | --|
|Member-Referenz | null | ContainerException|