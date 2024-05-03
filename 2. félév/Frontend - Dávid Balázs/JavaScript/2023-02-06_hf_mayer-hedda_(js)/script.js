//  ---------- 1. feladat ----------

/*  írj egy függvényt, ami kiszámítja egy háromszög területét. 
    két bemenő paramétere legyen, alap és magasság
    A függvény adja vissza a háromszög területét mértékegység nélkül
    Kezeld le azokat az eseteket is, amikor nem számok lettek a bemenő paraméterek
    https://www.w3schools.com/jsref/jsref_parseint.asp */

function haromszogTerulet(alap, magassag) {
    if (isNaN(parseInt(alap)) || isNaN(parseInt(magassag))) {
        return "Nem szám típúsú adatok lettek megadva.";
    } else {
        var terulet = (alap * magassag) / 2;
        return `A háromszög területe: ${terulet}`;
    }

}

console.log(haromszogTerulet(5, 12));
console.log(haromszogTerulet("5", 12));
console.log(haromszogTerulet(5, "12"));
console.log(haromszogTerulet("5", "12"));
console.log(haromszogTerulet("5", "alma"));





//  ---------- 2. feladat ----------

/*  Hozz létre egy tömböt ezekkel az értékekkel: [9, 9, 2, 3, 4]
    írj egy ciklust, ami visszaad egy tömböt, amiben az eredeti tömbnek az értékei
    emelkedő sorrendben vannak.
    Aztán írj egy másikat, ami egy olyan tömbböt ad vissza, ahol az eredeti tömb
    elemei fordított sorrendben szerepelnek
    Ne az array.sort() és array.reverse() metódust használd, hanem saját ciklust írj!
    https://www.w3schools.com/jsref/jsref_sort.asp
    https://www.w3schools.com/jsref/jsref_reverse.asp */

function novekvoSorrend(tomb) {
    var novekvoTomb = [];
    var belsoTomb = Array.from(tomb);
    
    hossz = belsoTomb.length
    for (let i = 0; i <= hossz - 1; i++) {
        novekvoTomb.push(Math.min.apply(null, belsoTomb));
        belsoTomb.splice(belsoTomb.indexOf(Math.min.apply(Math, belsoTomb)), 1);
    }

    return novekvoTomb;
}
    
function ellentetesSorrend(tomb) {
    var ellentetesTomb = [];

    for (let i = tomb.length-1; i >= 0; i--) {
        ellentetesTomb.push(tomb[i]);
    }

    return ellentetesTomb;
}


var szamok = [9, 9, 2, 3, 4];
console.log(novekvoSorrend(szamok));
console.log(ellentetesSorrend(novekvoSorrend(szamok)));





// ---------- 3. feladat ----------
/*  FizzBuzz: hozz létre egy függvényt, ami 1-100-ig kiírja a számokat a konzolba
    ha egy szám 3-al osztható, akkor a szám helyett írja azt, hogy fizz
    ha egy szám 5-tel osztható, akkor a szám helyett írja azt, hogy buzz
    ha egy szám 3-mal és 5-tel is osztható, akkor írja azt, hogy fizzbuzz */

function szamokKiirasa() {
    for (let i = 1; i <= 100; i++) {
        if (i % 3 == 0 && i % 5 != 0) {
            console.log("Fizz");
        } else if (i % 5 == 0 && i % 3 != 0) {
            console.log("Buzz");
        } else if (i % 3 == 0 && i % 5 == 0) {
            console.log("FizzBuzz");
        } else {
            console.log(i);
        }
    }
}

szamokKiirasa();





// ---------- EXTRA ----------
/*  var data = [
        {username: "Tibi82", password: "t82"},
        {username: "BigBoy", password: "boy1"},
        {username: "user", password: "password"},
        {username: "KovacsIstvan", password: "kistvan"}
    ]

    var userName = prompt("Add meg a felhasználóneved");
    var userPass = prompt("Add meg a jelszavad");

    Készíts egy ciklust, ami bekér egy felhasználónevet és jelszót, s összehasonlítja a fenti data tömb
    elemeivel.

    Ha a van olyan username, amit a felhasználó beadott, és egyezik hozzá a jelszó is, akkor írja ki valahogy, 
    hogy sikerült belépni
    Ha van ilyen username, de a jelszó nem egyezik, akkor írja ki, hogy helytelen a jelszó,
    ha pedig nincs ilyen username, akkor írja ki azt, hogy nincs ilyen felhasználó */

var data = [
    {username: "Tibi82", password: "t82"},
    {username: "BigBoy", password: "boy1"},
    {username: "user", password: "password"},
    {username: "KovacsIstvan", password: "kistvan"}
]

var userName = prompt("Add meg a felhasználóneved");
var userPass = prompt("Add meg a jelszavad");

var talalat = true;
for (let i = 0; i <= data.length-1; i++) {
    if (userName == data[i].username) {
        if (userPass == data[i].password) {
            alert("Sikeresen bejelentkezett!");
            talalat = true;
            break;
        } else {
            alert("Helytelen jelszó!");
            talalat = true;
            break;
        }
    } else {
        talalat = false;
    }
}

if (talalat == false) {
    alert("Nincs ilyen felhasználó!");
}