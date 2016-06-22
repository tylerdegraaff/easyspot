package nl.hr.tylerdegraaff.easyspot;

public class Reservation {
    private int id;
    private int camping_id;

    public Reservation()
    {
    }
    public Reservation(int id, int camping_id)
    {
        this.id=id;
        this.camping_id=camping_id;
    }
    public void setId(int id) {
        this.id=id;
    }
    public void setCampingId(int camping_id) {this.camping_id=camping_id;}

    public int getId() {
        return id;
    }
    public int getCampingId() { return camping_id; }
}