package com.mido.adapter;

import com.mido.ICollectionConverter;
import com.mido.IConverter;
import com.mido.exception.NotResponsibleExept;

public  class AdapterCollecCurCal implements ICollectionConverter {

    private IConverter iConverter;

    public AdapterCollecCurCal(IConverter iConverter) {
        this.iConverter = iConverter;
    }


    @Override
    public double collectconvert(double[] amounts, String variation) throws NotResponsibleExept {
        double sum = 0;
        for (int i = 0; i < amounts.length; i++) {
            sum += iConverter.conver(variation, amounts[i]);
        }
        return sum;
    }
}

