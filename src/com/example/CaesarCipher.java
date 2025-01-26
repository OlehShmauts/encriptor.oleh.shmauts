package com.example;

public class CaesarCipher {
    private final AlphabetHandler alphabetHandler;

    public CaesarCipher() {
        this.alphabetHandler = new AlphabetHandler();
    }

    public String encrypt(String text, int key) {
        return shiftText(text, key);
    }

    public String decrypt(String text, int key) {
        return shiftText(text, -key);
    }

    private String shiftText(String text, int shift) {
        if (text == null || text.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        int alphabetLength = alphabetHandler.getAlphabetLength();

        for (char c : text.toCharArray()) {
            int index = alphabetHandler.getIndex(c);
            if (index != -1) {
                int newIndex = (index + shift) % alphabetLength;
                if (newIndex < 0) {
                    newIndex += alphabetLength;
                }
                result.append(alphabetHandler.getCharAt(newIndex));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}