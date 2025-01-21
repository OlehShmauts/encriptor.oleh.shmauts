public class CaesarCipher {
    private static final String ALPHABET =   "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz" + // Англійський алфавіт
            "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя" + // Російський алфавіт
            "АБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯабвгґдеєжзиіїйклмнопрстуфхцчшщьюя"; // Український алфавіт

    public String encrypt(String text, int key) {
        StringBuilder result = new StringBuilder();
        int alphabetLength = ALPHABET.length();

        for (char c : text.toCharArray()) {
            int index = ALPHABET.indexOf(c);
            if (index != -1) {
                int newIndex = (index + key) % alphabetLength;
                result.append(ALPHABET.charAt(newIndex));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}