package com.mido.ChainOfResponsibility;

import com.mido.IConverter;
import com.mido.exception.NotResponsibleExept;

public class CurCalEuroToChf extends CurCal{

    public CurCalEuroToChf(IConverter nextCurCal) {
        super(nextCurCal);
    }

    @Override
    public double conver(String variation, double amount) throws NotResponsibleExept {
        if (variation.equals("Euro to Chf")) {
            return super.conver(amount);
        } else {
            return super.conver(variation, amount);
        }

    }

    @Override
    public double getFactor() {
        return 1.040;
    }



}
