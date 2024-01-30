package GUI;

import controller.AdminController;
import model.Film;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class IsineAdmin extends JFrame {
    JButton butAdd, butDel, butUpdate, butSearch;
    JLabel judul;
    JTable filmTable;
    DefaultTableModel tableModel;

    public IsineAdmin() {
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
        judul = new JLabel("Admin Page");
        judul.setBounds(55, 57, 187, 39);
        judul.setFont(new Font("Arial", Font.BOLD, 32));
        add(judul);

        butAdd = new JButton("Add Film");
        butAdd.setBounds(55, 150, 120, 50);
        add(butAdd);

        butDel = new JButton("Delete Film");
        butDel.setBounds(55, 250, 120, 50);
        add(butDel);

        butUpdate = new JButton("Update Film");
        butUpdate.setBounds(55, 350, 120, 50);
        add(butUpdate);

        butSearch = new JButton("Search Film");
        butSearch.setBounds(55, 450, 120, 50);
        add(butSearch);

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
        butAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddFilm() {};
            }
        });

        butDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteFilm(){};
            }
        });

        butUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateFilm(){};
            }
        });

        butSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchFilm(){};
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
            new IsineAdmin();
        });
    }
}