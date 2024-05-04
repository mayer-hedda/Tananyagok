'''
A megadott halmazok alapján a program értékelje ki, és az eredményt jelenítse meg a képernyőn az alábbiakat vizsgálva:
    - hány olyan étel van, amit mind a két gyerek szeret, és melyek ezek,
    - melyek azok az ételek, amiket Peti szeret, de Kriszti nem,
    - melyek azok az ételek, melyeket csak egyikük szeret!
'''
Peti_kedvencei = {'halászlé', 'bécsi szelet', 'bukta', 'rakott krumpli', 'almás rétes'}
Kriszti_kedvencei = {'borsóleves', 'bécsi szelet', 'túrós tészta', 'lecsó', 'almás rétes'}

if len(Peti_kedvencei & Kriszti_kedvencei) != 0:
    print(f'{len(Peti_kedvencei & Kriszti_kedvencei)} olyan étel van, amit mind a két gyerek szeret, ezek a következők:', ', '.join(Peti_kedvencei & Kriszti_kedvencei))
else:
    print('Nincs olyan étel, amit mind a két gyerek szeret.')


if len(Peti_kedvencei - Kriszti_kedvencei) != 0:
    print('Az ételek, amit csak Peti szeret, de Kriszti nem, a következők:', ', '.join(Peti_kedvencei - Kriszti_kedvencei))
else:
    print('Nincs olyan étel Peti kedvencei között, amit nem szeretne Kriszti.')


if len(Peti_kedvencei ^ Kriszti_kedvencei) != 0:
    print('Az ételek, amit csak az egyikük szeret, a következők:', ', '.join(Peti_kedvencei ^ Kriszti_kedvencei))
else:
    print('Nincs olyan étel, amit csak az egyikük szeret.')

