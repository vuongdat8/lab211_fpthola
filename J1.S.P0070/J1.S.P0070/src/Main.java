import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        eBank ebank = new eBank();
        LoginManager loginManager = new LoginManager(ebank, sc);
        int choice;

        do {
            System.out.println("-------Login Program-------");
            System.out.println("1. Vietnamese");
            System.out.println("2. English");
            System.out.println("3. Exit");
            System.out.print("Please choose one option: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    ebank.setLocale("vi");
                    loginManager.loginProcess();
                    break;
                case 2:
                    ebank.setLocale("en");
                    loginManager.loginProcess();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        } while (choice != 3);
    }
}
