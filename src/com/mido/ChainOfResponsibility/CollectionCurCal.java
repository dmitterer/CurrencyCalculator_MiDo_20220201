package com.mido.ChainOfResponsibility;

import com.mido.ICollectionConverter;

public abstract class CollectionCurCal implements ICollectionConverter {

    private CollectionCurCal nextCurCal;

    public CollectionCurCal(CollectionCurCal nextcollectionCurCal) {
        this.nextCurCal = nextcollectionCurCal;
    }

    @Override
    public double collectconvert(double[] amounts, String variation) {
        if (this.nextCurCal != null) {
            return nextCurCal.collectconvert(amounts, variation);
        } else {
            System.out.println("No responsibility found");
            return 0.0;
        }
    }

}
