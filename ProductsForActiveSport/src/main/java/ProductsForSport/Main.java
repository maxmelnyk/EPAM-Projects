package ProductsForSport;

public class Main {

    public static void main(String[] args) {
        Service service = new Service();

        service.printAllProducts();
        service.printAllSportKinds();
        service.addProduct();
        service.printAllSportKinds();
    }
}