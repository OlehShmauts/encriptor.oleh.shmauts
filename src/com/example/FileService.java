package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileService {

    // Метод для зчитування тексту з файлу
    public String readFile(String filePath) throws IOException {
        return Files.readString(Path.of(filePath)); // Зчитує текст із файлу
    }

    // Метод для запису тексту у файл
    public void writeFile(String filePath, String content, String suffix) throws IOException {
        String newFilePath = generateNewFileName(filePath, suffix); // Генеруємо нове ім'я файлу
        Files.writeString(Path.of(newFilePath), content); // Записуємо текст у файл
        System.out.println("Result saved to: " + newFilePath);
    }

    // Метод для створення нового імені файлу з позначкою
    private String generateNewFileName(String filePath, String suffix) {
        int dotIndex = filePath.lastIndexOf('.'); // Знаходимо позицію останньої крапки
        if (dotIndex != -1) {
            return filePath.substring(0, dotIndex) + suffix + filePath.substring(dotIndex);
        } else {
            return filePath + suffix; // Якщо розширення файлу немає
        }
    }
}
