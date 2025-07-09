package OnilineShopping;
import java.util.HashMap;
import java.util.Set;
import java.util.Scanner;

public class Inventory {

    Scanner s = new Scanner (System.in);
    HashMap<String,Product> products = new HashMap<>();

    public void addProduct(Product product){
        products.put(product.getProductId(), product);
    }

    public boolean removeProduct(String productId) {
        if (products.containsKey(productId)) {
            Product product = products.get(productId);
            System.out.println("REMOVED PRODUCT = " + product.getProductName());
            products.remove(productId);
            return true;
        }
        return false;
    }

    public void productInfo() {
        Set<String> productKeys = products.keySet();
        for (String productKey : productKeys ){
            System.out.println("PRODUCTS IN INVENTORY = " + products.get(productKey));
        }
    }

    public void searchProduct() {
        System.out.print("ENTER PRODUCT NAME TO SEARCH = ");
        String searchedProduct = s.nextLine();
        Set<String> productKeys = products.keySet();

        for (String productKey : productKeys) {
            String productName = products.get(productKey).getProductName();

            if (productName.startsWith(searchedProduct)) {
                System.out.println("PRODUCT BY YOUR SEARCH = " + productName);
            }
        }
    }
}
