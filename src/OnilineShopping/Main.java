package OnilineShopping;

public class Main {

    public static void main(String[] args) {

        Product p1 = new Product ("SAMSUNG","SAMSUNG S25 UKTRA", 1000, 200);
        Product p2 = new Product("IPHONE","14PRO",1324,256);

        Inventory inventory = new Inventory();

        inventory.addProduct(p1);
        inventory.addProduct(p2);
        inventory.productInfo();

     //   Customer c1 = new Customer("SRINIVASNAGAR","palleshiva2007@gmail.com", "SHIVA");

      //  ShoppingCart cart = new ShoppingCart();

        //cart.addProduct(p1);
        //cart.addProduct(p2);


    }
}
