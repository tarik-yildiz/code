package com.bolum16;

public class Isci extends Thread {
    @Override
    public void run() {

        try {
            System.out.println("Iscı Sınıfı: thread=="+Thread.currentThread().getName());
            System.out.println("3 Saniye bekleniyor");
            for (int i=1;i<4;i++){
                Thread.sleep(1000);
                System.out.println(i+"...");
            }
            System.out.println("Iscı durdu");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
