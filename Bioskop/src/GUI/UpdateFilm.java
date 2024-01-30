package GUI;

import controller.AdminController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

abstract class UpdateFilm extends JFrame {
    JTextField textJudul, textNewJadwal;
    JButton updateButton;
    JLabel labelJudul, labelNewJadwal;

    public UpdateFilm() {
        setTitle("Update Film");
        setSize(400, 300);
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

        labelNewJadwal = new JLabel("New Jadwal");
        labelNewJadwal.setBounds(50, 100, 100, 22);
        add(labelNewJadwal);

        textNewJadwal = new JTextField();
        textNewJadwal.setBounds(150, 100, 150, 28);
        add(textNewJadwal);

        updateButton = new JButton("Update");
        updateButton.setBounds(150, 150, 100, 28);
        add(updateButton);
    }

    private void event() {
        updateButton.addActionListener((ActionEvent e) -> {
            String judul = textJudul.getText();
            String newJadwal = textNewJadwal.getText();

            if (judul.isEmpty() || newJadwal.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.");
                return;
            }

            AdminController adminController = new AdminController(new ArrayList<>());
            adminController.managejadwal(judul, newJadwal);
            adminController.saveDataToFile();

            JOptionPane.showMessageDialog(this, "Film updated successfully");
            dispose();
        });
    }
}
