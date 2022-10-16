package com.bolum16;

public class IsciRunnable implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("IScI Runnable... =="+Thread.currentThread().getName());
            System.out.println("3 Saniye bekleniyor");
            for (int i=1;i<4;i++){
                Thread.sleep(1000);
                System.out.println(i+"...");
            }
            System.out.println("runable durdu");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
