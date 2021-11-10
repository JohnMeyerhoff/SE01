# Patterns
Patterns (Muster) sind bestimmte Wege / Vorgehensmuster um bekannte Probleme zuverlässig
zu lösen. Ein Pattern ist also sozusagen ein Rezept für eine Lösung.
Im diesem Dokument erkläre ich einige Patterns welche in der Vorlesung relevant sind.
## Factory Method Pattern
Bekannt aus: Übung 1
Die Vorteile der Factory Method sind ähnlich, wie die Vorteile von Interfaces.
Dies liegt daran, dass die Factory sich wie eine Schnittstelle zum erstellen von
Instanzen einer Klasse verhält.
Das Auslagern der Komplexität auf eine Factory verhindert Fehlerhafte Parametrisierung der Konstruktoren.
Die Entwickler können sich darauf verlassen, dass alle erstellten Instanzen einer Klasse
zuverlässig einheitlich erstellt wurden.
## Singleton Pattern
Bekannt aus: Übung 2
Die Instanz einer Klasse wird nicht über den Konstruktor erstellt.
Es existiert zur Laufzeit Maximal eine Instanz.

Es muss sichergestellt werden, dass es nicht zu einem Datenverlust beim Multi-Threading bzw.
bei Parallelisierung führt.

Ein Singleton darf keinesfalls über Checks innerhalb des Konstruktors umgesetzt werden,
alle Umsetzungen welche auf Code innerhalb des Konstruktors aufbauen sind keine Lösungen
nach dem Singleton-Pattern, da der Konstruktor für das Funktionieren des Codes bereits
aufgerufen worden sein muss.

## Single Responsibility
Jede Klasse hat genau eine Verantwortung, siehe Antipatterns (godclass).


# Antipatterns
Antipatterns sind Muster die zuverlässig zu Miserfolg führen.
## God class
Ein häufiges antipattern is das einlagern vieler Funktionalitäten in eine einzige
Klasse. Dies ist nicht übersichtlich und hat nicht den Qualitätsaspekt der Wartbarkeit.


