package com.bolum16;

public class UreticiTuketici {
    public static void main(String[] args) {
        OrtakAlan o=new OrtakAlan();
        Producer producer=new Producer(o);
        Consumer consumer=new Consumer(o);
        producer.start();
        consumer.start();

    }
}
class OrtakAlan{
    private int veri;
    private boolean veriVarMi=false;
    public synchronized void veriYaz(int veri){
        while (veriVarMi){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.veri=veri;
        veriVarMi=true;
        notifyAll();
    }
    public synchronized int veriOku(){
        while (!veriVarMi){
            try {
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        veriVarMi=false;
        notifyAll();
        return veri;
    }
}
class Producer extends Thread{
    OrtakAlan ortakAlan;

    public Producer(OrtakAlan ortakAlan) {
        this.ortakAlan = ortakAlan;
    }

    @Override
    public void run() {
     for (int i=1;i<11;i++){
         ortakAlan.veriYaz(i);
         System.out.println(ThreadRenkler.Red+"Uretici : uretilen veri: "+i);
         try {
             sleep((int)(Math.random()*2000));
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }
    }
}
class Consumer extends Thread{
    OrtakAlan ortakAlan;
    private int veri;

    public Consumer(OrtakAlan ortakAlan) {
        this.ortakAlan = ortakAlan;
    }

    @Override
    public void run() {
        for (int i=0;i<10;i++){
           veri= ortakAlan.veriOku();
            System.out.println(ThreadRenkler.Green+"Tüketici: okunan veri: "+veri);
            try {
                sleep((int)(Math.random()*2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}