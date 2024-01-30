package GUI;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.AdminController;


abstract class AddFilm extends JFrame {
    JTextField textJudul, textJadwal, textStudio;
    JButton save;
    JLabel labelJudul, labelJadwal, labelStudio;

    public AddFilm(){
        setTitle("Tambah Film");
        setSize(400, 600);
        setLayout(null);
        component();
        event();
        setVisible(true);
    }

    private void component(){
        labelJudul = new JLabel("Judul");
        labelJudul.setBounds(50, 100, 68, 22);
        add(labelJudul);

        labelJadwal = new JLabel("Jadwal");
        labelJadwal.setBounds(50, 200, 68, 22);
        add(labelJadwal);

        labelStudio = new JLabel("Studio");
        labelStudio.setBounds(50, 300, 68, 22);
        add(labelStudio);

        textJudul = new JTextField();
        textJudul.setBounds(147, 100, 146, 28);
        add(textJudul);

        textJadwal = new JTextField();
        textJadwal.setBounds(147, 200, 146, 28);
        add(textJadwal);

        textStudio = new JTextField();
        textStudio.setBounds(147, 300, 146, 28);
        add(textStudio);

        save = new JButton("Save");
        save.setBounds(147, 400, 146, 28);
        add(save);
    }

    private void event() {
        save.addActionListener(e -> {
            String judul = textJudul.getText();
            String jadwal = textJadwal.getText();
            String studio = textStudio.getText();
    
            if (judul.isEmpty() || jadwal.isEmpty() || studio.isEmpty()) {
                System.out.println("Isi semua data yang kosong");
                return;
            }
    
            AdminController adminController = new AdminController(new ArrayList<>());
    
            adminController.addFilm(judul, jadwal, studio);
    
            adminController.saveDataToFile();
        });
    }
    

}
