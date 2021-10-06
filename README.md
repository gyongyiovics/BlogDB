# BlogDB
maven project with mysql and junit

A feladat összegzése

olyan blog alkalmazás készítése, amelyben a regisztrált felhasználók blogokat hozhatnak létre maguknak sablonok alapján, a blogokhoz bejegyzéseket írhatnak, és kommentelhetnek bejegyzésekre vagy már meglévő kommentekre (akár a sajátjukra is)
az alkalmazásban regisztráció nélkül is lehet blogbejegyzéseket olvasni, viszont azokat írni vagy kommentelni nem
az alkalmazásban a regisztrált felhasználók szerepkörrel rendelkeznek
a szerepkör lehet: admin / moderator / user
a szerepkörökhöz tartozó jogosultságok megírása a feladat része
példák lehetséges jogosultságokra (nem kötelezendően megvalósítandó):
felhasználók adatainak olvasása
csak admin, illetve a saját felhasználói adataihoz minden user hozzáfér
felhasználók adatainak módosítása
csak admin, illetve a saját felhasználói adatait minden user módosíthatja
blogbejegyzések olvasása
nem kell hozzá jogosultság, sőt regisztráció sem
blogbejegyzések módosítása
admin, moderator; illetve a saját blogbejegyzéseit minden user módosíthatja
blogbejegyzések törlése
admin, moderator; illetve a saját blogbejegyzéseit minden user törölheti
kommentek írása
admin, moderator, user

Általános elvárások
a feladat beadható a szükséges fájlokat tartalmazó tömörített mappában, vagy GitHub-ra feltöltött (publikus) repository-ként, a repository linkjének elküldésével


az alkalmazás megjelenítése, azaz (grafikus) felhasználói felület létrehozása NEM része a feladatnak
a program forráskódjának nem kell main() metódust tartalmaznia, de igény szerint futtathatónak kell lennie - azaz szintaktikailag helyesnek kell lennie
az adatbázis létrehozásához szükséges script-nek szintén futtathatónak kell lennie
a blog-sablonok ne legyenek módosíthatóak (azaz nem kell gondoskodni arról, hogy a sablonból létrehozott blog eltérő színű, betűtípusú stb., mint az eredeti sablon)
az egyszerűsítés kedvéért: a jelszavak titkosítása nem a feladat része, azonban tudd, hogy a későbbiekben szükséges (tehát jelen feladatban - csak és kizárólag jelen feladatban - megengedett a jelszavak titkosítás nélküli tárolása az adatbázisban)


