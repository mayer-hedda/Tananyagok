'''
Írj egy programot,
ami a felhasználótól bekéri először a keresztnevét,
majd a vezetéknevét.
A program ezután összefűzi ezeket egy teljes_nev nevű változóba.
Végül a program a teljes nevén üdvözli a felhasználót!
'''
keresztnev = input('Adja meg a keresztnevét: ')
vezeteknev = input('Adja meg a vezetéknevét: ')

teljes_nev = f'{vezeteknev} {keresztnev}'

print(f'Üdv {teljes_nev}!')