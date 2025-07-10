package OnilineShopping;
import java.util.Scanner;

public class Operations {
    Scanner s;
    Inventory inventory;
    ShoppingCart cart;
    Order order ;

    public Operations() {
        s = new Scanner(System.in);
        inventory = new Inventory();
        cart = new ShoppingCart(inventory);
    }


    public void shoppingOperations(){

        while (true) {

            System.out.println("1.ADMIN");
            System.out.println("2.CUSTOMER");
            System.out.println("3.DISPLAY ORDERS");
            System.out.println("4.EXIT");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------");

            int  userInput = s.nextInt();

            if (userInput == 1){
                adminOperations();

            }else if (userInput == 2){

                customerShopping();
                customerOperations();

            }else if (userInput == 4){
                break;
            }
        }

    }

    public void adminOperations() {
       while(true) {

           System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
           System.out.println("1.ADD PRODUCT   ");
           System.out.println("2.REMOVE PRODUCT");
           System.out.println("3.DISPLAY INVENTORY");
           System.out.println("4.SEARCH PRODUCT");
           System.out.println("5.EXIT");
           System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");

           int userInput = s.nextInt();
           if (userInput == 1){
               product();
           } else if(userInput == 2) {

               s.nextLine();
               String productId = s.nextLine();
               boolean result = inventory.removeProduct(productId);
               System.out.println();
               System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");

               if (result) {
                   System.out.println("Product Removed Successfully");
               }
               else {
                   System.out.println("Please Enter Valid Product Id");
               }

               System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");

           }
           else if(userInput == 3) {
               inventory.productInfo();
           }
           else if (userInput == 4){
               inventory.searchProduct();
           }
           else if (userInput == 5) {
               break;
           }
       }
    }

    public void product() {

        if (s.hasNextLine()) s.nextLine();
        System.out.print("ENTER PRODUCT NAME  ");
        String name = s.nextLine();

        System.out.print("ENTER PRODUCT DESCRIPTION = ");
        String descpriction = s.nextLine();

        System.out.print("ENTER PRICE = ");
        long price = s.nextLong();
        s.nextLine();

        System.out.print("ENTER STOCK = ");
        int Stock = s.nextInt();


        Product product = new Product(name,descpriction,price,Stock);

        System.out.println("PRODUCT CREATED SUCCESSFULLY");
        inventory.addProduct(product);

        }
    
    public void customerShopping() {

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.println("WELCOME TO OUR SHOP SIR OUR PRODUCTS ARE = ");
        inventory.productInfo();

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

    }

    public void customerOperations() {
        while (true) {
            System.out.println("1.ADD PRODUCT TO CART");
            System.out.println("2.REMOVE PRODUCT FROM CART ");
            System.out.println("3.CHECK PRODUCT IN YOUR CART ");
            System.out.println("4.TOTAL PRODUCTS IN YOUR CART ");
            System.out.println("5. PLACE AN ORDER FOR ITEMS IN YOUR CART");
            System.out.println("5.EXIT");

            int userInput = s.nextInt();

            if (userInput == 1) {
                System.out.println("ENTER PRODUCT UUID = ");
                String productId = s.next();

                if (inventory.products.containsKey(productId)) {
                    cart.addProduct(productId);
                }

                System.out.println(inventory.products.get(productId) + " IS ADDED IN YOUR CART" );
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            } else if (userInput == 2) {
                System.out.print("ENTER PRODUCT UUID TO REMOVED PRODUCT = " );
                String productId = s.next();
                cart.removeProduct(productId);
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");


            } else if (userInput == 3) {

                cart.productsInCart();
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            } else if(userInput == 4) {
                cart.sizeOfCart();
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            } else if( userInput == 5){
                // cart
                // inventory
              order = new Order(cart, inventory);
              order.placeOrder();

            }else{
                break;
            }
        }
    }

        public static void main(String[] args) {
        Operations operation = new Operations();
        operation.shoppingOperations();
    }
}
