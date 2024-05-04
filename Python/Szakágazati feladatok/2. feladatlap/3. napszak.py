# from random import randint
from datetime import datetime

nev = input('Adja meg a nevét: ')
# ora = randint(0, 23)
ora = int(((str(datetime.today()).split())[1].split(':'))[0])

napszak = None
if ora >= 6 and ora < 8:
    napszak = 'reggel'
elif ora >= 8 and ora < 12:
    napszak = 'délelőtt'
elif ora == 12:
    napszak = 'dél'
elif ora > 12 and ora < 18:
    napszak = 'délután'
elif ora >= 18 and ora <= 23:
    napszak = 'este'
elif ora == 0:
    napszak = 'éjfél'
elif ora > 0 and ora < 4:
    napszak = 'éjjel'
elif ora >= 4 and ora < 6:
    napszak = 'hajnal'

print(f'Üdvözöllek {nev}, {napszak} van.')

