package ProductsForSport;

import java.util.ArrayList;

public class Sport {
    private String kind;
    private int sportId;
    private ArrayList<Product> products = new ArrayList<Product>();

    public Sport(int sportId) {
        this.sportId = sportId;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getSportId() {
        return sportId;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
