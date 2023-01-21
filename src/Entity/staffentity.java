package Entity;

import java.util.Date;

public class staffentity extends tamuabstractentity {
    private String hotel;

    public staffentity(String kodepemesanan, String nama, String notlp, String ktp, Date checkin) {
        super(kodepemesanan, nama, notlp, ktp, checkin);
        this.hotel = hotel;
    }

    @Override
    public String getKodepemesanan() {
        return kodepemesanan;
    }


}
