package com.bolum14;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class CokKarsilasilanHatalar {
    public static void main(String[] args) {
        //NullPointerException
        try {
            System.out.println(Test.isim.length());
        } catch (NullPointerException e) {
            System.out.println("Bir hatayla karşılaştık. Hata Kodu: " + e);
        }
        //ArrayIndexOutOfBoundsException
        try {
            int[] dizi = {1, 2, 3};
            System.out.println(dizi[4]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Bir hatayla karşılaştık. Hata Kodu: " + e);
        }
        //NumberFormatException
        try {
            int sayi = Integer.parseInt("aa12");
        }catch(NumberFormatException e){
            System.out.println("Bir hatayla karşılaştık. Hata Kodu: " + e);
        }
        //ClassNotFoundException
        try {
            Class.forName("BirSinifIsmi");
        } catch (ClassNotFoundException e) {
//            e.printStackTrace();//bu kod normal hata almıs gibi gosterir. Tabiki
            // program devam eder...
            System.out.println("Bir hatayla karşılaştık. Hata Kodu: " + e);
        }
        //ArithmeticalException
        try{
           int bolum= 10/0;
        }catch (ArithmeticException e){
//            e.printStackTrace();
            System.out.println("Bir hatayla karşılaştık. Hata Kodu: " + e);
        }
        //SQLException vardı ama yazmadım henuz islemedik.

        //ClassCastException
        try{
            UstFinif ustFinif=new UstFinif();
            AltSinif altSinif=new AltSinif();
            altSinif=(AltSinif)ustFinif;
        }catch (ClassCastException e){
            System.out.println("Bir hatayla karşılaştık. Hata Kodu: " + e);
        }
        //IOException
        String dosyaKonum="C:\\Users\\doodle\\metin2.txt";
        BufferedReader reader=null;
        try {
            reader=new BufferedReader(new FileReader(dosyaKonum));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //InterruptedException
        //SecurityException
    }

}

class Test {
    static String isim;
}
class UstFinif{

}class AltSinif extends UstFinif{

}