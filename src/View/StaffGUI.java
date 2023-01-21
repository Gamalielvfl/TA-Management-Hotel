package View;

import Controller.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StaffGUI {
    private static tamucontroller tamuc = new tamucontroller();
    JFrame staff = new JFrame();
    JTable tabeltamu = new JTable();
    JScrollPane scrollstaff = new JScrollPane(tabeltamu);
    JButton back , verif;
    JLabel admin,kodelabel,ktplabel;
    JTextField kodetext,ktptext;

    public StaffGUI(){
        staff.setSize(650,500);
        staff.setLayout(null);
        staff.getContentPane().setBackground(Color.PINK);

        admin = new JLabel("Admin");
        admin.setBounds(250, 30, 200, 30);
        admin.setFont(new Font("Times New Roman", Font.BOLD, 40));
        staff.add(admin);

        scrollstaff.setBounds(30, 100, 570, 200);
        tabeltamu.setModel(tamuc.daftartamu());
        staff.add(scrollstaff);

        kodelabel = new JLabel("Kode");
        kodelabel.setBounds(50, 320, 100, 30);
        staff.add(kodelabel);

        kodetext = new JTextField();
        kodetext.setBounds(50, 350, 100, 30);
        staff.add(kodetext);

        ktplabel = new JLabel("KTP");
        ktplabel.setBounds(200, 320, 100, 30);
        staff.add(ktplabel);

        ktptext = new JTextField();
        ktptext.setBounds(200, 350, 100, 30);
        staff.add(ktptext);

        verif = new JButton("checkout");
        verif.setBounds(350, 350, 100, 30);
        verif.setBackground(Color.GRAY);
        staff.add(verif);


        back = new JButton("back");
        back.setBounds(50, 400, 100, 30);
        back.setBackground(Color.GRAY);
        staff.add(back);

        staff.setLocationRelativeTo(null);
        staff.setVisible(true);
        staff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                staff.dispose();
                GUI men = new GUI();
            }
        });
        verif.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String kode = kodetext.getText();
                String ktp = ktptext.getText();
                int index = AllObjectModel.modelreservasi.cekData(kode,ktp);
                AllObjectController.admin.updateIsVerified(index, AllObjectController.tamuc.showdaftarreservasi(index).getIndexRoom(),AllObjectController.tamuc.showdaftarreservasi(index).getTamu());
                tabeltamu.setModel(tamuc.daftartamu());
            }
        });

        verif.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String kode = kodetext.getText();
                String ktp = ktptext.getText();
                int index = AllObjectModel.modelreservasi.cekData(kode, ktp);
                if (index > -1) {
                    AllObjectController.tamuc.showdaftarreservasi(index);
                    JOptionPane.showMessageDialog(
                            null, "Berhasil Checkout", "information", JOptionPane.INFORMATION_MESSAGE);
                    kosong();
                } else {
                    JOptionPane.showMessageDialog(
                            null, "Data Tidak Ditemukan", "information", JOptionPane.INFORMATION_MESSAGE);
                    kosong();
                }
            }

        });


        tabeltamu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               int i = tabeltamu.getSelectedRow();
               kodetext.setText(AllObjectController.tamuc.daftartamu().getValueAt(i,0).toString());
               ktptext.setText(AllObjectController.tamuc.daftartamu().getValueAt(i,1).toString());

            }
        });
    }
    void kosong(){
        verif.setText(null);
    }
}