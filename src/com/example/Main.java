package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ініціалізація сервісів
        AlphabetHandler alphabetHandler = new AlphabetHandler();
        CaesarCipher cipher = new CaesarCipher(alphabetHandler);
        FileService fileService = new FileService();
        BruteForceService bruteForceService = new BruteForceService(cipher);

        System.out.print("Choose an option (ENCRYPT/DECRYPT/BRUTE_FORCE): ");
        String option = scanner.nextLine().trim().toUpperCase();

        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();

        try {
            String content = fileService.readFile(filePath);

            System.out.print("Enter the language (EN/UA/RU): ");
            String languageCode = scanner.nextLine().trim().toUpperCase();

            // Перевіряємо, чи текст відповідає вибраному алфавіту
            while (!alphabetHandler.isTextInAlphabet(content, languageCode)) {
                System.out.println("The selected language does not match the text. Please choose another language.");
                System.out.print("Enter the language (EN/UA/RU): ");
                languageCode = scanner.nextLine().trim().toUpperCase();
            }

            if (option.equals("ENCRYPT")) {
                System.out.print("Enter the key (a number): ");
                int key = Integer.parseInt(scanner.nextLine().trim());
                String encrypted = cipher.encrypt(content, key, languageCode);
                fileService.writeFile(filePath, encrypted, "[ENCRYPTED]");
                System.out.println("File encrypted successfully!");

            } else if (option.equals("DECRYPT")) {
                System.out.print("Enter the key (a number): ");
                int key = Integer.parseInt(scanner.nextLine().trim());
                String decrypted = cipher.decrypt(content, key, languageCode);
                fileService.writeFile(filePath, decrypted, "[DECRYPTED]");
                System.out.println("File decrypted successfully!");

            } else if (option.equals("BRUTE_FORCE")) {
                bruteForceService.bruteForce(content, languageCode);
            } else {
                System.out.println("Invalid option. Please choose ENCRYPT, DECRYPT, or BRUTE_FORCE.");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
