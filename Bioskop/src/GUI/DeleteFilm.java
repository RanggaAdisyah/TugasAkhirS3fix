package GUI;

import controller.AdminController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

abstract class DeleteFilm extends JFrame {
    JTextField textJudul;
    JButton deleteButton;
    JLabel labelJudul;

    public DeleteFilm() {
        setTitle("Delete Film");
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

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(150, 100, 100, 28);
        add(deleteButton);
    }

    private void event() {
        deleteButton.addActionListener((ActionEvent e) -> {
            String judul = textJudul.getText();

            if (judul.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter the film title.");
                return;
            }

            AdminController adminController = new AdminController(new ArrayList<>());
            adminController.deleteFilm(judul);
            adminController.saveDataToFile();

            JOptionPane.showMessageDialog(this, "Film deleted successfully");
            dispose();
        });
    }

}
