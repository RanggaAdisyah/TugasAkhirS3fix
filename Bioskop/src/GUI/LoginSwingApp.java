package GUI;

import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginSwingApp extends JFrame {
    JButton buttonadmin;
    JButton buttonuser;
    JLabel judul;

    public LoginSwingApp() {
        setTitle("Bioskop");
        setSize(400, 600);
        setLayout(null);
        component();
        event();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void component() {
        judul = new JLabel("Bioskop Gokil");
        judul.setBounds(80, 195, 245, 50);
        judul.setFont(new Font("Arial", Font.BOLD, 32));
        add(judul);

        buttonadmin = new JButton("Admin");
        buttonadmin.setBounds(140, 361, 120, 50);
        add(buttonadmin);

        buttonuser = new JButton("User");
        buttonuser.setBounds(140, 463, 120, 50);
        add(buttonuser);
    }

    private void event() {
        buttonadmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String adminUsername = JOptionPane.showInputDialog("Enter Admin Username:");
                JPasswordField adminPasswordField = new JPasswordField();
                int option = JOptionPane.showConfirmDialog(null, adminPasswordField, "Enter Admin Password:", JOptionPane.OK_CANCEL_OPTION);
    
                if (option == JOptionPane.OK_OPTION) {
                    String adminPassword = new String(adminPasswordField.getPassword());
    
                    if (adminUsername.equals("admin") && adminPassword.equals("adminpass")) {
                        JOptionPane.showMessageDialog(null, "Admin Login Successful!");
                        new IsineAdmin();
                    } else {
                        JOptionPane.showMessageDialog(null, "Admin login failed.");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Admin login cancelled.");
                }
            }
        });

        buttonuser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userUsername = JOptionPane.showInputDialog("Enter User Username:");
                JPasswordField userPasswordField = new JPasswordField();
                int option = JOptionPane.showConfirmDialog(null, userPasswordField, "Enter User Password:", JOptionPane.OK_CANCEL_OPTION);
    
                if (option == JOptionPane.OK_OPTION) {
                    String userPassword = new String(userPasswordField.getPassword());
    
                    if (userUsername.equals("user") && userPassword.equals("userpass")) {
                        JOptionPane.showMessageDialog(null, "User Login Successful!");
                        new IsineUser();
                    } else {
                        JOptionPane.showMessageDialog(null, " User login failed.");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "User login cancelled.");
                }
            }
        });
    
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoginSwingApp();
        });
    }
}
