package Model;

import DesignPattern.PriceList;

public abstract class Flower {

    protected String name;
    protected String color;
    protected int quantity;

    public Flower(int quantity)throws IllegalArgumentException {
        if(quantity<=0)
            throw new IllegalArgumentException("Podano nieprawidłową liczbę kwiatów!");
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "\n"+this.name + ", kolor: " + this.color
                + ", ilosc " + this.quantity+", cena "+ PriceList.getPrice(this);
    }
}