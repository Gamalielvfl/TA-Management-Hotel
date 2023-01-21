package Entity;

import java.util.ArrayList;
import java.util.Date;

public class tamuentity extends tamuabstractentity {
    public Date checkout;
    public tamuentity(String kodepemesanan, String nama, String notlp, String ktp, Date checkin,Date checkout){
        super(kodepemesanan, nama, notlp, ktp, checkin);
        this.checkout = checkout;
    }



    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    @Override
    public String getKodepemesanan() {
        return kodepemesanan;
    }
}

