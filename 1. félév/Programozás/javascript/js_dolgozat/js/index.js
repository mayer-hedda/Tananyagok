function email_ellenor() {
    var email = document.getElementById("email");
    var hiba_email = document.getElementById('hiba_email');

    var ellenorzes = email.value.includes("@");
    if (email.value.length == 0) {
        hiba_email.innerHTML = "Az email mező üres.";
        return false;
    } else if (ellenorzes == false) {
        hiba_email.innerHTML = "Nem megfelelő az email formátuma.";
        return false;
    } else {
        hiba_email.innerHTML = "Megfelelő az email címed.";
        return true;
    }
}



function username_ellenor() {
    var username = document.getElementById("userName");
    var hiba_username = document.getElementById("hiba_userName");
    var kisbetuk = /[a-z]/g;
    var nagybetuk = /[A-Z]/g;
    var szamok = /[0-9]/g;

    if (username.value.length == 0) {
        username_ellenorzo = false;
        hiba_username.innerHTML = "Üres a felhasználónév meződ";
    } else {
        var maskarakter = false;
        for (var i = 0; i < username.value.length; i++) {
            var char = username.value[i];
            
            if (!(char.match(kisbetuk)) && !(char.match(nagybetuk)) && !(char.match(szamok))) {
                maskarakter = true;
            }
        }

        if (maskarakter == true) {
            hiba_username.innerHTML = "A felhasználóneved csak kisbetűt, nagybetűt és számot tartalmazhat.";
            return false;
        } else {
            hiba_username.innerHTML = "Megfelelő a felhasználóneved.";
            return true;
        }
    }
}



function szulinap_ellenor() {
    var szuli = document.getElementById("szuli");
    var hiba_szuli = document.getElementById("hiba_szuli");
    var ma = new Date();
    szuli = new Date(szuli.value);
    kulonbseg = (ma.getTime() - szuli.getTime()) / (1000 * 3600 * 24 * 365);

    if (Math.floor(kulonbseg) >= 18) {
        hiba_szuli.innerHTML = "Megfelelő az életkorod.";
        return true;
    } else {
        hiba_szuli.innerHTML = "Túl fiatal vagy.";
        return false;
    }
}



function jelszo_ellenor() {
    var pass1 = document.getElementById("pass1");
    var pass2 = document.getElementById("pass2");
    var hiba_pass = document.getElementById("hiba_pass");

    var kisbetuk = /[a-z]/g;
    var nagybetuk = /[A-Z]/g;
    var szamok = /[0-9]/g;
    var vankisbetu = false;
    var vannagybetu = false;
    var vanszam = false;

    if (pass1.value.length >= 8) {
        if (pass1.value.match(kisbetuk)) {
            vankisbetu = true;
        }
        if (pass1.value.match(nagybetuk)) {
            vannagybetu = true;
        }
        if (pass1.value.match(szamok)) {
            vanszam = true;
        }

        if (pass1.value == pass2.value && vankisbetu && vannagybetu && vanszam) {
            hiba_pass.innerHTML = "A jelszavak egyeznek.";
            return true;
        } else if (!vankisbetu || !vannagybetu || !vanszam) {
            hiba_pass.innerHTML = "A jelszaónak tartalmaznia kell legalább egy kisbetűt, egy nagybetűt és egy számot.";
            return false;
        } else {
            hiba_pass.innerHTML = "A jelszavak nem egyeznek.";
            return false;
        }

    } else {
        hiba_pass.innerHTML = "A jelszó rövid.";
        return false;
    }
}



function ellenorzes() {
    var gomb = document.getElementById("gomb");

    if (email_ellenor() == true && username_ellenor() == true && szulinap_ellenor() == true && jelszo_ellenor() == true) {
        gomb.disabled = false;
    } else {
        gomb.disabled = true;
    }
}