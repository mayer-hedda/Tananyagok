/*
    vagy -- ||
    és -- &&
*/

var a = 7;
var b = prompt('Adj meg egy számot:', 'Kezdj el gépelni...');


document.write('ÉS operátor:<br>');
if (a == 7 && b == 3) {
    document.write('Az a szám 7, a b szám pedig 3.');
} else {
    document.write('Minden más eshetőség.');
}
document.write('<br><br>');



document.write('VAGY operátor:<br>');
if (a == 7 || b == 3) {
    document.write('Vagy az a szám egyenlő 7-tel, vagy a b szám egyenlő 3-mal.');
} else {
    document.write('Minden más lehetőség.');
}