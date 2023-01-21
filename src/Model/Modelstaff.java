package Model;
import Entity.staffentity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Modelstaff implements Modelinterface{
    private ArrayList<staffentity> staffentityArrayList = new ArrayList<staffentity>();

    public Modelstaff(){
        staffentityArrayList = new ArrayList<staffentity>();
    }

    public void insertStaff(staffentity staff) {
        staffentityArrayList.add(staff);
    }

    @Override
    public void view() {
        for (staffentity Staff : staffentityArrayList){
            System.out.println(Staff.getKodepemesanan());
            System.out.println(Staff.getNama());
            System.out.println(Staff.getKtp());
            System.out.println(Staff.getCheckin());
            System.out.println(Staff.getNotlp());
            System.out.println(new SimpleDateFormat("dd-MM-yyyy").format(Staff.getCheckin()));
            System.out.println();
        }
    }

    @Override
    public int cekData(String kode, String ktp) {
        int loop = 0;
        for (staffentity Staffc: staffentityArrayList) {
            if (Staffc.getKodepemesanan().equals(kode) && Staffc.getKtp().equals(ktp)){
                break;
            } else {
                loop++;
            }
        }
        return loop;
    }
    public staffentity showDataStaff(int index){
        return staffentityArrayList.get(index);
    }
}
