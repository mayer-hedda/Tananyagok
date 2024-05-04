elso_elem = int(input('Számtani sorozat elemei\nAdd meg a sorozat első elemét: '))
differencia = int(input('Add meg a sorozat differenciáját: '))
hanyszor = int(input('Add meg a sorozat hány eleme kerüljön kiírásra: '))

szamtani_sor = []
while len(szamtani_sor) != hanyszor:
    elso_elem += differencia
    szamtani_sor.append(elso_elem)

for szam in szamtani_sor:
    print(szam, end=',')