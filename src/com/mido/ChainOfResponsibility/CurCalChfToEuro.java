package com.mido.ChainOfResponsibility;

import com.mido.IConverter;
import com.mido.exception.NotResponsibleExept;

public class CurCalChfToEuro  extends CurCal {

    public CurCalChfToEuro(IConverter nextCurCal) {
            super(nextCurCal);
        }

    @Override
        public double conver(String variation, double amount) throws NotResponsibleExept {
            if (variation.equals("Chf to Euro")) {
                return super.conver(amount);
            } else {
                return super.conver(variation, amount);
            }
        }

        @Override
        public double getFactor() {
            return 0.95;
        }

    }
