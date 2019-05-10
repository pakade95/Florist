package Boxes;

import Customer.Customer;

public class Box extends ShoppingCart {

    public Box(Customer customer) {
        super(customer.getName());
    }

    @Override
    public String toString() {
        if (this.flowerList.isEmpty()) {
            return "Pudełko właściciela " + this.name + " jest puste!\n";
        } else {
            return "Pudełko właściciela " + this.name + this.flowerList.toString()
                    .replace('[', ' ')
                    .replace(']', ' ')+ "";
        }
    }
}
