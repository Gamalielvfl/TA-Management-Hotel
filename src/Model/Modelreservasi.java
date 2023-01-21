package Model;

import Entity.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
public class Modelreservasi implements Modelinterface{
    private ArrayList<Reservasientity> ReservasiArraylist;
    public Modelreservasi(){
        ReservasiArraylist = new ArrayList<Reservasientity>();
    }
    public void insertDataDaftarReservasi(Reservasientity daftarreservasi) {
        ReservasiArraylist.add(daftarreservasi);
    }
    public ArrayList<Reservasientity> getReservasiArraylist() {
        return ReservasiArraylist;
    }
    public ArrayList<Reservasientity> alldatatamu(){
        return ReservasiArraylist;
    }


    @Override
    public void view() {
        for (Reservasientity daftarreservasi : ReservasiArraylist){
            System.out.println("========================================");
            System.out.println(" Kode Pemesanan: "+daftarreservasi.getTamu().getKodepemesanan()+"\n Nama : "+daftarreservasi.getTamu().getNama()+"\n KTP : "+daftarreservasi
                    .getTamu().getKtp()+"\n No Telp : "+daftarreservasi.getTamu().getNotlp()+"\n Checkin : "+new SimpleDateFormat
                    ("dd-MM-yyyy").format(daftarreservasi.getTamu().getCheckin())+"\n Jenis Kamar : "+ruanganentity.nama[daftarreservasi.getIndexRoom()]+"\n isVerified : ");
            if (daftarreservasi.isVerified() == false) {
                System.out.println("Belum Di Verifikasi Admin");
            } else {
                System.out.println("Telah Di Verifikasi");
            }
            System.out.println("========================================");
        }
    }

    @Override
    public int cekData(String kode, String ktp) {
        int loop = 0;
        if (ReservasiArraylist.size() == 0) {
            loop = -1;
        } else {
            for (int i = 0; i < ReservasiArraylist.size(); i++) {
                if (ReservasiArraylist.get(i).getTamu().getKodepemesanan().equals(kode)) {
                    loop = i;
                    break;
                } else {
                    loop = -2;
                }
            }
        }
        return loop;
    }

    public Reservasientity showDaftarReservasi(int index) {
        return ReservasiArraylist.get(index);
    }
    public void updateIsVerified(int index, Reservasientity daftarreservasi) {
        ReservasiArraylist.set(index, daftarreservasi);
    }
}
