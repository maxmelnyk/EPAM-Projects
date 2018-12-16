package ProductsForSport;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Service {
    private ArrayList<Product> productList = new ArrayList<>();
    private ArrayList<Sport> sportList = new ArrayList<>();

    public Service() {
        createProductList();
        createSportList();
    }

    public ArrayList<Product> getProductList() {

        return productList;
    }

    public ArrayList<Sport> getSportList() {

        return sportList;
    }

    public ArrayList<Product> sortProductList(ArrayList<Product> productList) {

        return (ArrayList<Product>) productList.stream().sorted(Comparator.comparingDouble(Product::getweight)).collect(Collectors.toList());
    }

    private void createProductList() {
        File prodFile = new File("products.txt");

        try (FileReader fileR = new FileReader(prodFile)) {
            BufferedReader bufR = new BufferedReader(fileR);

            while (bufR.ready()) {

                String[] product = bufR.readLine().split(", ");
                Product newProduct = new Product(product[0], Integer.valueOf(product[1]), Double.valueOf(product[2]));
                productList.add(newProduct);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createSportList() {
        String[] sportKinds = new String[]{"Daiving", "Parashuting", "Biatlon"};

        for (int i = 0; i < sportKinds.length; i++) {
            Sport sport = new Sport(i + 1);
            sport.setKind(sportKinds[i]);
            sport.setProducts((ArrayList<Product>) productList.stream().filter((x -> x.getSportId() == sport.getSportId())).collect(Collectors.toList()));
            sport.setProducts(sortProductList(sport.getProducts()));

            sportList.add(sport);
        }
    }

    public void printAllProducts() {
        for (Product product :
                productList) {
            System.out.println("Product name: " + product.getName() + ", sport id: " + product.getSportId() + ", weight: " + product.getweight());
        }
    }

    public void printAllSportKinds() {
        for (Sport sport : sportList) {

            System.out.print("Kind of sport: ");
            System.out.println(sport.getKind());

            System.out.println("Products of this kind of sport:");
            sport.getProducts().forEach(System.out::println);

            System.out.println();
        }
    }

    public void addProduct() {
        Scanner scanLine = new Scanner(System.in);
        Product product = new Product();
        System.out.println("Print product name:");
        product.setName(scanLine.nextLine());
        System.out.println("Print kind of sport:");
        String sportKind = scanLine.nextLine();
        System.out.println("Print product weight:");
        product.setweight(Double.valueOf(scanLine.nextLine()));

        for (Sport sport : sportList) {
            if (sport.getKind().equals(sportKind)) {

                product.setSportId(sport.getSportId());
                sport.getProducts().add(product);
                sport.setProducts(sortProductList(sport.getProducts()));
            }
        }

        if (product.getSportId() == 0) {
            product.setSportId(sportList.size() + 1);
            ArrayList<Product> products = new ArrayList<>();
            products.add(product);

            Sport sport = new Sport(sportList.size() + 1);
            sport.setKind(sportKind);
            sport.setProducts(products);

            sportList.add(sport);
        }

        productList.add(product);
        writeInFile(product);
    }

    private void writeInFile(Product product) {
        File file = new File("products.txt");

        try (FileWriter fileWr = new FileWriter(file, true);
             BufferedWriter bufWr = new BufferedWriter(fileWr)) {

            String newLine = String.format("%s, %d, %s", product.getName(), product.getSportId(), product.getweight());
            bufWr.newLine();
            bufWr.write(newLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}