package OnilineShopping;
import java.util.HashMap;
import java.util.Set;

public class ShoppingCart {

    HashMap<String, Integer>  cart;
    Inventory inventory;

    public ShoppingCart(Inventory inventory) {
        cart = new HashMap<>();
        this.inventory = inventory;
    }


    public void addProduct (String productId){
        if (cart.containsKey(productId)) {
            int countOfProducts = cart.get(productId);
            cart.put(productId, countOfProducts + 1);
        }
        else {
            cart.put(productId, 1);
        }
    }

    public void removeProduct (String productId){

         cart.remove(productId);
        System.out.println("REMOVED PRODUCT = " + inventory.products.get(productId));
    }

    public void  sizeOfCart(){

        System.out.println("CART SIZE = " + cart.size());

    }

    public long prizeOfProducts(){

        long prize = 0;;

        Set<String> productKeys = cart.keySet();

        for (String productKey : productKeys) {
            Product p = inventory.products.get(productKey);
            prize += p.getPrice();

        }

        return prize;
    }

    public void productsInCart(){

        Set<String> productKeys = cart.keySet();
        for (String productKey : productKeys ) {
            System.out.println(productKey);
            Product p = inventory.products.get(productKey);
            System.out.println("PRODUCTS IN CART = " + p.getProductName() + " QUANTITY = " + cart.get(productKey));
        }
    }

}
