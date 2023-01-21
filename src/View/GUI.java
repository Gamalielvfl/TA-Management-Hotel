package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class GUI {
    JFrame LogReg = new JFrame();
    JLabel login,Daftar, top;
    JRadioButton radiostaff, radiotamu;
    JTextField textkodepemesananlogin, textnama, textnotlp,textcheckin, textcheckout,textkodepemesanandaftar;
    JLabel labelnama, labelktplogin, labelnotlp, labelcheckin, labelkodedaftar, labelktpdaftar,labelcheckout,labelkodelogin;
    JButton check,reg;
    JPasswordField ktplogin,ktpdaftar;
    private boolean ceklogin = false;

    public GUI() {
        LogReg.setSize(700, 630);
        LogReg.setLayout(null);
        LogReg.getContentPane().setBackground(Color.GRAY);

        top = new JLabel("KAIMANA BEACH HOTEL");
        top.setBounds(50, 10, 600, 50);
        top.setFont(new Font("Times New Roman", Font.BOLD, 40));
        LogReg.add(top);

        //Staff
        login = new JLabel("login");
        login.setBounds(50, 50, 100, 100);
        login.setFont(new Font("Times New Roman", Font.BOLD, 30));
        LogReg.add(login);

        radiostaff = new JRadioButton("Staff");
        login.setBounds(100, 50, 100, 100);
        radiostaff.setBounds(30, 150, 100, 30);
        radiostaff.setBackground(Color.PINK);
        LogReg.add(radiostaff);

        radiotamu = new JRadioButton("Tamu");
        radiotamu.setBounds(149,150,100,30);
        radiotamu.setBackground(Color.PINK);
        LogReg.add(radiotamu);

        labelkodelogin = new JLabel("Kode");
        labelkodelogin.setBounds(38,188,30,30);
        LogReg.add(labelkodelogin);

        textkodepemesananlogin = new JTextField();
        textkodepemesananlogin.setBounds(30,210,200,30);
        LogReg.add(textkodepemesananlogin);

        labelktplogin = new JLabel("KTP");
        labelktplogin.setBounds(39,240,100,30);
        LogReg.add(labelktplogin);

        ktplogin = new JPasswordField();
        ktplogin.setBounds(30,279,280,36);
        LogReg.add(ktplogin);

        check = new JButton("Check");
        check.setBounds(90, 320, 180, 40);
        check.setBackground(Color.PINK);
        LogReg.add(check);

        Daftar = new JLabel("Registrasi");
        Daftar.setFont(new Font("Times New Roman", Font.BOLD,30));
        Daftar.setBounds(440,50,150,100);
        LogReg.add(Daftar);

        labelkodedaftar = new JLabel("Kode");
        labelkodedaftar.setBounds(400, 150, 30, 30);
        LogReg.add(labelkodedaftar);

        textkodepemesanandaftar = new JTextField();
        textkodepemesanandaftar.setBounds(400, 180, 200, 30);
        LogReg.add(textkodepemesanandaftar);

        labelnama = new JLabel("Nama");
        labelnama.setBounds(400, 210, 100, 30);
        LogReg.add(labelnama);

        textnama = new JTextField();
        textnama.setBounds(400, 240, 200, 30);
        LogReg.add(textnama);

        labelktpdaftar = new JLabel("KTP");
        labelktpdaftar.setBounds(400, 270, 100, 30);
        LogReg.add(labelktpdaftar);

        ktpdaftar = new JPasswordField();
        ktpdaftar.setBounds(400, 300, 200, 30);
        LogReg.add(ktpdaftar);

        labelnotlp = new JLabel("No Telepon");
        labelnotlp.setBounds(400, 330, 100, 30);
        LogReg.add(labelnotlp);

        textnotlp = new JTextField();
        textnotlp.setBounds(400, 360, 200, 30);
        LogReg.add(textnotlp);

        labelcheckin = new JLabel("CHECKIN (dd/mm/yyyy)");
        labelcheckin.setBounds(400, 390, 200, 30);
        LogReg.add(labelcheckin);

        textcheckin = new JTextField();
        textcheckin.setBounds(400, 420, 200, 30);
        LogReg.add(textcheckin);

        labelcheckout = new JLabel("CHECKOUT (dd/mm/yyyy)");
        labelcheckout.setBounds(400, 450, 200, 30);
        LogReg.add(labelcheckout);

        textcheckout = new JTextField();
        textcheckout.setBounds(400, 480, 200, 30);
        LogReg.add(textcheckout);

        reg = new JButton("Input");
        reg.setBounds(460,520,100,40);
        reg.setBackground(Color.PINK);
        LogReg.add(reg);

        LogReg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LogReg.setVisible(true);
        LogReg.setLocationRelativeTo(null);

        radiostaff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (radiostaff.isSelected()) {
                    radiotamu.setSelected(false);
                    ceklogin = true;
                }
            }
        });
        radiotamu.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (radiotamu.isSelected()){
                    radiostaff.setSelected(false);
                    ceklogin = false;
                }
            }
        });
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               if (ceklogin == true) {
                   try{
                       AllObjectController.admin.datastaff();
                       AllObjectController.admin.login(textkodepemesananlogin.getText(),ktplogin.getText());
                       String namastaff = AllObjectController.admin.staffentity().getNama();
                       JOptionPane.showMessageDialog(null,"Selamat Datang " + namastaff, "Information", JOptionPane.INFORMATION_MESSAGE);
                       StaffGUI staff = new StaffGUI();
                       LogReg.dispose();
                   } catch (Exception exception) {
                       JOptionPane.showMessageDialog(null,"kode atau ktp salah", "Information", JOptionPane.INFORMATION_MESSAGE);
                   }
                } else {
                    try {
                        AllObjectController.tamuc.login(textkodepemesananlogin.getText(), ktplogin.getText());
                        String nama = AllObjectController.tamuc.tamuentity().getNama();
                        JOptionPane.showMessageDialog(null, "Selamat Datang " + nama, "information", JOptionPane.INFORMATION_MESSAGE);
                        TamuGUI tamu = new TamuGUI();
                        LogReg.dispose();
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, "kode atau ktp salah", " information", JOptionPane.INFORMATION_MESSAGE);
                        kosong();
                    }
                }
            }
        });
       reg.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
               try {
                   String kodepemesanan = textkodepemesanandaftar.getText();
                   String ktp = ktpdaftar.getText();
                   String nama = textnama.getText();
                   String notlp = textnotlp.getText();
                   Date checkin = new Date(textcheckin.getText());
                   Date checkout = new Date(textcheckout.getText());
                   AllObjectController.tamuc.insert(kodepemesanan, nama, ktp, notlp, checkin, checkout);
                   JOptionPane.showMessageDialog(null, "Berhasil Di Input", "information", JOptionPane.INFORMATION_MESSAGE);
                   kosong();
               } catch (Exception exception){
                   JOptionPane.showMessageDialog(null,"Format Penulisan Salah","Registrasi", JOptionPane.INFORMATION_MESSAGE);
               }
           }
       });

    }
    void kosong() {
        textkodepemesanandaftar.setText(null);
        ktpdaftar.setText(null);
        textnama.setText(null);
        textnotlp.setText(null);
        textcheckin.setText(null);
        textkodepemesananlogin.setText(null);
        ktplogin.setText(null);
        textcheckout.setText(null);
    }

}
