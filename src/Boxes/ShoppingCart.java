package Boxes;

import Model.Flower;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    protected String name;
    protected List<Flower> flowerList;

    public ShoppingCart(String name) {
        this.name = name;
        this.flowerList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Flower> getFlowerList() {
        return flowerList;
    }

    public void setFlowerList(List<Flower> flowerList) {
        this.flowerList = flowerList;
    }

    public void addFlower(Flower flower) {
        flowerList.add(flower);
    }

    public void removeFlower(Flower flower) {
        flowerList.remove(flower);
    }

    @Override
    public String toString() {
        if (this.flowerList.isEmpty()) {
            return "Wózek właściciela " + this.name + " jest pusty!";
        } else {
            return "Wózek właściciela " + this.name + getFlowerList()
                    .toString().replace('[', ' ')
                    .replace(']', ' ') + "";
        }
    }
}
