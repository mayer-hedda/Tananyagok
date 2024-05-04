var db = 0;
var sum = 0;

for (var i = 1; i <= 100; i++) {
    if (i % 6 == 0) {
        db++;
        sum += i;
    }
}

document.write(db, '<br>');
document.write(sum);