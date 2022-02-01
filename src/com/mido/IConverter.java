package com.mido;

import com.mido.exception.NotResponsibleExept;

public interface IConverter {
    double conver(String variation, double amount) throws NotResponsibleExept;
}
