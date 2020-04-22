package nl.inholland.myfirstapi.Model;

import javax.persistence.*;

@Entity
public class Stock {

    @Id
    @SequenceGenerator(name = "stock_seq", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stock_seq")
    private long id;
    private int quantity;

    @OneToOne(cascade = CascadeType.REMOVE)
    private Skate skate;

    public Stock(){
    }

    public Stock(Skate skate, int quantity){
        this.skate = skate;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Skate getSkate() {
        return skate;
    }

    public void setSkate(Skate skate) {
        this.skate = skate;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", skate=" + skate +
                '}';
    }
}
