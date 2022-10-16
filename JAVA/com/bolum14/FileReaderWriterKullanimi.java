package com.bolum14;

import java.io.*;

public class FileReaderWriterKullanimi {
    //streamler karakter tabanli ya da byte tabanlı olyuor
    public static void main(String[] args) {


        veriYazma();
        veriOkuma();

    }

    private static void veriOkuma() {
        try (BufferedReader reader = new BufferedReader(new FileReader("KarakterTabanli.txt"))) {
            String olay;
            while ((olay=reader.readLine())!=null){
                //s.split(" ") kullanarak tırnak ıcerısındekı degere gore metını parcalayabılırız.
                System.out.println(olay);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        ;
    }

    private static void veriYazma() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("KarakterTabanli.txt", true))) { //true dosyanın üstüne ekleme yapmamızı saglıyor
            writer.write("Cav Bella Cav Bella\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
