package com.mido;

import com.mido.ChainOfResponsibility.*;
import com.mido.adapter.AdapterCollecCurCal;
import com.mido.decorator.FeeDecorator;
import com.mido.exception.NotResponsibleExept;

/*
    @Author: Dominik Mitterer
    @Title: Main_MiDo
    @Creationdate: 2022-01-28
    @Completiondate: 2022-02-01
    @Description: Through this Class you can run this Application!!!
 */
public class Main_MiDo {

    public static void main(String[] args) {

        IConverter curcal = new CurCalEuroToYen(new CurCalEuroToDollar(new CurCalYenToEuro(new CurCalDollarToEuro(new CurCalChfToEuro(new CurCalEuroToChf(null))))));
        curcal = new FeeDecorator(curcal);
        ICollectionConverter collectCurCal = new AdapterCollecCurCal(curcal);
        IConverter iConverter1 = new CurCalEuroToDollar.CurCalEuroToDollarBuilder()
                .setNextIConverter(new CurCalChfToEuro(null))
                .build();

        double[] dummyval = {5.5, 8, 88, 487, 9};
        double[] dummyval1 = {5.5, 8, 88, 35, 3};
        try {
            System.out.println("--------------------------------------------------");
            System.out.println("CurCal:");
            System.out.println(curcal.conver("Euro to Yen", 8888));
            System.out.println(curcal.conver("Yen to Euro", 8888));
            System.out.println("**************************************************");
            System.out.println(curcal.conver("Euro to Dollar", 590));
            System.out.println(curcal.conver("Dollar to Euro", 590));
            System.out.println(curcal.conver("Euro to Chf", 590));
            System.out.println(curcal.conver("Chf to Euro", 590));
            System.out.println("--------------------------------------------------");


            System.out.println("--------------------------------------------------");
            System.out.println("Builder CurCal:");
            System.out.println(iConverter1.conver("Dollar to Euro", 989));
            System.out.println(iConverter1.conver("Chf to Euro", 15145.11));
            System.out.println("--------------------------------------------------");

            System.out.println("--------------------------------------------------");
            System.out.println("Collection CurCal:");
            System.out.println(collectCurCal.collectconvert(dummyval, "Dollar to Euro"));
            System.out.println(collectCurCal.collectconvert(dummyval, "Euro to Dollar"));
            System.out.println("**************************************************");
            System.out.println(collectCurCal.collectconvert(dummyval, "Yen to Euro"));
            System.out.println(collectCurCal.collectconvert(dummyval, "Euro to Yen"));
            System.out.println("--------------------------------------------------");
        } catch (NotResponsibleExept notResponsibleExept) {
            System.out.println(notResponsibleExept.getMessage());
        }

    }
}
