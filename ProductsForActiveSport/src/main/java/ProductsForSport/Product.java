package ProductsForSport;

public class Product /*implements Comparable*/{
    private double weight;
    private String name;
    private int sportId;

    public Product(){}

    public Product(String name, int sportId, double weight){
        this.name = name;
        this.weight = weight;
        this.sportId = sportId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getweight() {
        return weight;
    }

    public void setweight(double weight) {
        this.weight = weight;
    }

    public int getSportId() {
        return sportId;
    }

    public void setSportId(int sportId) {
        this.sportId = sportId;
    }

    @Override
    public String toString() {
        return name + "(weight: " + weight + "kg)";
    }
}
