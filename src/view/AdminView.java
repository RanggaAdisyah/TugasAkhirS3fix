package view;

import controller.AdminController;
import java.util.Scanner;

public class AdminView {
    private AdminController adminController;
    private Scanner scanner;

    public AdminView(AdminController adminController) {
        this.adminController = adminController;
        this.scanner = new Scanner(System.in);
    }

    public void displayMainMenu() {
        int choice;
        do {
          System.out.println("\nAdmin Menu:");
          System.out.println("1. Add Film");
          System.out.println("2. Manage Film jadwal");
          System.out.println("3. Delete Film");
          System.out.println("4. Display Film List");
          System.out.println("5. Save Data to File");
          System.out.println("0. Exit");
          System.out.print("Enter your choice: ");
          choice = scanner.nextInt();
          scanner.nextLine();

          switch (choice) {
              case 1:
                  addFilm();
                  break;
              case 2:
                  managejadwal();
                  break;
              case 3:
                  deleteFilm();
                  break;
              case 4:
                  displayFilmList();
                  break;
              case 5:
                  saveDataToFile();
                  break;
              case 0:
                  System.out.println("Exiting Admin Menu...");
                  break;
              default:
                  System.out.println("Invalid choice. Please try again.");
          }
      } while (choice != 0);
  }


    private void addFilm() {
        System.out.print("Enter Film judul: ");
        String judul = scanner.nextLine();
        System.out.print("Enter Film jadwal: ");
        String jadwal = scanner.nextLine();
        System.out.print("Enter Film Studio: ");
        String studio = scanner.nextLine();

        adminController.addFilm(judul, jadwal, studio);
    }

    private void managejadwal() {
        System.out.print("Enter Film judul to Manage jadwal: ");
        String filmjudul = scanner.nextLine();
        System.out.print("Enter New jadwal: ");
        String newjadwal = scanner.nextLine();

        adminController.managejadwal(filmjudul, newjadwal);
    }

    private void deleteFilm() {
        System.out.print("Enter Film judul to Delete: ");
        String filmjudul = scanner.nextLine();
        adminController.deleteFilm(filmjudul);
    }

    private void displayFilmList() {
        adminController.displayFilmList();
    }

    private void saveDataToFile() {
      adminController.saveDataToFile();
  }

}
