package dto;

public class Item {

    private Toy toy;
    private int quantity;
    public Item(Toy product, int quantity) {
        this.toy = product;
        this.quantity = quantity;
    }
    public Toy getToy() {
        return toy;
    }

    public void setToy(Toy toy) {
        this.toy = toy;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
