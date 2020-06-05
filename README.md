# ProgTech
 Sőrtőzsde LITE, sörfőző kalkulátorral
 A projekt célja egy egyszerű tőzsde szimulátor, és a tőzsdéről kapott adatokat feldogozó kalkulátor megvalósítása.
 
 Fejelsztéshez használt környezet: IntelliJ IDEA
 Pluginok: JFormDesigner
 Java verzió: 8
 Maven verzió: 3.6.1
 
 Felhasznált design pattern-ek:
 -Factory
 -Lazy Singleton
 -Observer
 -Decorator
 
Modulok:
 A program két fő modulból áll - az adatokat manipuláló közvetítő tőzsde "service", és az adatokat feldolgozó sörfőző kalkulátor ("kliens").Nincs valódi szerver-kliens kapcsolat.
  -Service:
        Lehetőségünk van új termékek felvételére user interfacen keresztül, ahol a termék nevét kezdő árát,
        ár maximális és minimális növekedését és csökkenését (az áringadozás szimulálásához) lehet megadni.
        A termékek 4 féle sörfőzéshez használt alapnyag kategóriába sorolhatóak, a beírt adatok alapján egy Factory osztály létrehozza
        a kívánt objektumot.
        A GUI aktívan hibakezel, ha az input mezőbe nem feldolgozható karakter kerül azonnal figyelmezteti a felhasználót, csak 
        helyesen beírt adatokat enged bekerülni a szimulációba, minden mező kitöltése kötelező.
        10 másodpercenként generál új árakat a termékeknek, amelyeket Observer Pattern közvetít a kliensek felé.
  -Kliens:
        Feladata nyomonkövetni a service-re bekerülő termékeket, és azok áringadozásait.
        Indításkor Observer pattern segítségével feliratkozik a service-re, update hatására megjeleníti a termékeket, és áraikat,
        szűrők segítségével megadhatjuk milyen alapanyagtípusokat szeretnénk látni a lsitában.
        A terméklistából a kiválasztott termékeket átpakolhatjuk a kosarunkba, valamint el is távolíthatjuk onnan.
        A recept összeállítását követően meghatározhatjuk, hogy kosárban lévő alapanyagmennyiség
        mekkora mennyiségű sör lefőzésére elegendő, valamint azt, hány litert szeretnénk elkészíteni.
        A kalkuláció Decorator pattern felhasználásval számolja ki az elkészítés költségeit.
        
        

