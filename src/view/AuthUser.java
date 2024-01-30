package view;

import controller.UserController;
import model.User;

class AuthUser implements AuthInterface {
    private UserController userController;

    public AuthUser(UserController userController) {
        this.userController = userController;
    }

    @Override
    public void authenticate(String username, String password) {
        User user = new User(username, password);

        if (user.getUsername().equals("user") && user.getPassword().equals("userpass")) {
            System.out.println("User Login Successful!");
            UserView userView = new UserView(userController);
            userView.displayMainMenu();
        } else {
            System.out.println("Invalid credentials. User login failed.");
        }
    }
}
