package com.bolum16;

import java.util.concurrent.TimeoutException;

public class OncelikVermeJoinInterrupt {
    public static void main(String[] args) {
        TekSayilar nesne= new TekSayilar("1");
      //  TekSayilar nesne2= new TekSayilar("2");
    // f    nesne.setPriority(Thread.MIN_PRIORITY);//bunlara güven olmuyo ama yine de yap
        nesne.start();
     //   nesne2.setPriority(Thread.MAX_PRIORITY);//kullanışsız işe yaramıyor .ddd
      //  nesne2.start();
        new Thread(){
            @Override
            public void run() {
                for(int i=0;i<100;i++){
                    if (i==10){
                        try {
                            nesne.join();//join metodu bize öncelik veriyor şöyle ki:
                            //bu threadin işlemi askıya alınıyor ve nesne threadinin
                            //işleminin bitirmesi bekleniyor.
                            //nesne thread işini bitirdiğinde bu thread kaldığı yerden
                            //devam ediyor...
                            //join() parantez içine milisaniye degeri verilip,
                            //o kadar milisaniye beklemesini sağlayabiliriz...
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (i%2==0){
                        System.out.println(ThreadRenkler.Green+i);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            //e.printStackTrace();
                            return;//interrupt oldugunda uygulama/metot/thread sonlandı.
                        }
                    }
                }
            }
        }.start();
    }
}

class TekSayilar extends Thread{
    String isim;
    String renk;
    public TekSayilar(String name) {
        super(name);
        isim=name;
        if (name.equals("1")){
            renk=ThreadRenkler.Red;

        }else renk=ThreadRenkler.Blue;
    }

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            if (i==5){
                interrupt();
            }
            if (i%2==1){
                System.out.println(renk+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                    return;//interrupt oldugunda uygulama/metot/thread sonlandı.
                }
            }
        }
    }
}