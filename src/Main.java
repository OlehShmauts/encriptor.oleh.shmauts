import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CaesarCipher cipher = new CaesarCipher();
        InputService InputService = new InputService();

        System.out.print("Enter text to encrypt: ");
        String text = scanner.nextLine();

        int key = InputService.readKey(scanner);

        String encryptedText = cipher.encrypt(text, key);
        System.out.println("Encrypted text: " + encryptedText);
    }


}