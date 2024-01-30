package GUI;

import controller.AdminController;
import controller.UserController;
import model.Film;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class IsineUser extends JFrame {
    JButton butTransaksi, butBook, butSearch;
    JLabel judul;
    JTable filmTable;
    DefaultTableModel tableModel;
    private UserController userController;

    public IsineUser() {
        userController = new UserController(new ArrayList<>());
        setTitle("Bioskop");
        setSize(1000, 600);
        setLayout(null);
        component();
        event();
        loadTableData();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void component(){
        judul = new JLabel("User Page");
        judul.setBounds(55, 57, 187, 39);
        judul.setFont(new Font("Arial", Font.BOLD, 32));
        add(judul);

        butSearch = new JButton("Search Film");
        butSearch.setBounds(55, 150, 120, 50);
        add(butSearch);

        butBook = new JButton("Book Film");
        butBook.setBounds(55, 250, 120, 50);
        add(butBook);

        butTransaksi = new JButton("Detail Transactions");
        butTransaksi.setBounds(55, 350, 120, 50);
        add(butTransaksi);

        filmTable = new JTable();
        tableModel = new DefaultTableModel();
        filmTable.setModel(tableModel);

        String[] columnNames = {"Judul", "Jadwal", "Studio"};
        tableModel.setColumnIdentifiers(columnNames);

        JScrollPane scrollPane = new JScrollPane(filmTable);
        scrollPane.setBounds(350, 120, 500, 300);
        add(scrollPane);

    }

    private void event(){
        butSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchFilm() {};
            }
        });

        butBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BookFilm(userController){};
            }
        });
        
        butTransaksi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TransactionDetails(userController){};
            }
        });
    }

    private void loadTableData() {
        AdminController adminController = new AdminController(new ArrayList<>());
        ArrayList<Film> films = adminController.getFilms();
        for (Film film : films) {
            Object[] rowData = {film.getjudul(), film.getjadwal(), film.getStudio()};
            tableModel.addRow(rowData);
        }
    }

    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new IsineUser();
        });
    }
}