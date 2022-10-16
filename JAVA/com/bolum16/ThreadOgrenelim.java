package com.bolum16;

import java.util.Scanner;

public class ThreadOgrenelim {
    public static void main(String[] args) {
        System.out.println("Program başladı... = " +Thread.currentThread().getName());
       /* try {
            System.out.println("3 Saniye bekleniyor");
            for (int i=1;i<4;i++){
                Thread.sleep(1000);
                System.out.println(i+"...");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        Scanner giris=new Scanner(System.in);
        int al=giris.nextInt();
        //1.yol
        Isci isci=new Isci();
      //  isci.run();
        isci.setName("ISCI-Thread");
        isci.start();
        System.out.println("3 Saniye bitti...");
        //2.yol

        IsciRunnable isciRunnable=new IsciRunnable();
        Thread isci2=new Thread(isciRunnable);
        isci2.start();
        //3. yol
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("sadasdasd");
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
        //4.yol
        new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }.start();
    }
}
