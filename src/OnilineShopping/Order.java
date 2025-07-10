package OnilineShopping;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;
import java.util.UUID;

public class Order {

    private String orderId  ;
    private Set <String> productIds  = new HashSet<>();
    private Map<String, Integer> cartItems = new HashMap<>();
    private Map<String, Product> inventory;

    private long price;
    private int sizeOfCart;

    public Order(ShoppingCart cart, Inventory inventory) {
        this.productIds = cart.getCart().keySet();
        this.cartItems = cart.getCart();
        this.orderId = UUID.randomUUID().toString();
        this.inventory = inventory.products;
    }

    public void placeOrder() {

        System.out.println("Placing an Order for the below items " + inventory);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        long totalOrderAmount = 0;

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (String productId : productIds) {
            Product p = inventory.get(productId);
            long productPrice = p.getPrice();
            int quantity = cartItems.get(productId);
            totalOrderAmount += (productPrice * quantity);
            System.out.println("ProductName = " + p.getProductName() + " Quantity = " + quantity + " Price = " + productPrice * quantity);
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        }

        for (String productId : productIds){
            Product p = inventory.get(productId);
            int quantity = cartItems.get(productId);
            p.setStock(p.getStock() - quantity );
        }
        cartItems.clear();

        System.out.println("Successfully placed order with Id " + orderId + " with total amount of " + totalOrderAmount);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");


    }
}
