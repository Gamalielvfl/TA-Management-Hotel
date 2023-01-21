package Entity;
import java.util.Date;

public class Reservasientity  {
    private tamuentity tamu;
    private boolean isVerified;
    private int IndexRoom;

    public Reservasientity(tamuentity tamu, boolean isVerified, int indexRoom) {
        this.tamu = tamu;
        this.isVerified = isVerified;
        IndexRoom = indexRoom;
    }

    public tamuentity getTamu() {
        return tamu;
    }

    public void setTamu(tamuentity tamu) {
        this.tamu = tamu;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public int getIndexRoom() {
        return IndexRoom;
    }

    public void setIndexRoom(int indexRoom) {
        IndexRoom = indexRoom;
    }
}
