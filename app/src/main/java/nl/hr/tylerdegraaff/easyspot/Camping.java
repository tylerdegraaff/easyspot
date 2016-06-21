package nl.hr.tylerdegraaff.easyspot;

public class Camping {
    private int id;
    private String name;
    private String address;
    private int image;
    public Camping()
    {
    }
    public Camping(int id,String name,String address, int image)
    {
        this.id=id;
        this.name=name;
        this.address=address;
        this.image=image;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setImage(int image) {
        this.image = image;
    }
    public int getId() {
        return id;
    }
    public String getAddress() {
        return address;
    }
    public String getName() {
        return name;
    }
    public int getImage() {
        return image;
    }
}

