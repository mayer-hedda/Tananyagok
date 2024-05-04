# Hőmérséklet értékek 7:00, 15:00, 23:00 órakor

homersekletek = [[11, 19, 17], [13, 22, 20], [15, 30, 25], [7, 16, 15]]
print(homersekletek[0][2])
print()

for nap in homersekletek:
    for meres in nap:
        print(meres)
    print('-------------')

print('\n\n')



homersekletek = [[11, 19, 17], [13, 22, 20], [15, 30, 25], [7, 16, 15]]
print(homersekletek[0][2])
homersekletek[0][2] = 29
print(homersekletek[0][2])
print('\n\n')



homersekletek = [[11, 19, 17], [13, 22, 20], [15, 30, 25], [7, 16, 15]]
homersekletek.insert(1, [0, 0, 0])
print(homersekletek)
print()


homersekletek = [[11, 19, 17], [13, 22, 20], [15, 30, 25], [7, 16, 15]]
homersekletek[0].insert(1, 0)
print(homersekletek)
print('\n\n')



homersekletek = [[11, 19, 17], [13, 22, 20], [15, 30, 25], [7, 16, 15]]
del homersekletek[0][0]
print(homersekletek)
print()


homersekletek = [[11, 19, 17], [13, 22, 20], [15, 30, 25], [7, 16, 15]]
x = homersekletek[0].pop(0)
print(homersekletek)
print(x)