package Entity;
import java.util.Date;

public abstract class tamuabstractentity {
    public String kodepemesanan,nama,notlp,ktp;
    public Date checkin;

    public tamuabstractentity(String kodepemesanan, String nama, String notlp, String ktp, Date checkin) {
        this.kodepemesanan = kodepemesanan;
        this.nama = nama;
        this.notlp = notlp;
        this.ktp = ktp;
        this.checkin = checkin;
    }

    public tamuabstractentity() {

    }

    public abstract String getKodepemesanan();
    public void setKodepemesanan(String kodepemesanan) {
        this.kodepemesanan = kodepemesanan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNotlp() {
        return notlp;
    }

    public void setNotlp(String notlp) {
        this.notlp = notlp;
    }

    public String getKtp() {
        return ktp;
    }

    public void setKtp(String ktp) {
        this.ktp = ktp;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }
}
