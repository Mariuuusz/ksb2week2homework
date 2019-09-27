package pl.mariusz.ksb2week2homework;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class Cart {

    private List<Product> productList;

    public Cart() {
        productList = new ArrayList<>();
        productList.add(new Product("Clock",new Random().nextInt(250) + 50));
        productList.add(new Product("Table",new Random().nextInt(250) + 50));
        productList.add(new Product("Chair",new Random().nextInt(250) + 50));
        productList.add(new Product("Desk",new Random().nextInt(250) + 50));
        productList.add(new Product("Curtain",new Random().nextInt(250) + 50));
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void addProductToList(Product product) {
        productList.add(product);
    }
}