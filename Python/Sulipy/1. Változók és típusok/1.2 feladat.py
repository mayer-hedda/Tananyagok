'''
Készíts egy programot, amely három sor szöveget ír ki a képernyőre!
Miután a programod jól működik, alakítsd át hibássá,
és nézd meg, hogyan jelöli a hibát a fejlesztői környezet,
és milyen hibaüzeneteket kapsz futtatáskor, ha:
    a print szó szerepel hiányosan,
    az idézőjel kezdő vagy záró részét hagyod el,
    a zárójel nyitó vagy záró tagját nem teszed ki!
'''
print('''1. sor
2. sor
3. sor''')


# ---- HIBÁK ----

# prit('1. sor') | NameError: name 'prit' is not defined. Did you mean: 'print'?
# print('2. sor) | SyntaxError: unterminated string literal (detected at line 16)
# print('3. sor' | SyntaxError: '(' was never closed