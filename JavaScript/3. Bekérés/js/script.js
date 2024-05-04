var a = prompt('Adj meg egy egész számot:', 'Kezdj el gépelni...');

if (isFinite(a)) {
    if (Math.floor(a) == a) {
        if (a % 2 == 0) {
            document.write('A szám páros.');
        } else {
            document.write('A szám páratlan.');
        }
    } else {
        document.write('Nem egész számot adtál meg, a kiértékelés nem lehetséges.')
    }
} else {
    document.write('Nem számot adtál meg.');
}
