package example.models;

public class Payment {
    private String id;
    private double amount;

    public double getAmount() {
        return amount;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
