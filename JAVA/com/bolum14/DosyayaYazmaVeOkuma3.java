package com.bolum14;

import java.io.*;

public class DosyayaYazmaVeOkuma3 {
    public static void main(String[] args) {
        dosyayaYaz();
        dosyadanOku();
    }

    private static void dosyadanOku() {
        DataInputStream dataInputStream = null;
        boolean dosyaSonu = false;
        try {
            dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream("Ogrenciler.dat")));
            while (!dosyaSonu) {
                //burada donduye alıp tum ogrencılerı okuyoruz...
                try {
                    int id = dataInputStream.readInt();
                    String isim = dataInputStream.readUTF();
                    boolean aktif = dataInputStream.readBoolean();
                    Ogrenci ogr = new Ogrenci(id, isim, aktif);
                    System.out.println(ogr);
                } catch (EOFException e) {
                    dosyaSonu = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dataInputStream != null) {
                try {
                    dataInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void dosyadanOkuAutoClosable() {
        boolean dosyaSonu = false;
        try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream("Ogrenciler.dat")))) {
            //try'a arguman olarak  stream'i verdigimizde final blogu kullanıp dosyayı kapatmamıza gerek yok.
            while (!dosyaSonu) {
                //burada donduye alıp tum ogrencılerı okuyoruz...
                try {
                    int id = dataInputStream.readInt();
                    String isim = dataInputStream.readUTF();
                    boolean aktif = dataInputStream.readBoolean();
                    Ogrenci ogr = new Ogrenci(id, isim, aktif);
                    System.out.println(ogr);
                } catch (EOFException e) {
                    dosyaSonu = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void dosyayaYaz() {
        DataOutputStream dataOutputStream = null;
        Ogrenci ogrenci = new Ogrenci(13, "Hasan", false);
        Ogrenci ogrenci2 = new Ogrenci(133, "Mehmet", true);
        try {
            dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Ogrenciler.dat")));
            dataOutputStream.writeInt(ogrenci.id);
            dataOutputStream.writeUTF(ogrenci.isim);
            dataOutputStream.writeBoolean(ogrenci.aktif);
            dataOutputStream.writeInt(ogrenci2.id);
            dataOutputStream.writeUTF(ogrenci2.isim);
            dataOutputStream.writeBoolean(ogrenci2.aktif);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
