package com.bolum17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Consumer;

public class LambdaExpressionsOrnekleri {
    public static void main(String[] args) {
        Calisan calisan=new Calisan("emre",3);
        Calisan calisan2=new Calisan("aemre",3);
        Calisan calisan3=new Calisan("cemre",3);
        Calisan calisan4=new Calisan("kemre",3);
        ArrayList<Calisan> calisanlar=new ArrayList<>();
        calisanlar.add(calisan);
        calisanlar.add(calisan2);
        calisanlar.add(calisan3);
        calisanlar.add(calisan4);
/*        Collections.sort(calisanlar, new Comparator<Calisan>() {
            @Override
            public int compare(Calisan calisan, Calisan t1) {
                return calisan.getIsim().compareTo(t1.getIsim());
            }
        });*/
        //lambda ile
        Collections.sort(calisanlar,(c1, c2) -> c1.getIsim().compareTo(c2.getIsim()));
        for (Calisan calisan1: calisanlar){
            System.out.println(calisan1.getIsim());
        }
        System.out.println("*-*--**-*--***-*****-**--*-*-**-");
        calisanlar.forEach(new Consumer<Calisan>() {
            @Override
            public void accept(Calisan calisan) {
                System.out.println(calisan.getIsim());
            }
        });
        //lambda version
        System.out.println("*-*--**-*--***-lambda*****-**--*-*-**-");

        calisanlar.forEach((calis) -> System.out.println(calis.getIsim()));
    }
}
