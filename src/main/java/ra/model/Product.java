package ra.model;

public class Product {
    private int code;
    private String productName;
    private String imageUrl;
    private double productPrice;
    private int stock;

    public Product(String productName, String imageUrl, double productPrice, int stock) {
        this.productName = productName;
        this.imageUrl = imageUrl;
        this.productPrice = productPrice;
        this.stock = stock;
    }

    public Product() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
