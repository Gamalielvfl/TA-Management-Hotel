package Model;
import Entity.tamuentity;
import java.util.ArrayList;
import java.util.Scanner;

public class Modeltamu implements Modelinterface {
    Scanner input = new Scanner(System.in);
    private ArrayList<tamuentity> tamuentityArrayList;

    public Modeltamu() {
        tamuentityArrayList = new ArrayList<tamuentity>();
    }

    public void insert(tamuentity tamu) {
       tamuentityArrayList.add(tamu);
    }

    @Override
    public void view() {
        for (tamuentity tamu : tamuentityArrayList){
            System.out.println("========================================");
            System.out.println("Kode Pemesanan : "+tamu.getKodepemesanan()+"\n Nama : "+tamu.getNama()+"\n KTP : "+tamu.getKtp()+"\n No Telp : "
            +tamu.getNotlp()+"" +
                    "n Checkin : "+tamu.getCheckin());
            System.out.println("========================================");
        }
    }

    @Override
    public int cekData(String kode, String ktp) {
        int loop = 0;
        while (!tamuentityArrayList.get(loop).getKodepemesanan().equals(kode)
                && !tamuentityArrayList.get(loop).getKtp().equals(ktp)) {
            loop++;
        }
        return loop;
    }

    public tamuentity getTamuentityArrayList(int index) {
        return tamuentityArrayList.get(index);
    }
}
