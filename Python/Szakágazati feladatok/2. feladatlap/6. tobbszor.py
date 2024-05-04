szam = int(input('Adjon meg egy egész számot: '))
tobbszoros = int(input('Adja meg, hogy hány db többszörösét írja ki a program: '))

for i in range(szam, szam * tobbszoros + 1, szam):
    print(i)

# szamlalo = 0
# while szamlalo != tobbszoros:
#     print(szam + szamlalo*szam)
#     szamlalo += 1



szam = int(input('\nAdjon meg egy egész számot: '))
felezett = int(input('Adja meg, hogy hány db tört értékét írja ki a program: '))

for _ in range(felezett):
    print(int(szam) if szam % 1 == 0 else szam)
    szam /= 2

# szamlalo = 0
# while szamlalo != felezett:
#     print(szam)
#     szam = szam / 2
#     if szam % 1 == 0:
#         szam = int(szam)
#     szamlalo += 1