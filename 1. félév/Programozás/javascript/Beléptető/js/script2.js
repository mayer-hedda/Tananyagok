function jelszoEllenor() {
    var jelszo1 = document.getElementById("pass1");
    var jelszo2 = document.getElementById("pass2");
    var eredmeny = document.getElementById("eredmeny");
    var gomb = document.getElementById("gomb");

    if (jelszo1.value == jelszo2.value) {
        eredmeny.innerHTML = "A két jelszó egyezik.";
        const errors = [];

        var upper = 0;
        var lower = 0;
        var number = 0;
        for (var i = 0; i < jelszo1.length; i++) {
            var char = jelszo1[i];
        
            switch (char) {
                case char == char.toUpperCase(): 
                    upper++;
                    break;
                case char == char.toLowerCase():
                    lower++;
                    break;
                case typeof char == "number":
                    number++;
                    break;
                default: 
                    eredmeny.innerHTML = "Nem történik semmi";
            }
        }
    
        if (upper = 0) {
            errors.push = "A jelszónak tartalmaznia kell legylább egy nagybetűt.";
        } 
        if (lower = 0) {
            errors.push = "A jelszónak tartalmaznia kell legalább egy kisbetűt.";
        }
        if (number = 0) {
            errors.push = "A jelszónak tartalmaznia kell legalább egy számot.";
        }
        if (jelszo1.length < 8) {
            errors.push = "A jelszónak legalább 8 karakterből kell állnia.";
        }
        
        if (upper + lower + number == 0) {
            gomb.disabled = true;
            errors.forEach(error => eredmeny.innerHTML(error));
        } else {
            gomb.disabled = false;
        }
    } else {
        eredmeny.innerHTML = "A két jelszó nem egyezik.";
        gomb.disabled = true;
    }
    // alert(jelszo1.value);
}