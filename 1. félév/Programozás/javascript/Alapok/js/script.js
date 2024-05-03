function elso_fgv() {
    var elsoSzam;
    var masodikSzam;
    var eredmeny;
    var szoveg;

    elsoSzam = 2;
    masodikSzam = 5;
    eredmeny = elsoSzam + masodikSzam;

    szoveg = "<table class='szorzotabla'>";
    for (j = 1; j <= 10; j++) {
        szoveg = szoveg + "<tr>";
        for (i = 1; i <= 10; i++) {
            szoveg = szoveg + "<td>" + i*j + "</td>";
            // document.getElementById("teszt").innerHTML = szoveg = szoveg+ i + " ";
        }
        szoveg = szoveg + "</tr>";
    }
    szoveg = szoveg + "</table>";

    document.getElementById("teszt").innerHTML = szoveg;
    

    // document.getElementById("teszt").innerHTML = eredmeny;
    
    // document.write("elso");
    // document.write("<div style='color: red; font-size: 60px;'>elso</div>");
}