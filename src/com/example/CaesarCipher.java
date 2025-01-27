package com.example;

public class CaesarCipher {
    private final AlphabetHandler alphabetHandler;

    public CaesarCipher(AlphabetHandler alphabetHandler) {
        this.alphabetHandler = alphabetHandler;
    }

    public AlphabetHandler getAlphabetHandler() {
        return alphabetHandler;
    }

    public String encrypt(String text, int key, String languageCode) {
        String alphabet = alphabetHandler.getAlphabet(languageCode);
        return shiftText(text, key, alphabet);
    }

    public String decrypt(String text, int key, String languageCode) {
        String alphabet = alphabetHandler.getAlphabet(languageCode);
        return shiftText(text, -key, alphabet);
    }

    private String shiftText(String text, int shift, String alphabet) {
        if (text == null || text.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        int alphabetLength = alphabet.length();

        for (char c : text.toCharArray()) {
            int index = alphabet.indexOf(c);
            if (index != -1) {
                int newIndex = (index + shift) % alphabetLength;
                if (newIndex < 0) {
                    newIndex += alphabetLength;
                }
                result.append(alphabet.charAt(newIndex));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}
