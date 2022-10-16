package com.bolum14;

import java.io.*;

public class DosyayaYazmaVeOkuma {
    public static void main(String[] args) {
        dosyayaYaz();
        dosyadanOku();
    }

    private static void dosyadanOku() {
        DataInputStream dataInputStream=null;
        try
        {
            dataInputStream=new DataInputStream(new BufferedInputStream(new FileInputStream("Ogrenciler.dat")));
            Ogrenci okunan;
            String ogrenciNesnesi=dataInputStream.readUTF();
            System.out.println(ogrenciNesnesi);

        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void dosyayaYaz() {
        DataOutputStream dataOutputStream = null;
        Ogrenci ogrenci=new Ogrenci(12,"ssdad",true);
        try {
            dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Ogrenciler.dat")));
            dataOutputStream.writeUTF(ogrenci.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(dataOutputStream!=null){
                try {
                    dataOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Ogrenci {
    int id;
    String isim;
    boolean aktif;

    public Ogrenci(int id, String isim, boolean aktif) {
        this.id = id;
        this.isim = isim;
        this.aktif = aktif;
    }

    @Override
    public String toString() {
        return "Ogrenci{" +
                "id=" + id +
                ", isim='" + isim + '\'' +
                ", aktif=" + aktif +
                '}';
    }
}
