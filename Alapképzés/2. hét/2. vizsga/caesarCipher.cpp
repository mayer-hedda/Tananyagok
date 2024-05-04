#include <iostream>
#include <string>

std::string caesarCipherEncode(const std::string& input, int shift) {
    std::string encoded = "";
    
    for (char c : input) {
        if (isalpha(c)) {
            char base = isupper(c) ? 'A' : 'a';
            encoded += static_cast<char>((c - base + shift) % 26 + base);
        } else {
            encoded += c;
        }
    }
    
    return encoded;
}

std::string caesarCipherDecode(const std::string& input, int shift) {
    std::string decoded = "";
    
    for (char c : input) {
        if (isalpha(c)) {
            char base = isupper(c) ? 'A' : 'a';
            decoded += static_cast<char>((c - base - shift + 26) % 26 + base);
        } else {
            decoded += c;
        }
    }
    
    return decoded;
}

int main() {
    std::string inputText;
    int shift;

    std::cout << "Enter the text to encode: ";
    std::getline(std::cin, inputText);

    std::cout << "Enter the shift value: ";
    std::cin >> shift;
    
    std::string encodedText = caesarCipherEncode(inputText, shift);
    std::string decodedText = caesarCipherDecode(encodedText, shift);
    
    std::cout << "Original text: " << inputText << std::endl;
    std::cout << "Encoded text: " << encodedText << std::endl;
    std::cout << "Decoded text: " << decodedText << std::endl;
    
    return 0;
}
