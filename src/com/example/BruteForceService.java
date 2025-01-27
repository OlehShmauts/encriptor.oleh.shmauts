package com.example;

public class BruteForceService {

    private final CaesarCipher cipher;

    public BruteForceService(CaesarCipher cipher) {
        this.cipher = cipher;
    }

    public void bruteForce(String content, String languageCode) {
        System.out.println("Attempting to brute force...");

        // Отримуємо алфавіт і його довжину
        String alphabet = cipher.getAlphabetHandler().getAlphabet(languageCode);
        int alphabetLength = alphabet.length();

        String bestGuess = null;
        int bestKey = -1;

        for (int key = 1; key < alphabetLength; key++) { // Перебираємо всі ключі
            String decrypted = cipher.decrypt(content, key, languageCode);
            System.out.println("Key " + key + ": " + decrypted);

            if (isValidDecryption(decrypted)) {
                bestGuess = decrypted;
                bestKey = key;
                break;
            }
        }

        if (bestGuess != null) {
            System.out.println("Best guess found with key " + bestKey + ": " + bestGuess);
            saveDecryptedFile(bestGuess, bestKey, languageCode);
        } else {
            System.out.println("No valid decryption found.");
        }
    }

    // Метод для перевірки, чи текст виглядає валідним
    private boolean isValidDecryption(String decryptedText) {
        return decryptedText.contains("Hello") || decryptedText.contains("World");
    }

    // Метод для збереження розшифрованого тексту у файл
    private void saveDecryptedFile(String decryptedContent, int key, String languageCode) {
        String fileName = "/Users/olehshmauts/Desktop/Decrypted_with_key_" + key + ".txt";

        try {
            FileService fileService = new FileService();
            fileService.writeFile(fileName, decryptedContent, null);
            System.out.println("Decrypted file saved as: " + fileName);
        } catch (Exception e) {
            System.err.println("Error saving file: " + e.getMessage());
        }
    }
}
