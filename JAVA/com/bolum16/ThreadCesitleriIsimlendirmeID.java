package com.bolum16;

import org.w3c.dom.ls.LSResourceResolver;

public class ThreadCesitleriIsimlendirmeID {
    public static void main(String[] args) {
        //user thread ve daemon thread olmak uzere iki thread var...
        //java virt.mach. user threadların bitmesini beklerken daemon threadları beklemek zorunda degil.
        //user threadlar bittiği an uygulama kapanır.
        MyThread yeni=new MyThread("daemon Thread",ThreadRenkler.Blue,6);
        System.out.println(yeni.getName()+" ID'si= "+yeni.getId());
        yeni.setDaemon(true);// uygulama deamon threadlerin bitmesini beklemez. Bitmesi gerekmez. Thread bitmeden başka işlem yoksa thread sonlandirilir...
        yeni.start();
        MyThread yeni2=new MyThread("user Thread",ThreadRenkler.Red,9);
        System.out.println(yeni2.getName()+" ID'si= "+yeni2.getId());

        yeni2.start();
    }
}

class MyThread extends Thread {
    private String renk;
    private int saniye;

    public MyThread(String name, String renk, int saniye) {
        super(name);
        this.renk = renk;
        this.saniye = saniye;
    }

    @Override
    public void run() {
        System.out.println(renk+saniye+" saniye baslıyor..."+this.getName());
        for (int i=1;i<=saniye;i++){
            try {
                Thread.sleep(1000);
                System.out.println(renk+i+"...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(renk+"İşlem sonlandı.");

    }
}