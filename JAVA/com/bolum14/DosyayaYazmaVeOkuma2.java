package com.bolum14;

import java.io.*;

public class DosyayaYazmaVeOkuma2 {
    public static void main(String[] args) {
        dosyayaYaz();
        dosyadanOku();
    }

    private static void dosyadanOku() {
        DataInputStream dataInputStream=null;
        try {
            dataInputStream=new DataInputStream(new BufferedInputStream(new FileInputStream("Ogrenciler.dat")));
            int id=dataInputStream.readInt();
            String isim=dataInputStream.readUTF();
            boolean aktif=dataInputStream.readBoolean();
            Ogrenci ogr1=new Ogrenci(id,isim,aktif);
            System.out.println(ogr1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void dosyayaYaz() {
        DataOutputStream dataOutputStream=null;
        Ogrenci ogrenci=new Ogrenci(13,"Hasan",false);
        try{
                dataOutputStream=new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Ogrenciler.dat")));
                dataOutputStream.writeInt(ogrenci.id);
                dataOutputStream.writeUTF(ogrenci.isim);
                dataOutputStream.writeBoolean(ogrenci.aktif);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                dataOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
