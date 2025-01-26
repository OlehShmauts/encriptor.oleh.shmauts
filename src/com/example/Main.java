package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CaesarCipher cipher = new CaesarCipher();
        FileService fileService = new FileService();

        System.out.print("Choose an option (ENCRYPT/DECRYPT): ");
        String option = scanner.nextLine().trim().toUpperCase();

        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();

        System.out.print("Enter the key (a number): ");
        int key = Integer.parseInt(scanner.nextLine().trim());

        try {
            // Зчитуємо текст із файлу
            String content = fileService.readFile(filePath);
            System.out.println("File content: " + content); // Перевіряємо вхідні дані

            // Виконуємо шифрування або дешифрування
            String result;
            if (option.equals("ENCRYPT")) {
                result = cipher.encrypt(content, key);
            } else if (option.equals("DECRYPT")) {
                result = cipher.decrypt(content, key);
            } else {
                System.out.println("Invalid option.");
                return;
            }

            System.out.println("Processed content: " + result); // Перевіряємо результат

            // Записуємо результат у файл
            fileService.writeFile(filePath, result, option.equals("ENCRYPT") ? "[ENCRYPTED]" : "[DECRYPTED]");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
