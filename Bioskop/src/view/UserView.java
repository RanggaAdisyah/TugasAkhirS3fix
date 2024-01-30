package view;

import controller.UserController;
import model.Film;

import java.util.Scanner;

public class UserView {
    private UserController userController;
    private Scanner scanner;

    public UserView(UserController userController) {
        this.userController = userController;
        this.scanner = new Scanner(System.in);
    }

    public void displayMainMenu() {
        int choice;
        do {
            System.out.println("\nUser Menu:");
            System.out.println("1. Display Available Films");
            System.out.println("2. Search Film by judul");
            System.out.println("3. Book Ticket");
            System.out.println("4. Display Transaction Details");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayAvailableFilms();
                    break;
                case 2:
                    searchFilmByjudul();
                    break;
                case 3:
                    bookTicket();
                    break;
                case 4:
                    displayTransactionDetails();
                    break;
                case 0:
                    System.out.println("Exiting User Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private void displayAvailableFilms() {
        userController.displayAvailableFilms();
    }

    private void searchFilmByjudul() {
        System.out.print("Enter Film judul to Search: ");
        String filmjudul = scanner.nextLine();

        Film foundFilm = userController.findFilmByjudul(filmjudul);
        if (foundFilm != null) {
            System.out.println("Film Found:");
            System.out.println(foundFilm.getjudul() + " | " + foundFilm.getjadwal() + " | " + foundFilm.getStudio());
        } else {
            System.out.println("Film not found: " + filmjudul);
        }
    }

    private void bookTicket() {
        System.out.print("Enter Film judul to Book Ticket: ");
        String filmjudul = scanner.nextLine();
        System.out.print("Enter Your Name: ");
        String pengunjung = scanner.nextLine();

        userController.bookTicket(filmjudul, pengunjung);
    }

    private void displayTransactionDetails() {
        userController.displayTransactionDetails();
        userController.saveTransactionToFile();
    }
}
