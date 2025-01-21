import java.util.Scanner;

public class InputService {

    /**
     * Метод для зчитування ключа з перевіркою вводу
     * @param scanner Scanner для вводу користувача
     * @return Коректне числове значення ключа
     */
    public int readKey(Scanner scanner) {
        while (true) {
            System.out.print("Enter the key (a valid integer): ");
            String input = scanner.nextLine().trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}