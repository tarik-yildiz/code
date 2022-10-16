package com.bolum14;

public class BirdenFazlaCatch {
    public static void main(String[] args) {
        String[] dizi = {"abc", "2321", null, "asdda"};

        for (int i = 0; i < dizi.length; i++) {
            try {
                int sayi = dizi[i].length() + Integer.parseInt(dizi[i]);
            } catch (NumberFormatException e) {
                System.out.println("Bir hata: " + e.toString());
            } catch (NullPointerException e) {
                System.out.println(e);
            }
        }
        System.out.println("*****************");
        for (int i = 0; i < dizi.length; i++) {
            try {
                int sayi = dizi[i].length() + Integer.parseInt(dizi[i]);
            } catch (NumberFormatException | NullPointerException e) {
                System.out.println("Bir hata: " + e.toString());
                System.out.println("İç içe birden cok catch yapmak yerine böyle de  kullanılabilir.");
            }
        }
            System.out.println("*****************");
            for (int i = 0; i < dizi.length; i++) {
                try {
                    int sayi = dizi[i].length() + Integer.parseInt(dizi[i]);
                } catch (Exception e) {
                    System.out.println("Bir hata: " + e.toString());
                    System.out.println("İç içe birden cok catch yapmak yerine Exception sınıfı kullanılabilir.");
                }

            }
        }
    }
