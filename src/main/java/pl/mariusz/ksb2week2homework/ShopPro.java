package pl.mariusz.ksb2week2homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@Profile("pro")
public class ShopPro implements Shop {

    private double vat;
    private double discount;
    private Cart cart;

    @Autowired
    public ShopPro(Cart cart) {
        this.cart = cart;
    }

    public Double getVat() {
        return vat;
    }

    public void setVat(Double vat) {
        this.vat = vat;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @Override
    @EventListener(ApplicationReadyEvent.class)
    public void goShopping(){
        double result = 0;

        for (Product product : cart.getProductList()) {
            System.out.println(product);

            result+=product.getPrice() * vat * discount;
        }
        System.out.printf("Total price with vat and discount: " + "%.2f %n" , result);
//        System.out.println("discount: " + discount);
//        System.out.println("vat: " + vat);

    }
}
