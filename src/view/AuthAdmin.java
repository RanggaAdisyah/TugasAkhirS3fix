package view;

import controller.AdminController;
import model.Admin;

class AuthAdmin implements AuthInterface {
    private AdminController adminController;

    public AuthAdmin(AdminController adminController) {
        this.adminController = adminController;
    }

    @Override
    public void authenticate(String username, String password) {
        Admin admin = new Admin(username, password);

        if (admin.getUsername().equals("admin") && admin.getPassword().equals("adminpass")) {
            System.out.println("Admin Login Successful!");
            AdminView adminView = new AdminView(adminController);
            adminView.displayMainMenu();
        } else {
            System.out.println("Invalid credentials. Admin login failed.");
        }
    }
}
