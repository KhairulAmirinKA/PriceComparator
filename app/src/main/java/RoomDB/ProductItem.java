package RoomDB;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ProductItem {

    @PrimaryKey(autoGenerate = true)
    public int id;
    private String productName;
    private double productPrice;
    private double productQuantity;

    private double pricePerQuantity;

    public ProductItem(String productName, double productPrice, double productQuantity) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public double getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(double productQuantity) {
        this.productQuantity = productQuantity;
    }

    public double getPricePerQuantity() {
        return pricePerQuantity;
    }

    public void setPricePerQuantity(double pricePerQuantity) {
        this.pricePerQuantity = pricePerQuantity;
    }
}
