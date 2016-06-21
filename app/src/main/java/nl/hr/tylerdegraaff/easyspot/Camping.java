package nl.hr.tylerdegraaff.easyspot;

public class Camping {
    private int id;
    private String name;
    private String address;
    private int image;
    private int phone;
    private int price;
    private String email;
    private String desc;
    private String fac;
    public Camping()
    {
    }
    public Camping(int id,String name,String address, int image, int phone, int price,
                   String email, String desc, String fac)
    {
        this.id=id;
        this.name=name;
        this.address=address;
        this.image=image;
        this.phone=phone;
        this.price=price;
        this.email=email;
        this.desc=desc;
        this.fac=fac;
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
    public void setPhone(int phone) {
        this.phone = phone;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public void setFac(String fac) {
        this.fac = fac;
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
    public int getPhone() {
        return phone;
    }
    public int getPrice() {
        return price;
    }
    public String getEmail() {
        return email;
    }
    public String getDesc() {
        return desc;
    }
    public String getFac() {
        return fac;
    }
}

