package View;

import Entity.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class TamuGUI {
    JFrame tamu = new JFrame();
    JButton back, checkin, checkout;
    JTextArea area = new JTextArea();
    JLabel datadiri, daftarcheckin,daftarcheckout;
    JComboBox pilkamar = new JComboBox(ruanganentity.nama);
    int cek = AllObjectController.tamuc.cekDaftarTamu(AllObjectController.tamuc.tamuentity().getKodepemesanan());

    public TamuGUI() {
        tamu.setSize(720, 600);
        tamu.setLayout(null);
        tamu.getContentPane().setBackground(Color.PINK);

        datadiri = new JLabel("Data Tamu");
        datadiri.setFont(new Font("Times New Roman", Font.BOLD, 30));
        datadiri.setBounds(90, 30, 200, 30);
        tamu.add(datadiri);

        area.setBounds(30, 90, 400, 300);
        tamu.add(area);

        daftarcheckin = new JLabel("Daftar Kamar");
        daftarcheckin.setBounds(450, 30, 250, 30);
        daftarcheckin.setFont(new Font("Times New Roman", Font.BOLD, 30));
        tamu.add(daftarcheckin);

        pilkamar.setBounds(450,200,100,30);
        tamu.add(pilkamar);

        checkin = new JButton("Pilih");
        checkin.setBounds(550, 200, 100, 30);
        checkin.setBackground(Color.GRAY);
        tamu.add(checkin);

        back = new JButton("back");
        back.setBounds(30, 500, 100, 30);
        back.setBackground(Color.red);
        tamu.add(back);

        tamu.setVisible(true);
        tamu.setLocationRelativeTo(null);
        tamu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if (cek == -1) {
            JOptionPane.showMessageDialog(null, "Anda Belum Pilih Kamar", "information", JOptionPane.INFORMATION_MESSAGE);
        } else if (cek == -2) {
            JOptionPane.showMessageDialog(null, "Anda Belum Pilih Kamar", "information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            area.setText(datatamu());
        }
        checkin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int indexkamar = pilkamar.getSelectedIndex();
                AllObjectController.tamuc.daftarreservasi(indexkamar,AllObjectController.tamuc.getData(), false);
                area.setText(datatamu());
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tamu.dispose();
                GUI men = new GUI();
            }
        });
    }

    public String datatamu() {
        int cek = AllObjectController.tamuc.cekDaftarTamu(AllObjectController.tamuc.tamuentity().getKodepemesanan());
        String cekverif;
        if (AllObjectController.tamuc.showdaftarreservasi(cek).isVerified() == false) {
           cekverif = "Checkin";
        } else {
            cekverif = "Checkout";
        }
        String text = "Kode Pemesanan " + AllObjectController.tamuc.showdaftarreservasi(cek).getTamu().getKodepemesanan() + "\n"
                + "Nama = " + AllObjectController.tamuc.showdaftarreservasi(cek).getTamu().getNama() + "\n"
                + "KTP = " + AllObjectController.tamuc.showdaftarreservasi(cek).getTamu().getKtp() + "\n"
                + "No Telp = " + AllObjectController.tamuc.showdaftarreservasi(cek).getTamu().getNotlp() + "\n"
                + "Checkin = " + new SimpleDateFormat("dd-MM-yyyy").format(AllObjectController.tamuc.showdaftarreservasi(cek).getTamu().getCheckin()) + "\n"
                + "Checkout = " + new SimpleDateFormat ("dd-MM-yyyy").format(AllObjectController.tamuc.showdaftarreservasi(cek).getTamu().getCheckout())  +"\n"
                + "verifikasi = " + cekverif + "\n"
                + "Jenis Kamar = " + ruanganentity.nama[AllObjectController.tamuc.showdaftarreservasi(cek).getIndexRoom()];
                return text;
    }

}
