package OnilineShopping;
import java.util.UUID;

public class Product {

    private String productId;
    private String productName;
    private String description;
    private long price;
    private int stock;

    //constructor;

    public Product(){};

    public Product(String productName, String description, long price, int stock){
        this.productName = productName;
        this.description = description;
        this.price =  price;
        this.stock = stock;
        this.productId = String.valueOf(UUID.randomUUID());
    }

    // getters

    public String getProductId(){
      //  System.out.println("Calling GetProductId");
        return this.productId;
    }

    public String getProductName(){
        return this.productName;
    }

    public String getDescription(){
        return this.description;
    }

    public long getPrice(){
        return this.price;
    }

    public int getStock(){
        return this.stock;
    }

    //setters;

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setPrice(long price) {
        this.price =  price;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "[ PRODUCT NAME = " + this.getProductName() + " PRODUCT ID = " + this.getProductId() + " DESCRIPTION = " + this.description + " PRICE = " + this.price + " STOCK = " + this.stock + "]";
    }
}
