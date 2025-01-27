package com.example;

public class AlphabetHandler {

    private final String ENGLISH_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private final String UKRAINIAN_ALPHABET = "АБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯабвгґдеєжзиіїйклмнопрстуфхцчшщьюя";
    private final String RUSSIAN_ALPHABET = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя";

    // Метод для отримання алфавіту за кодом мови
    public String getAlphabet(String languageCode) {
        return switch (languageCode) {
            case "EN" -> ENGLISH_ALPHABET;
            case "UA" -> UKRAINIAN_ALPHABET;
            case "RU" -> RUSSIAN_ALPHABET;
            default -> "";
        };
    }

    // Метод для перевірки, чи текст відповідає обраному алфавіту
    public boolean isTextInAlphabet(String text, String languageCode) {
        String alphabet = getAlphabet(languageCode);
        if (alphabet.isEmpty()) {
            return false;
        }

        for (char c : text.toCharArray()) {
            if (alphabet.indexOf(c) == -1 && !Character.isWhitespace(c)) {
                return false;
            }
        }
        return true;
    }
}
