import java.util.Scanner;

public class OnlineShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Auth auth = new Auth();

        System.out.println("Hello! For registration enter your login. Please, use just Latin letters or numbers!");
        String login = scanner.nextLine();

        System.out.println("Enter your password.");
        String password = scanner.nextLine();

        System.out.println("Confirm your password.");
        String confirmPassword = scanner.nextLine();

        try {
            auth.signUp(login, password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println(e.getLogin());
            e.printStackTrace();
        } catch (WrongPasswordException e) {
            System.out.println(e.getPassword());
            e.printStackTrace();
        }

        System.out.println("Registration has completed successfully!\n" +
                "Enter your login to sing in.");
        login = scanner.nextLine();

        System.out.println("Enter your password to sing in.");
        password = scanner.nextLine();

        try {
            auth.signIn(login, password);
        } catch (WrongLoginException e) {
            e.printStackTrace();
        }

        System.out.println("You has signed in successfully!");

    }
}
