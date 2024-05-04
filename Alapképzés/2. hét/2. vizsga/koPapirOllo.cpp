#include <iostream>
#include <ctime>
#include <cstdlib>
#include <cctype> // A karakterek konvertálásához

std::string kpoFuggveny(const std::string& jatekosValasztas) {
    // Véletlenszerű gép választás generálása (0 - Kő, 1 - Papír, 2 - Olló)
    srand(time(0));
    int gepValasztas = rand() % 3;

    std::string gepValasztasSzoveg;
    if (gepValasztas == 0) {
        gepValasztasSzoveg = "kő";
    } else if (gepValasztas == 1) {
        gepValasztasSzoveg = "papír";
    } else {
        gepValasztasSzoveg = "olló";
    }

    std::string jatekosValasztasLower = jatekosValasztas;
    // Konvertálás kisbetűssé az összehasonlításhoz
    for (char& c : jatekosValasztasLower) {
        c = std::tolower(c);
    }

    std::string gyoztes;
    if ((jatekosValasztasLower == "kő" && gepValasztasSzoveg == "olló") ||
        (jatekosValasztasLower == "papír" && gepValasztasSzoveg == "kő") ||
        (jatekosValasztasLower == "olló" && gepValasztasSzoveg == "papír")) {
        gyoztes = "Játékos nyert";
    } else if ((gepValasztasSzoveg == "kő" && jatekosValasztasLower == "olló") ||
               (gepValasztasSzoveg == "papír" && jatekosValasztasLower == "kő") ||
               (gepValasztasSzoveg == "olló" && jatekosValasztasLower == "papír")) {
        gyoztes = "Gép nyert";
    } else {
        gyoztes = "Döntetlen";
    }

    std::string eredmenySzoveg = "Játékos választása: " + jatekosValasztas + "\nGép választása: " + gepValasztasSzoveg + "\nEredmény: " + gyoztes;
    return eredmenySzoveg;
}

int main() {
    int probalkozasokLimit = 3;
    int probalkozasok = 0;
    std::string jatekosValasztas;

    while (probalkozasok < probalkozasokLimit) {
        std::cout << "Válassz: Kő, Papír vagy Olló: ";
        std::cin >> jatekosValasztas;

        // Konvertálás kisbetűssé az összehasonlításhoz
        for (char& c : jatekosValasztas) {
            c = std::tolower(c);
        }

        if (jatekosValasztas == "kő" || jatekosValasztas == "papír" || jatekosValasztas == "olló") {
            std::string eredmeny = kpoFuggveny(jatekosValasztas);
            std::cout << std::endl << eredmeny << std::endl;
            break; // Kilépés a ciklusból, ha a választás megfelelő
        } else {
            probalkozasok++;
            if (probalkozasok < probalkozasokLimit) {
                std::cout << "Nem jó választ adtál meg. Még " << probalkozasokLimit - probalkozasok << " próbálkozásod van." << std::endl;
            } else {
                std::cout << "Túllépted a megengedett próbálkozások számát." << std::endl;
            }
        }
    }

    return 0;
}
