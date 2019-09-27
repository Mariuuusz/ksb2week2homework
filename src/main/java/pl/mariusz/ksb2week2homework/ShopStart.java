package pl.mariusz.ksb2week2homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@Profile("start")
public class ShopStart implements Shop {

    private Cart cart;

    @Autowired
    public ShopStart(Cart cart) {
        this.cart = cart;
    }

    @Override
    @EventListener(ApplicationReadyEvent.class)
    public void goShopping() {
        double result = 0;
        for (Product product : cart.getProductList()) {
            System.out.println(product);

            result+=product.getPrice();
        }
        System.out.printf("Total price: " + "%.2f" , result);
    }
}
