package Controller;

import Entity.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.text.SimpleDateFormat;
import java.util.Date;

public class tamucontroller<index_login> implements Controllerinterface{
    int indexlogin = 0;
    public tamucontroller(){

    }
    public tamuentity getData(){
        return AllObjectModel.modeltamu.getTamuentityArrayList(indexlogin);
    }
   public void daftarreservasi(int indextamu , tamuentity tamu , boolean isVerified){
        AllObjectModel.modelreservasi.insertDataDaftarReservasi(new Reservasientity(tamu,isVerified,indextamu));
   }

    @Override
    public void login(String kode, String ktp) {
        indexlogin = AllObjectModel.modeltamu.cekData(kode, ktp);
    }

    public void insert(String kodepemesanan, String nama, String ktp,String notlp, Date checkin, Date checkout){
        AllObjectModel.modeltamu.insert(new tamuentity(kodepemesanan,nama,ktp,notlp,checkin,checkout));
    }

    public tamuentity tamuentity(){
        return AllObjectModel.modeltamu.getTamuentityArrayList(indexlogin);
    }

    public int cekDaftarTamu(String kode) {
        int cek = AllObjectModel.modelreservasi.cekData(kode,null);
        return cek;
    }
    public Reservasientity showdaftarreservasi(int Index){
        return AllObjectModel.modelreservasi.showDaftarReservasi(Index);
    }
    public DefaultTableModel daftartamu() {
        DefaultTableModel datadaftartamu = new DefaultTableModel();
        Object[] kolom = {"Kode Pemesanan", "Nama", "No KTP", "No Tlp", "Checkin", "Checkout","Tipe Kamar", "Status"};
        datadaftartamu.setColumnIdentifiers(kolom);
        int size = AllObjectModel.modelreservasi.alldatatamu().size();
        String verif = null;
        for (int i = 0; i < size; i++) {
            if (AllObjectModel.modelreservasi.alldatatamu().get(i).isVerified() == false) {
                verif = "Checkin";
            } else {
                verif = "Checkout";
            }
            Object[]  data = new Object[12];
            data[0] = AllObjectModel.modelreservasi.alldatatamu().get(i).getTamu().getKodepemesanan();
            data[1] = AllObjectModel.modelreservasi.alldatatamu().get(i).getTamu().getNama();
            data[2] = AllObjectModel.modelreservasi.alldatatamu().get(i).getTamu().getKtp();
            data[3] = AllObjectModel.modelreservasi.alldatatamu().get(i).getTamu().getNotlp();
            data[4] = new SimpleDateFormat("dd-MM-yyyy").format(AllObjectModel.modelreservasi.alldatatamu().get(i).getTamu().getCheckin());
            data[5] = new SimpleDateFormat("dd-MM-yyyy").format(AllObjectModel.modelreservasi.alldatatamu().get(i).getTamu().getCheckout());
            data[6] = ruanganentity.nama[AllObjectModel.modelreservasi.alldatatamu().get(i).getIndexRoom()];
            data[7] = verif;
            datadaftartamu.addRow(data);
        }
        return datadaftartamu;
    }

}
