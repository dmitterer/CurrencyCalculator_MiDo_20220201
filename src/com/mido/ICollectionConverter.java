package com.mido;

import com.mido.exception.NotResponsibleExept;

public interface ICollectionConverter {
    double collectconvert(double[] amounts, String variation) throws NotResponsibleExept;
}
