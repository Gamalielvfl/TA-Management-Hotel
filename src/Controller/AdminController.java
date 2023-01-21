package Controller;

import Entity.*;
import java.util.ArrayList;
import java.util.Date;

public class AdminController implements Controllerinterface{
    int index_login = 0;
    int index;
    public AdminController() {

    }

    public void datastaff(){
        String kodestaff [] = {"01","02","03","04","05","06","07"};
        String ktpstaff [] = {"01","02","03","04","05","06","07"};
        String namastaff [] = {"Mici","Aldo","jema","nessie","laura","Mike","Fernando"};
        String notelpstaff [] = {"01","02","03","04","05","06","07"};
        String tglLahirstaff [] = {"12/05/2000","01/04/2000","02/06/2000","03/06/2000","17/03/2000","21/09/2000","08/09/2000"};
        for (int i = 0; i<kodestaff.length; i++){
            AllObjectModel.modelstaff.insertStaff(new staffentity(kodestaff[i],ktpstaff[i],namastaff[i],notelpstaff[i],
                    new Date(tglLahirstaff[i])));
        }
    }

    public void viewstaff() {
        AllObjectModel.modelstaff.view();
    }
    public void listdaftartamu() {
        AllObjectModel.modelreservasi.view();
    }

    @Override
    public void login(String kode, String ktp) {
        index_login = AllObjectModel.modelstaff.cekData(kode, ktp);
    }

    public staffentity staffentity() {
        return AllObjectModel.modelstaff.showDataStaff(index_login);
    }

    public void updateIsVerified(int index,int indexroom ,tamuentity tamu) {
        AllObjectModel.modelreservasi.updateIsVerified(index, new Reservasientity(tamu,true,indexroom));
    }

    public ArrayList<Reservasientity> cekDaftarreservasiModel(){
        return AllObjectModel.modelreservasi.getReservasiArraylist();
    }

}
