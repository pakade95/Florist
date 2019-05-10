package Customer;

import Boxes.Box;
import Boxes.ShoppingCart;
import DesignPattern.PriceList;
import Model.Flower;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private double cash;
    private ShoppingCart shoppingCart;

    public Customer(String name, double cash) throws IllegalArgumentException {
        if (cash < 0 || name.length() < 1)
            throw new IllegalArgumentException("Podano błędne argumenty! Sprawdź imię i budżet użytkownika!");
        this.name = name;
        this.cash = cash;
        this.shoppingCart = new ShoppingCart(name);
    }

    public void get(Flower flower) {
        shoppingCart.addFlower(flower);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void pay(String form) {
        double bill = 0;
        double flowerBill = 0;
        List<Flower> toRemove = new ArrayList<>();

        if (!this.shoppingCart.getFlowerList().isEmpty()) {
            for (Flower flower : this.shoppingCart.getFlowerList()) {
                if (PriceList.getPrice(flower) == -1.0) {
                    toRemove.add(flower);
                } else {
                    flowerBill = 0;
                    flowerBill = flower.getQuantity() * PriceList.getPrice(flower);
                    bill = bill + flowerBill;

                    if (bill > this.cash || bill * 1.01 > this.cash) {
                        System.out.println("Budżet został przekroczony!\nZ koszyka użytkownika " + getName() +
                                " zostały usunięte kwiatki: " + flower.getName() + " sztuk " + flower.getQuantity());
                        toRemove.add(flower);
                        bill = bill - flowerBill;
                    }
                }
            }
        } else {
            System.out.println("Koszyk jest pusty!");
        }

        if (bill <= this.cash) {
            if (form.equalsIgnoreCase("cash"))
                this.cash = this.cash - bill;
            else if (form.equalsIgnoreCase("card"))
                this.cash = this.cash - 1.01 * bill;
            else {
                throw new IllegalArgumentException(("Podano nieprawidłową komendę! " +
                        "Do metody pay() wpisz 'cash' lub 'card' "));
            }
        }
        if (toRemove != null) {
            this.shoppingCart.getFlowerList().removeAll(toRemove);
        }
    }

    public void pack(Box box) {
        box.getFlowerList().addAll(this.getShoppingCart().getFlowerList());
        this.shoppingCart.getFlowerList().removeAll(this.shoppingCart.getFlowerList());
    }

}
