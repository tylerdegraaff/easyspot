package nl.hr.tylerdegraaff.easyspot;

public class Reservation {
    private int id;
    private int camping_id;
    private String start_date, end_date;

    public Reservation()
    {
    }
    public Reservation(int id, int camping_id, String start_date, String end_date)
    {
        this.id=id;
        this.camping_id=camping_id;
        this.start_date=start_date;
        this.end_date=end_date;
    }
    public void setId(int id) {
        this.id=id;
    }
    public void setCampingId(int camping_id) {this.camping_id=camping_id;}
    public void setStart_date(String start_date){this.start_date=start_date;}
    public void setEnd_date(String end_date){this.end_date=end_date;}

    public int getId() {
        return id;
    }
    public int getCampingId() { return camping_id; }
    public String getStart_date() {return start_date;}
    public String getEnd_date() {return end_date;}
}
