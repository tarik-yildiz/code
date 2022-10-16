package com.bolum17;

import java.util.ArrayList;

public class LambdaExpressionsNedir {
    public static void main(String[] args) {
        System.out.println("Lambda fonksiyonlari bizi birden çok satır yazmadan daha kolay bir metot" +
                "kullanımı sağlar.");
        Calisan calisan = new Calisan("mert", 32);
        Calisan calisan3 = new Calisan("mert3", 32);
        Calisan calisan2 = new Calisan("mert2", 32);
        Calisan calisan1 = new Calisan("mert1", 32);
        ArrayList<Calisan> calisans = new ArrayList<>();
        calisans.add(calisan);
        calisans.add(calisan1);
        calisans.add(calisan2);
        calisans.add(calisan3);
        for (Calisan calisan4 : calisans) {
            bilgileriYazdir(new TekMetotluInterface() {
                @Override
                public void yazdir() {
                    System.out.println(calisan4.getIsim() + " : " + calisan4.getYas());
                }
            });//goruldugu uzere birsuru kod satırı var ve yeniden interface metodu tanımlıyoruz..
            //bunun daha iyi bir versiyonu lambda. daha temiz gorunuyor kodlar...
        }//simdi lambda versionu
        System.out.println("İSTE LAMBDAAAAAAAAAAAAAAA");
        for (Calisan calisan4 : calisans) {
            bilgileriYazdir(() -> System.out.println(calisan4.getIsim() + " : " + calisan4.getYas()));
            // -> anlamı ilgili interface'e git ve o interfacein tek metodunda bu komutları çalıştır...
            //lambdayı yeni threadlerde kullanabiliriz...
        }
        System.out.println("------------------------------THREADLER-------------------");
        new Thread(new ThreadSinifi()).start();
        //tek metodu olan interfaceler functional interface dir.
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("boyle de bir thread olusturulur");
            }
        }).start();
        //lambda ile thread olusturmak:
        new Thread(() -> System.out.println("evet bu da bir thread...")).start();
        new Thread(() -> {
            System.out.println("evet bu da bir thread...");
            System.out.println("ikinci satır calisiyor...");
            System.out.println("birden fazla satırla islem yapmak için { } kullanılır");}).start();
    }

    public static void bilgileriYazdir(TekMetotluInterface tekMetotluInterface) {
        tekMetotluInterface.yazdir();
    }
}

class Calisan {
    private String isim;
    private int yas;

    public Calisan(String isim, int yas) {
        this.isim = isim;
        this.yas = yas;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }
}

class ThreadSinifi implements Runnable {

    @Override
    public void run() {
        System.out.println("ThreadSinifi calisiyor...");
    }
}