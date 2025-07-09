package OnilineShopping;
import java.util.UUID;

public class Customer {

    private UUID customerUUID;
    private String customerName;
    private String customerEmail;
    private String customerAdress;

    public Customer( String customerAdress, String customerEmail,String customerName) {

        this.customerAdress = customerAdress;
        this.customerEmail = customerEmail;
        this.customerName =customerName;
    }

    public String getCustomerAdress() {
        return customerAdress;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public UUID getCustomerUUID() {
        return customerUUID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerAdress(String customerAdress) {
        this.customerAdress = customerAdress;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

}
