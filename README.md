# ProgTech
 Tőzsde szimulátor LITE
 
 A projekt célja egy egyszerű tőzsde szimulátor elkészítése, amelyben a félév során elsajátított tervezési mintákat használnám fel.
 
felépítése:
-termékeket előállító objectfactory (tőzsde szerver) - az előállított termékek árát véletlenszerűen változtatja
-a kliens observer tervezési minta segítségével kapja meg a tőzsde által generált aktuális árakat, vagyis feliratkozik azokra a termékekre amiket szeretne megvásárolni
-a kliens egy gyártósor ami a megvásárolt termékekből szereli össze a saját termékét, és szeretné tudni hogy az alapanyag összesen mennyibe került az alapaynagokat aktuális árafolyama alapján, ezt a számítást egy decorator osztály végzi
-a kliens a kiszámított árat letárolja a saját adatbázisába, az adatbáziskapcsolatot egy singleton osztály biztosítja
