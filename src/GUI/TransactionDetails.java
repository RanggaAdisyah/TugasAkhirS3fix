package GUI;

import controller.UserController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

abstract class TransactionDetails extends JFrame {
    private JTable transactionTable;
    private DefaultTableModel tableModel;

    public TransactionDetails(UserController userController) {
        setTitle("Transaction Details");
        setSize(600, 400);
        setLayout(new BorderLayout());
        component(userController);
        loadTableData();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void component(UserController userController) {
        transactionTable = new JTable();
        tableModel = new DefaultTableModel();
        transactionTable.setModel(tableModel);

        String[] columnNames = {"Visitor", "Film", "Jadwal", "Studio"};
        tableModel.setColumnIdentifiers(columnNames);

        JScrollPane scrollPane = new JScrollPane(transactionTable);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void loadTableData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(UserController.USER_FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String pengunjung = parts[0];
                    String filmjudul = parts[1];
                    String jadwal = parts[2];
                    String studio = parts[3];

                    Object[] rowData = {pengunjung, filmjudul, jadwal, studio};
                    tableModel.addRow(rowData);
                }
            }
            System.out.println("Transaction data loaded successfully from " + UserController.USER_FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
