import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CaesarCipher cipher = new CaesarCipher();

        System.out.print("Enter text to encrypt: ");
        String text = scanner.nextLine();

        int key = readKey(scanner);

        String encryptedText = cipher.encrypt(text, key);
        System.out.println("Encrypted text: " + encryptedText);
    }

    /**
     * Метод для зчитування ключа з перевіркою вводу
     * @param scanner Scanner для вводу користувача
     * @return Коректне числове значення ключа
     */
    private static int readKey(Scanner scanner) {
        while (true) {
            System.out.print("Enter the key (a valid integer): ");
            String input = scanner.nextLine().trim();

            try {
                return Integer.parseInt(input); // Перетворюємо текст у число
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}