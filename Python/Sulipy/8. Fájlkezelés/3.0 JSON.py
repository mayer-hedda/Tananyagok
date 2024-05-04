import json

with open('3.0 JSON.json', 'r', encoding='utf-8') as fajl1:
    adatok1 = json.load(fajl1)
    for diak in adatok1['diakok']:
        diak['osztaly'] = '10.C'
        print(diak)

with open('3.0 JSON 2.json', 'w', encoding='utf-8') as fajl2:
    json.dump(adatok1, fajl2, indent=2)

with open('3.0 JSON 2.json', 'r', encoding='utf-8') as fajl3:
    adatok2 = json.load(fajl3)
    for diak in adatok2['diakok']:
        print(diak)