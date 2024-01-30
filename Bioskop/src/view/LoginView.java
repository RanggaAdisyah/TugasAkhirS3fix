package view;

import controller.AdminController;
import controller.UserController;

import java.util.Scanner;

public class LoginView {
    private AuthAdmin authAdmin;
    private AuthUser authUser;
    private Scanner scanner;

    public LoginView(AdminController adminController, UserController userController) {
        this.authAdmin = new AuthAdmin(adminController);
        this.authUser = new AuthUser(userController);
        this.scanner = new Scanner(System.in);
    }

    public void displayLogin() {
        int userType;
        do {
            System.out.println("\nLogin:");
            System.out.println("1. Admin Login");
            System.out.println("2. User Login");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            userType = scanner.nextInt();
            scanner.nextLine();

            switch (userType) {
                case 1:
                    adminLogin();
                    break;
                case 2:
                    userLogin();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (userType != 0);
    }

    private void adminLogin() {
        System.out.print("Enter Admin Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Admin Password: ");
        String password = scanner.nextLine();
        authAdmin.authenticate(username, password);
    }

    private void userLogin() {
        System.out.print("Enter User Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter User Password: ");
        String password = scanner.nextLine();
        authUser.authenticate(username, password);
    }
}
