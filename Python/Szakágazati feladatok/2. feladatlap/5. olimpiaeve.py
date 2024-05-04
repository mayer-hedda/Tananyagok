from datetime import datetime

ev = int((((str(datetime.today()).split())[0]).split('-'))[0])

evszamok = []
for szam in range(1896, ev+1, 4):
    print(szam)
    evszamok.append(szam)

print(f'\nAz utolsó olimpia éve: {evszamok[-1]}.')
print(f'A következő olimpia éve: {evszamok[-1] + 4}.')