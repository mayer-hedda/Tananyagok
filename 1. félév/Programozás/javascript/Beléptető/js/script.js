function jelszo_ellenor() {
    var jelszo1 = document.getElementById("pass1");
    var jelszo2 = document.getElementById("pass2");
    var eredmeny = document.getElementById("eredmeny");
    var gomb = document.getElementById("gomb");
    var kisbetuk = /[a-z]/g;
    var nagybetuk = /[A-Z]/g;
    var szamok = /[0-9]/g;
    var vankisbetu = false;
    var vannagybetu = false;
    var vanszam = false;

    if (jelszo1.value.length >= 8) {
        if (jelszo1.value.match(kisbetuk)) {
            vankisbetu = true;
        }
        if (jelszo1.value.match(nagybetuk)) {
            vannagybetu = true;
        }
        if (jelszo1.value.match(szamok)) {
            vanszam = true;
        }

        if (jelszo1.value == jelszo2.value && vankisbetu && vannagybetu && vanszam) {
            eredmeny.innerHTML = "A jelszavak egyeznek.";
            gomb.disabled = false;
        } else if (!vankisbetu || !vannagybetu || !vanszam) {
            eredmeny.innerHTML = "A jelszaónak tartalmaznia kell legalább egy kisbetűt, egy nagybetűt és egy számot.";
            gomb.disabled = true;
        } else {
            eredmeny.innerHTML = "A jelszavak nem egyeznek.";
            gomb.disabled = true;
        }

    } else {
        eredmeny.innerHTML = "A jelszó rövid.";
        gomb.disabled = true;
    }



    // alert(jelszo1.value);
}

function szulinap_ellenor() {
    var szuli = document.getElementById("szuli");
    var ma = new Date();
    szuli = new Date(szuli.value);
    kulonbseg = (ma.getTime() - szuli.getTime()) / (1000 * 3600 * 24 * 365);
    // alert(kulonbseg);

    if (Math.floor(kulonbseg) >= 18) {
        gomb.disabled = false;
        eredmeny.innerHTML = "";
    } else {
        eredmeny.innerHTML = "Túl fiatal vagy.";
        gomb.disabled = true;
    }
}