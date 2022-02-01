package com.mido.decorator;

import com.mido.IConverter;
import com.mido.exception.NotResponsibleExept;

public abstract class Decorator implements IConverter {

    private final IConverter nextCurCalDecorator;

    public Decorator(IConverter nextCurCalDecorator) {
        this.nextCurCalDecorator = nextCurCalDecorator;
    }

    public double conver(String variation, double amount) throws NotResponsibleExept {
        if (this.nextCurCalDecorator != null) {
            return nextCurCalDecorator.conver(variation, amount);
        } else {
            System.out.println("No Responsibility found");
            return 0.0;
        }

    }


}

