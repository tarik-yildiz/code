package com.bolum14;

public class DegerDondurenBloklar {
    public static void main(String[] args) {
        System.out.println(stringDondurenMetot());
        System.out.println(kendiHataniOlustur());
    }

    private static String stringDondurenMetot() {
        String selam="Merhaba";
        try{
            selam=selam+" try";
           // return selam; finally blogu her türlü calısacagı için burada deger dondurmek gerekmez
        }catch (Exception e){
            selam=selam+" ctc";
            //return selam; finally blogu her türlü calısacagı için burada deger dondurmek gerekmez
        }finally {
            selam=selam+" final";
            return selam;
        }
    }private static String kendiHataniOlustur() {
        String selam="Merhaba";
        try{
            ArrayIndexOutOfBoundsException e=new ArrayIndexOutOfBoundsException();
            throw e;
            //bu throw komutunun altında yer alan try blogu komutları calismaz. cnku bir hata uretilmistir ve catch bloguna gcer.
        }catch (Exception e){
            selam=selam+" ctc";
        }finally {
            selam=selam+" final";
            return selam;
        }
    }
}
