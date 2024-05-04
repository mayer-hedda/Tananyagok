from datetime import datetime


class Gepjarmu:
    def __init__(self, rendszam, ossz_km, kov_szerviz, szakasz_km):
        self.rendszam = rendszam
        self.ossz_km = ossz_km
        self.kov_szerviz = kov_szerviz
        self.szakasz_km = szakasz_km

    def szerviz(self):
        return self.kov_szerviz - datetime.now().year

    def vissza_km(self):
        return 'Benzines vagy elektromos?'


class Taxi(Gepjarmu):
    def __init__(self, rendszam, ossz_km, kov_szerviz, szakasz_km, fogyasztas=6.0, tank_l=35):
        super().__init__(rendszam, ossz_km, kov_szerviz, szakasz_km)
        self.fogyasztas = fogyasztas
        self.tank_l = tank_l

    def vissza_km(self):
        return round(self.tank_l / self.fogyasztas * 100 - self.szakasz_km)


class ETaxi(Gepjarmu):
    def __init__(self, rendszam, ossz_km, kov_szerviz, szakasz_km, hatotav=600):
        super().__init__(rendszam, ossz_km, kov_szerviz, szakasz_km)
        self.hatotav = hatotav

    def vissza_km(self):
        return self.hatotav - self.szakasz_km


gpj01 = Gepjarmu('P-001', 50000, 2022, 120)
taxi01 = Taxi('ABC123', 60000, 2023, 300, 5.8, 37)
etaxi01 = ETaxi('AAA111', 35000, 2025, 225, 700)

print(gpj01)
print(taxi01)
print(etaxi01)

print(isinstance(taxi01, Taxi))
print(isinstance(taxi01, Gepjarmu))

print(isinstance(taxi01, object))



# minden egy objektum
print(type(5), type(7.2), type('alma'), type(True))
print(type([1, 2, 3]), type((1, 2)), type({'név': 'Aladár'}))