package com.mido.ChainOfResponsibility;

import com.mido.IConverter;
import com.mido.exception.NotResponsibleExept;

public class CurCalEuroToDollar extends CurCal {

    public CurCalEuroToDollar(IConverter nextCurCal) {
        super(nextCurCal);
    }

    @Override
    public double conver(String variation, double amount) throws NotResponsibleExept {
        if (variation.equals("Euro to Dollar")) {
            return super.conver(amount);
        } else {
            return super.conver(variation, amount);
        }

    }

    @Override
    public double getFactor() {
        return 1.13;
    }

    public static class CurCalEuroToDollarBuilder {
        private IConverter nextIConverter;

        public CurCalEuroToDollarBuilder() {
        }

        public CurCalEuroToDollarBuilder setNextIConverter(IConverter iConverter) {
            this.nextIConverter = iConverter;
            return this;
        }

        public CurCalEuroToDollar build() {
            return new CurCalEuroToDollar(this.nextIConverter);
        }


    }

}
