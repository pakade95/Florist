import Boxes.Box;
import Boxes.ShoppingCart;
import Customer.Customer;
import DesignPattern.PriceList;
import Model.*;

public class FloristsTest {

    static int valueOf(Box box, String color) throws IllegalArgumentException {
        double sum = 0;
        //dodano w niedziele
        if (box.getFlowerList().size() == 0) {
            throw new IllegalArgumentException("Podane pudełko jest puste!");
        }
        //
        else {
            double element = 0;
            for (Flower flower : box.getFlowerList()) {
                if (flower.getColor().equalsIgnoreCase(color))
                    element = flower.getQuantity() * PriceList.getPrice(flower);
                sum = sum + element;
                element = 0;
            }
            //dodane w niedziele
            if (sum == 0) {
                System.out.println("W pudełku właściciela " + box.getName() + " nie ma żadnych kwiatków w kolorze: " + color);
            }
            //
        }
        return (int) sum;
    }

    public static void main(String[] args) {

        PriceList pl = PriceList.getInstance();

        pl.put("róża", 8.0, 7.0, 5);
        pl.put("bez", 12.0);
        pl.put("piwonia", 8.0);

        Customer janek = new Customer("Janek", 200);

        janek.get(new Rose(5));
        janek.get(new Peony(5));
        janek.get(new Freesia(3));
        janek.get(new Lilac(3));

        ShoppingCart wozekJanka = janek.getShoppingCart();

        System.out.println("Przed płaceniem " + wozekJanka);

        janek.pay("cash");

        System.out.println("Po zapłaceniu " + janek.getShoppingCart());

        System.out.println("Jankowi zostało : " + janek.getCash() + " zł");

        Box pudelkoJanka = new Box(janek);
        janek.pack(pudelkoJanka);

        System.out.println("Po zapakowaniu do pudełka " + janek.getShoppingCart());

        System.out.println(pudelkoJanka);

        System.out.println("Czerwone kwiaty w pudełku Janka kosztowały: "
                + valueOf(pudelkoJanka, "czerwony") + " zł");

        Customer stefan = new Customer("Stefan", 60);

        stefan.get(new Rose(6));
        stefan.get(new Lilac(3));

        System.out.println(stefan.getShoppingCart());

        stefan.pay("card");
        Box pudelkoStefana = new Box(stefan);
        stefan.pack(pudelkoStefana);

        System.out.println(pudelkoStefana);

        System.out.println("Stefanowi zostało : " + stefan.getCash() + " zł");
    }
}