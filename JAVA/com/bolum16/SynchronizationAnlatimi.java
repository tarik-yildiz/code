package com.bolum16;

public class SynchronizationAnlatimi {
    public static void main(String[] args) {
        Yazici yazici = new Yazici(12);
        Thread ayse = new Ayse(yazici);
        Thread fatma = new Ayse(yazici);
        ayse.start();
        fatma.start();

    }
}

class Yazici {
    private int dokumanSayisi;
    private int i = 0;

    public Yazici(int dokumanSayisi) {
        this.dokumanSayisi = dokumanSayisi;
    }

    public  void yazdir() {//metoda synchronized ekleyerek de kullanabilriz...
        //aynı anda farklı threadlerin kullanımında sıkıntı çıkmaması için byle kullanmalıyızz.
        synchronized (this) {
            for (i = dokumanSayisi; i > 0; i--) {
                System.out.println("Dokuman no:" + i + " Thread Adi:" + Thread.currentThread().getName());
            }
        }
    }
}

class Ayse extends Thread {
    private Yazici yazici;

    public Ayse(Yazici yazici) {
        this.yazici = yazici;
    }

    @Override
    public void run() {
        yazici.yazdir();
    }
}

class Ayse2 extends Thread {
    private Yazici yazici;

    public Ayse2(Yazici yazici) {
        this.yazici = yazici;
    }

    @Override
    public void run() {
        yazici.yazdir();
    }
}