package DesignPattern;

import Model.Flower;

import java.util.HashMap;
import java.util.Map;

public class PriceList {

    private static PriceList instance = null;
    private static Map<String, FlowerPrice> cennik = null;

    private PriceList() {
        this.cennik = new HashMap<>();
    }

    public static PriceList getInstance() {
        if (instance == null) {
            instance = new PriceList();
        }
        return instance;
    }

    public void put(String name, double hurtPrice) {
        FlowerPrice flowerPrice = new FlowerPrice(name.toLowerCase(), hurtPrice);
        cennik.put(flowerPrice.getName(), flowerPrice);
    }

    public void put(String name, double detalPrice, double hurtPrice, int quantity) {
        FlowerPrice flowerPrice = new FlowerPrice(name.toLowerCase(), hurtPrice, detalPrice, quantity);
        cennik.put(flowerPrice.getName(), flowerPrice);
    }

    public Map<String, FlowerPrice> getCennik() {
        return cennik;
    }

    public static double getPrice(Flower flower) {
        if (cennik.containsKey(flower.getName())) {
            FlowerPrice flowerPrice = cennik.get(flower.getName());
            if (flower.getQuantity() > flowerPrice.getQuantity()) {
                return flowerPrice.getHurtPrice();
            } else
                return flowerPrice.getDetalPrice();
        } else
            return -1;
    }
}
