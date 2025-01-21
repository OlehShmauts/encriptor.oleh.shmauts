import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CaesarCipher cipher = new CaesarCipher();

        String option;
        while (true) {
            System.out.print("Choose an option (ENCRYPT/DECRYPT): ");
            option = scanner.nextLine().trim().toUpperCase();
            if (option.equals("ENCRYPT") || option.equals("DECRYPT")) {
                break;
            } else {
                System.out.println("Invalid option. Please choose ENCRYPT or DECRYPT.");
            }
        }

        System.out.print("Enter the text: ");
        String text = scanner.nextLine();

        System.out.print("Enter the key (a number): ");
        int key = Integer.parseInt(scanner.nextLine().trim());

        if (option.equals("ENCRYPT")) {
            String encryptedText = cipher.encrypt(text, key);
            System.out.println("Encrypted text: " + encryptedText);
        } else {
            String decryptedText = cipher.decrypt(text, key);
            System.out.println("Decrypted text: " + decryptedText);
        }
    }
}