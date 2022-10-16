package com.sanslionnumara;

import java.util.*;

public class Main {
    static final int MAX_SAYI=60;
    static final int MAX_URETIM_MIKTARI=1000000;

    public static void main(String[] args) {
	// write your code here
        // 1 den 60a kadar olan sayıları 1.000.000 kere olustur
        //bir map içerisinde anahtar=sayı  deger=kac kere cıktıgı olarak sakla
        //işlem btince bu sayıları tekrar etme sayısına gore bır lısteye aktar.
        //sonra en cok uretılen 10 saıyıyı ekrana bastır
      // List<String> liste=new ArrayList<>();//boyle yaptıgımız zaman ikinci verdigimiz nesne(arraylis)'in metodları calısır
      // ArrayList<String> liste2=new ArrayList<>();
       Map<Integer,Integer> olusturulanSayilarMap=new HashMap<>();
       List<Integer> sayiListesi=new ArrayList<>();
        Set<Integer> sansliSayilar=new TreeSet<>();
       mapiDoldur(olusturulanSayilarMap);
        System.out.println(olusturulanSayilarMap);
        listeyiDoldur(olusturulanSayilarMap,sayiListesi);
        System.out.println("liste size:" +sayiListesi.size());
        sanliOnSayiyiBul(sansliSayilar,sayiListesi);
        System.out.println("sanslisayisize:"+sansliSayilar.size());
        System.out.println("Sansli sayilar:" +sansliSayilar);
    }

    private static void sanliOnSayiyiBul(Set<Integer> sansliSayilar, List<Integer> sayiListesi) {
       Collections.shuffle(sayiListesi);
        while(sansliSayilar.size()<10){
            int rastgeleSayi=((int)(Math.random()*MAX_URETIM_MIKTARI));
            sansliSayilar.add(sayiListesi.get(rastgeleSayi));

        }
    }

    private static void listeyiDoldur(Map<Integer, Integer> olmap, List<Integer> liste) {

        for (Map.Entry<Integer,Integer> gecici:olmap.entrySet()){
            int key=gecici.getKey();
            int value=gecici.getValue();
            for(int i=0;i<value;i++){
                liste.add(key);
            }
        }

    }

    private static void mapiDoldur(Map<Integer, Integer> olusturulanSayilarMap) {
        for(int i=0;i<MAX_URETIM_MIKTARI;i++){
            int randsayi=sayiOlustur();
            if(olusturulanSayilarMap.containsKey(randsayi)){
                int value=olusturulanSayilarMap.get(randsayi);
                olusturulanSayilarMap.put(randsayi,++value);
            }else{
                olusturulanSayilarMap.put(randsayi,1);
            }
        }

    }
    private static int sayiOlustur(){
        return ((int)(Math.random()*MAX_SAYI)+1);
    }

}
