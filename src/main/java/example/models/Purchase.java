package example.models;

import java.math.BigDecimal;
import java.util.Objects;

public class Purchase {
    private int id;
    private String product;
    private BigDecimal price;

    public int getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getProduct() {
        return product;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
