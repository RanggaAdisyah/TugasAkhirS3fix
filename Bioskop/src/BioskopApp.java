import controller.AdminController;
import controller.UserController;
import view.LoginView;
import model.Film;

import java.util.ArrayList;

public class BioskopApp {
    public static void main(String[] args) {
        ArrayList<Film> availableFilms = new ArrayList<>();

        AdminController adminController = new AdminController(availableFilms);
        UserController userController = new UserController(availableFilms);
        LoginView loginView = new LoginView(adminController, userController);

        loginView.displayLogin();
    }
}
