# Projekt _**Graphic**_ zur Einführung in OOP

Wir werden nun ein Projekt anfangen, welches wir sukzessive alle drei parallel entwickeln und dabei verschiedene Techniken der Entwicklung von Software nutzen.

Die meiste Zeit werdet ihr selbständig das Projekt entwickeln.

## Referenzen
Standardwerke für die Javaentwicklung
- [Java ist auch eine Insel](https://amzn.to/3bBG7vt) ([Web-Version](http://openbook.rheinwerk-verlag.de/javainsel/))
- [Effective Java](https://amzn.to/2XyfEH4) ([Deutsche Ausgabe](https://amzn.to/38Dr6HK))
- [Clean Code](https://amzn.to/2P85FVA) ([Deutsche Ausgabe](https://amzn.to/2Xzdnvp))
- [Design Pattern](https://amzn.to/2LjTqGv) der Gang of four ([Deutsche Ausgabe](https://amzn.to/2XB0UqT))

Dokumentation
- [Git Anwendungshandbuch](https://git-scm.com/book/de/v2)
- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
- [Studienprojekt Design Pattern](https://www.philipphauer.de/study/se/design-pattern.php)

## Wiederholung

Der Heutige Schwerpunkt ist die Wiederholung OOP.

    Klassen, Vererbung, Konstruktoren, Member, Getter/Setter, Membermethoden
    Collection, List, Map
    JUnit
    Maven

Im Anschluss daran, sollt ihr euch, mit Hilfe des Internet, Design Pattern erarbeiten.

    Was sind Design Pattern?
    Wozu benötige ich Design Pattern?
    Klassifikation von Design Patterns

Konkret sollt ihr euch dann noch die Design Pattern

    MVC (im Kontext der Desktopentwicklung)
    Observer-Pattern
    State-Pattern

anschauen.

Einen guten Einstieg zeigt die Seite https://www.philipphauer.de/study/se/design-pattern.php.

Ein gutes Buch zu Design Pattern, bzw. DAS BUCH ist von der Gang of four (Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides) mit dem Titel Design Pattern. Dies gibt es auch in einer Deutschen Übersetzung und heißt Entwurfsmuster. (https://de.wikipedia.org/wiki/Entwurfsmuster_(Buch))

## Tag 1

heute wird jeder selbstständig eine Klassenstruktur für primitive Grafikelemente entwerfen. Dabei wollen wir vorerst die Primitiven Punkt, Linie, Ellipse und Rechteck mit den entsprechenden Member und Zugriffsmethoden entwickeln.

Anschließend entwirft jeder selbstständig eine Klasse, die Instanzen dieser Primitiven zu einer Zeichnung zusammenfasst. Diese Zeichnung benötigt natürlich auch sinnvolle Member und Methoden.

Außerdem ist mit Tests sicherzustellen, dass die Methoden der neu entworfenen Klassen so arbeiten, wie wir es uns vorstellen.

Der Schwerpunkt soll hier auf Schnittstellen, Klassen und deren Konstruktoren, Member und Methoden liegen. Außerdem wird die Collection-API eine Rolle spielen und einfache JUnit-Tests müssen erstellt werden.

Gegen 8:45 würde ich mich gern mit euch unter https://meet.jit.si/FIAE unterhalten und die Aufgaben besprechen.


## Tag 2

- Git
  - [Git Anwendungshandbuch](https://git-scm.com/book/de/v2)
  - commit und push
  - Tag erstellen
  - Projekt clonen
- Diskussion des gestrigen Tages
- Observer Pattern
- Selbständiges implementieren des Observer mit Hilfe des UML-Diagramms

![Observer](images/observer-pattern.png "UML-Diagramm Observer")
- Verwendung des Observer Pattern in unserer Zeichnung

- Nutzung von JUnit
  - [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)


## Tag 3

- Diskussion und Verfeinerung des implementierten Observer Patterns unserer Zeichnung
- Wiederholung der Woche
