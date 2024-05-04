'''
Írj egy programot, amely a fenti listában tárolt azonosítókat írja ki a képernyőre a számok sorrendjének megfelelően!
'''
def azonosit(lista):
    x = []
    for elem in lista:
        elem = elem[2:]
        x.append(elem)
    return x


azonositok = ['id10', 'id100', 'id23', 'id2', 'id13', 'id1']

print(sorted(list(map(int, azonosit(azonositok)))))