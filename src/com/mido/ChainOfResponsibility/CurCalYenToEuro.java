package com.mido.ChainOfResponsibility;

import com.mido.IConverter;
import com.mido.exception.NotResponsibleExept;

public class CurCalYenToEuro extends CurCal{
    public CurCalYenToEuro(IConverter nexICurCal) {
        super(nexICurCal);
    }

    @Override
    public double conver(String variation, double amount) throws NotResponsibleExept {
        if (variation.equals("Yen to Euro")) {
            return super.conver(amount);
        } else {
            return super.conver(variation, amount);
        }

    }

    @Override
    public double getFactor() {
        return 0.0076;
    }

}
