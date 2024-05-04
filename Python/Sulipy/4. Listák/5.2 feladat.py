'''
Adott egy függvény. Értelmezési tartománya:
[-3; 4] intervallumon az egész számok halmaza.
Hozzárendelési szabálya: y = 2x-3.
A program egy lista formájában tárolja az értelmezési tartomány elemeit.
Listaelemek leképezésével állítsa elő,
tárolja listában és írja ki az értékkészlet elemeit.

Az előző programot alakítsuk most úgy át, hogy a listaelemek leképezése
az értelemezési tartomány nemnegatív elemire korlátozódjon!
'''
ertelmezesi_tartomany = [elem for elem in range(-3, 5)]
ertekkeszlet = [2 * szam -3 for szam in ertelmezesi_tartomany if szam >= 0]

print(', '.join(str(szam) for szam in ertelmezesi_tartomany))
print(', '.join(str(szam) for szam in ertekkeszlet))