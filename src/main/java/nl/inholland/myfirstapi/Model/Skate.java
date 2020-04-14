package nl.inholland.myfirstapi.Model;

public class Skate {

    private long id;
    private String name;
    private float price;

    public Skate(long id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Skate{" +
                "id=" + id +
                ", name=" + name +
                ", price=" + price +
                "}";
    }
}
