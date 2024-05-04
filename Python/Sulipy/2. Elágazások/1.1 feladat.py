'''
Készíts egy programot, amely megkérdezi a felhasználótól, hogy jó napja van-e!
A válasz kétféle lehet: igen vagy nem.
A választól függően írjon ki üzenetet a gép!

Fejleszd tovább az első feladat programját úgy,
hogy amennyiben a felhasználó nem a két lehetséges válasz (igen/nem)
közül ad meg egyet, a gép kiírja: "Sajnos nem értem a válaszodat!"
'''
valasztas = input('Jó napod van ma? (igen/nem) \n\tTe: ')

if valasztas == 'igen' or valasztas == 'Igen':
    print('Örülök neki, további szép napot neked!')
elif valasztas == 'nem' or valasztas == 'Nem':
    print('Ne aggódj, holnap jobb lesz!')
else:
    print('Sajnos nem értem a válaszodat!')