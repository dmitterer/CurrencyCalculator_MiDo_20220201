package com.mido.ChainOfResponsibility;

import com.mido.IConverter;
import com.mido.exception.NotResponsibleExept;

public class CurCalDollarToEuro extends CurCal{

    public CurCalDollarToEuro(IConverter nextCurCal) {
        super(nextCurCal);
    }

    @Override
    public double conver(String variation, double amount) throws NotResponsibleExept {
        if (variation.equals("Dollar to Euro")) {
            return super.conver(amount);
        } else {
            return super.conver(variation, amount);
        }

    }

    @Override
    public double getFactor() {
        return 0.88;
    }

}
