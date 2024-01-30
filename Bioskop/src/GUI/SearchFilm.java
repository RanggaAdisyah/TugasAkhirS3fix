package GUI;

import controller.AdminController;
import model.Film;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

abstract class SearchFilm extends JFrame {
    JTextField textJudul;
    JButton searchButton;
    JLabel labelJudul;

    public SearchFilm() {
        setTitle("Search Film");
        setSize(400, 200);
        setLayout(null);
        component();
        event();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void component() {
        labelJudul = new JLabel("Judul");
        labelJudul.setBounds(50, 50, 68, 22);
        add(labelJudul);

        textJudul = new JTextField();
        textJudul.setBounds(150, 50, 150, 28);
        add(textJudul);

        searchButton = new JButton("Search");
        searchButton.setBounds(150, 100, 100, 28);
        add(searchButton);
    }

    private void event() {
        searchButton.addActionListener((ActionEvent e) -> {
            String judul = textJudul.getText();

            if (judul.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Pilih judul film");
                return;
            }

            AdminController adminController = new AdminController(new ArrayList<>());
            ArrayList<Film> films = adminController.searchFilm(judul);

            if (films.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Film tidak ada");
            } else {
                StringBuilder resultMessage = new StringBuilder("Search Results:\n");
                for (Film film : films) {
                    resultMessage.append(film.getjudul()).append(" | ").append(film.getjadwal()).append(" | ").append(film.getStudio()).append("\n");
                }
                JOptionPane.showMessageDialog(this, resultMessage.toString());
            }

            dispose();
        });
    }
}
