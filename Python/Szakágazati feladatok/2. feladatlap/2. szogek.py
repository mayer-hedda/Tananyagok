while True:
    fok = int(input('Adja meg egy szögnek a nagyságát fokban (0-360): '))
    if fok < 0 or fok > 360:
        print('Intervallumon kívüli számot adott meg!')
    else:
        break

if fok == 0:
    print('Ez egy nullszög.')
elif 0 < fok < 90:
    print('Ez egy hegyesszög.')
elif fok == 90:
    print('Ez egy derékszög.')
elif 90 < fok < 180:
    print('Ez egy tompaszög.')
elif fok == 180:
    print('Ez egy egyenesszög.')
elif 180 < fok < 360:
    print('Ez egy homorúszög.')
elif fok == 360:
    print('Ez egy teljesszög.')