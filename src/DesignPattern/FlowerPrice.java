package DesignPattern;

public class FlowerPrice {

    private String name;
    private double hurtPrice;
    private double detalPrice;
    private int quantity;

    public FlowerPrice() {
        this.name = "Nie podano nazwy!";
        this.detalPrice = -1;
        this.hurtPrice = -1;
        this.quantity = 0;
    }

    public FlowerPrice(String name, double hurtPrice) throws IllegalArgumentException {
        //niedziela
        if (hurtPrice <= 0 || name.length() < 1)
            throw new IllegalArgumentException("Podano błędne argumenty! Sprawdz nazwe i cene!");
        this.name = name;
        this.hurtPrice = hurtPrice;
        this.detalPrice = hurtPrice;
        this.quantity = 1;
    }

    public FlowerPrice(String name, double hurtPrice, double detalPrice, int quantity) throws IllegalArgumentException {
        this(name, hurtPrice);
        if (detalPrice < hurtPrice || detalPrice <= 0 || quantity < 1)
            throw new IllegalArgumentException("Podano błędne argumenty! " +
                    "Sprawdz cene detaliczna i ilosc kwiatków!");
        this.detalPrice = detalPrice;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getHurtPrice() {
        return hurtPrice;
    }

    public double getDetalPrice() {
        return detalPrice;
    }

}
