package com.mido.decorator;


import com.mido.IConverter;
import com.mido.exception.NotResponsibleExept;

public class FeeDecorator extends Decorator {

    public FeeDecorator(IConverter nextDecorator) {
        super(nextDecorator);
    }

    @Override
    public double conver(String variation, double amount) throws NotResponsibleExept {


        if (variation.toLowerCase().startsWith("eur")) {
            System.out.println("Fees for " + variation + " of 5€.");
            return super.conver(variation, amount) != 0.0 ? super.conver(variation, amount) + 5.0 : 0.0;
        } else {
            System.out.println("Fees (0,5%) for " + variation + " of " + Math.round((amount * 0.05) * 100.0) / 100.0 + "€.");
            return super.conver(variation, (amount * 1.05));
        }

    }

}
