# A leképező (comprehension) kifejezésekben
# nem csak listák szerepelhetnek,
# hanem bármilyen bejárható gyűjtemény pl. range().
dupla = [x * 2 for x in range(1, 10)]
print(', '.join(str(szam) for szam in dupla))
print('\n\n')



# A kifejezések eredményeként nem csak listák,
# de pl. halmazok is előállíthatóak.
dupla = {x * 2 for x in range(1, 10)}
print(', '.join(str(szam) for szam in dupla))