'''
Összehasonlító operátorok
==      egyenlő
!=      nem egyenlő
<       kisebb
>       nagyobb
<=      kisebb vagy egyenlő
>=      nagyobb vagy egyenlő
'''

a = 15
b = 3

if a != b:
    print('A két szám nem egyenlő.')



'''
Logikai operátorok
and     és
or      vagy
not     nem
'''

x = 5
y = -3

if x < 0 and y < 0:
    print('Mind a két szám negatív.')
if x < 0 or y < 0:
    print('Van közöttük negatív szám.')
if not x <= 0:
    print('X pozitív szám.')