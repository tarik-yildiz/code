package com.bolum14;

public class ExceptionKavrami {
    public static void main(String[] args) {
        try {
            Integer integer = new Integer("we");
        } catch (Exception e) {
            System.out.println("hata olustu. Hata aciklamasi: " +e.toString());}

        try {
            int a=5/0;
        } catch (Exception e) {
            System.out.println("hata olustu. Hata aciklamasi: " +e.toString());}

        try {
            int[] dizi={1,2,3};
            System.out.println(dizi[45]);
        } catch (Exception e) {
            System.out.println("hata olustu. Hata aciklamasi: " +e.toString());}

        try {
            Object a=new Object();
            String b=(String)a;
        } catch (Exception e) {
            System.out.println("hata olustu. Hata aciklamasi: " +e.toString());}
        try {
            System.out.println("Burasi try blogu");
        } catch (Exception e) {
            System.out.println("hata olusursa burası calısır");}
        finally {
            System.out.println("hata çıksın çıkmasın burası kesin yazacak.");
        }
    }
}
