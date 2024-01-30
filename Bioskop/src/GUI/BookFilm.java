package GUI;

import controller.UserController;
import model.Film;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

abstract class BookFilm extends JFrame {
    private JTextField textFilmjudul, textPengunjung;
    private JButton bookButton;
    private JLabel labelFilmjudul, labelPengunjung;

    public BookFilm(UserController userController) {
        setTitle("Book Film");
        setSize(400, 300);
        setLayout(null);
        component(userController);
        event(userController);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void component(UserController userController) {
        labelFilmjudul = new JLabel("Film Judul");
        labelFilmjudul.setBounds(50, 50, 100, 22);
        add(labelFilmjudul);

        textFilmjudul = new JTextField();
        textFilmjudul.setBounds(150, 50, 200, 22);
        add(textFilmjudul);

        labelPengunjung = new JLabel("Pengunjung");
        labelPengunjung.setBounds(50, 100, 100, 22);
        add(labelPengunjung);

        textPengunjung = new JTextField();
        textPengunjung.setBounds(150, 100, 200, 22);
        add(textPengunjung);

        bookButton = new JButton("Book");
        bookButton.setBounds(150, 150, 100, 30);
        add(bookButton);
    }

    private void event(UserController userController) {
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filmjudul = textFilmjudul.getText();
                String pengunjung = textPengunjung.getText();

                if (filmjudul.isEmpty() || pengunjung.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Isi semua data kosong");
                    return;
                }

                Film film = userController.findFilmByjudul(filmjudul);

                if (film != null) {
                    userController.bookTicket(filmjudul, pengunjung);

                    userController.saveTransactionToFile();

                    JOptionPane.showMessageDialog(null, "Ticket booked sukses untuk " + filmjudul);
                } else {
                    JOptionPane.showMessageDialog(null, "Film tidak ditemukan: " + filmjudul);
                }

                dispose();
            }
        });
    }
}
