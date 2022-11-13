package ru.croc.task8;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;


public class Price {
    BigDecimal num;
    public Price(int num){
        this.num = new BigDecimal(num);
    }

    public String formatPrice(){
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        return format.format(this.num);
    }
}
