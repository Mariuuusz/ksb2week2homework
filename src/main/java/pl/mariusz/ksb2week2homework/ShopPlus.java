package pl.mariusz.ksb2week2homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@Profile("plus")
public class ShopPlus implements Shop {

    private double vat;
    private Cart cart;

    @Autowired
    public ShopPlus(Cart cart) {
        this.cart = cart;
    }

    public Double getVat() {
        return vat;
    }

    public void setVat(Double vat) {
        this.vat = vat;
    }

    @Override
    @EventListener(ApplicationReadyEvent.class)
    public void goShopping(){
        double result = 0;

        for (Product product : cart.getProductList()) {
            System.out.println(product);

            result+=product.getPrice() * vat;
        }
        System.out.printf("Total price with vat: " + "%.2f" , result);
    }
}
