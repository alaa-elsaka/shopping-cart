package model;

public class Item {

    private String title;

    public boolean isOnSale() {
        return isOnSale;
    }

    private boolean isOnSale;

    public void setOnSale(boolean onSale) {
        isOnSale = onSale;
    }

    public double getPrice() {
        return price;
    }

    private double price;
    public Item(String title, double price) {
          this.price = price;
          this.title = title;
    }
}
