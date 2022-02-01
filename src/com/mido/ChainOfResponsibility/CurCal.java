package com.mido.ChainOfResponsibility;

import com.mido.IConverter;
import com.mido.exception.NotResponsibleExept;

public abstract class CurCal implements IConverter{

    private final IConverter nextCurCal;

    public CurCal(IConverter nextCurCal) {
        this.nextCurCal = nextCurCal;
    }

    public double conver(String variation, double amount) throws NotResponsibleExept {
        if (this.nextCurCal != null) {
            return nextCurCal.conver(variation, amount);
        } else {
            throw new NotResponsibleExept("No responsibility found");

        }

    }

    //Template Hook Pattern
    public double conver(double amount) {
        return Math.round((amount * getFactor()) * 100.0) / 100.0;
    }

    public abstract double getFactor();


}
