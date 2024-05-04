# -----LOKÁLIS VÁLTOZÓK (LOCAL SCOPE)-----

def negyzet(a):
    print(a)
    return a ** 2

print(negyzet(3))
# print(a) | HIBAÜZENET
print('\n\n')





# -----GLOBÁLIS VÁLTOZÓK (GLOBAL SCOPE)-----

def negyzet(a):
    print(f'A négyzet függvényen belül: {a}')
    return a ** 2

def kob(a):
    print(f'A köb függvényen belül: {a}')
    return a ** 3

a = 0
print(f'A függvényen kívül: {a}')
print(negyzet(2))
print(kob(3))
print()



def negyzet_(a):
    global szam
    szam = 10
    print(f'A négyzet függvényen belül: {szam}')
    return a ** 2

print(negyzet_(2))
print(f'A négyzet függvényen kívül: {szam}')
print('\n\n')





# -----BEZÁRÓ VÁLTOZÓK (ENCLOSING SCOPE)-----

def kulso_fgv():
    szam = 17

    def belso_fgv():
        print(f'A belső függvényből {szam}')

    belso_fgv()

kulso_fgv()
print('\n\n')





# -----BUILT-IN SCOPE-----

print(len(dir(__builtins__)))
print('\n\n')





# -----TOVÁBBI PÉLDÁK-----

def negyzet__(a):
    print(f'A négyzet függvényen belül: {szam + 1}')
    return a ** 2

szam = 17
print(negyzet__(2))
print()



def negyzet__(a):
    return a ** 2

def main():
    print(negyzet__(2))

main()