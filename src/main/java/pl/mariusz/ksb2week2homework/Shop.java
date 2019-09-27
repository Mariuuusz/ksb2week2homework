package pl.mariusz.ksb2week2homework;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@ConfigurationProperties(prefix = "param")
public interface Shop {
    double vat = 1;
    double discount = 1;
    void goShopping();
}
