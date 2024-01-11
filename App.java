import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        BankSingleton bank = BankSingleton.getInstance();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            System.out.print(" welcome to our the Bank! \n Do you currently have an account? [yes/no] : ");
            String choice = scanner.nextLine().toLowerCase();

            if ("yes".equals(choice)) {
                System.out.print("Enter your username: ");
                String username = scanner.nextLine();
                System.out.print("Enter your password: ");
                String password = scanner.nextLine();
                User user = bank.authenticateUser(username, password);
                if (user != null) {
                    System.out.println("Welcome To the Bank !  ");
                    bankaccount userAccount = user.getAccount();
                    userAccount.displayTransactionHistory();

                    System.out.print("Which operation you would like to do [deposit/withdraw]: ");
                    String operation = scanner.nextLine().toLowerCase();

                    // ...

                    if ("deposit".equals(operation)) {
                        System.out.print("Enter deposit amount: ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine(); // Consume the newline character
                        userAccount.deposit(amount);
                    } else if ("withdraw".equals(operation)) {
                        System.out.print("Enter withdrawal amount: ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine(); // Consume the newline character
                        userAccount.withdraw(amount);
                    }

                    // ...

                    System.out.println("New balance: " + userAccount.getBalance() + "KWD");
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Would you like to prform another operation? [yes/no]: ");
                    String anotherOperation = scanner.nextLine().toLowerCase();

                    if ("no".equals(anotherOperation)) {
                        exit = true;
                    }
                } else {
                    System.out.println("Invalid input. please try again !");
                }

            } else if ("no".equals(choice)) {
                System.out.print("Enter a new username: ");
                String username = scanner.nextLine();
                System.out.print("Enter a new password: ");
                String password = scanner.nextLine();
                User newUser = bank.createAccount(username, password);

                if (newUser != null) {
                    System.out.println("Account created successfully!");
                } else {
                    System.out.println("Username already exists. Please choose a different one.");
                }
            }
        }

        System.out.println("thanks!");

        scanner.close();
    }
}
