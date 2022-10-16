package com.bolum14.alistirma_projesi;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Alistirma {
    public static void main(String[] args) {

        Scanner giris = new Scanner(System.in);
        int secim;
        String dosyaIcerigi = null;
        String raporAdi = null;
        String icerikDizisi[];
        String dosyaAdi = null;
        String detayliRaporAdi = null;
        String enCokTekrarEdenKelime;
        boolean menuAktifMi = true;
        while (menuAktifMi) {
            menu();
            if (dosyaAdi != null) {
                if (raporAdi != null) {
                    System.out.println("#=>~:  [" + dosyaAdi + "] ==> [" + raporAdi + "] Raporu yazıldı.");
                } else if (detayliRaporAdi != null) {
                    System.out.println("#=>~:  [" + dosyaAdi + "] ==> [" + detayliRaporAdi + "] Raporu yazıldı.");
                } else {
                    System.out.println("#=>~:  [" + dosyaAdi + "] ==> [Rapor dosyası yazılmadı...]");
                }
            } else
                System.out.println("#=>~:  [dosya belirlenmedi]");
            try {
                secim = giris.nextInt();
            } catch (Exception e) {
                System.out.println("Yalnızca rakam girişi yapmanız gerekmektedir.");
                return;
            }
            if (secim == 1) {
                System.out.println("Okunacak dosyanin adini giriniz: ");
                dosyaAdi = giris.next();
                dosyaIcerigi = dosyayiAnalizEt(dosyaAdi);
                if (dosyaIcerigi == null) {
                    dosyaAdi = null;
                }
            } else if (secim == 2) {
                if (dosyaAdi != null) {
                    System.out.println("Oluşturulacak rapor dosyasının adını girin:");
                    raporAdi = giris.next();
                    icerikDizisi = dosyaIcerigi.split("\t");
                    int karakter = Integer.parseInt(icerikDizisi[0]);
                    int kelime = Integer.parseInt(icerikDizisi[1]);
                    int satir = Integer.parseInt(icerikDizisi[2]);
                    enCokTekrarEdenKelime=icerikDizisi[3];
                    raporHazirla(karakter, kelime, satir,enCokTekrarEdenKelime, raporAdi);
                } else {
                    System.out.println("İlk once bir dosya seçilmelidir.");
                }
            } else if (secim == 3) {
                if (dosyaAdi != null) {
                    System.out.println("Detaylı rapor dosyası için bir isim giriniz:");
                    detayliRaporAdi = giris.next();
                    detayliRaporOlustur(detayliRaporAdi, dosyaAdi);
                } else {
                    System.out.println("İlk once bir dosya seçilmelidir.");
                }
            } else if (secim == 4) {
                dosyaIcerigi = null;
                raporAdi = null;
                dosyaAdi = null;
                detayliRaporAdi = null;
                System.out.println("Uygulama sıfırlandı.");
            } else {
                System.out.println("Uygulamadan çıkmayı seçtiniz.");
                menuAktifMi = false;
            }
        }

    }

    private static void detayliRaporOlustur(String detayliRaporAdi, String dosyaAdi) {
        String sonuc = null;
        String okunanSatir;
        HashMap<String, Integer> kelimeTekrarlari = new HashMap<>();
        int tekrar = 0;
        String enCokTekrarEdenKelime = null;
        int satir = 0, karakter = 0, kelime = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(dosyaAdi))) {
            while ((okunanSatir = reader.readLine()) != null) {
                karakter += okunanSatir.length();
                String kelimeler[] = okunanSatir.split(" ");
                sonuc = okunanSatir;
                sonuc += "\n | Satir no= " + (++satir) + " | Satir uzunlugu:" + okunanSatir.length() + " | Toplam karakter= " + karakter + " | Toplam kelime: " + kelimeler.length + "\n";
                kelime += kelimeler.length;

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(detayliRaporAdi, true))) {
                    writer.write(sonuc);
                } catch (IOException e) {
                    System.out.println("hata: " + e);
                }
            }
            System.out.println("Detaylı rapor [" + detayliRaporAdi + "] başarıyla oluşturuldu...");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static String dosyayiAnalizEt(String dosyaAdi) {
        HashMap<String, Integer> kelimeTekrarlari = new HashMap<>();
        String enCokTekrarEdenKelime = null;
        int tekrarSayisi=0;
        String sonuc = null;
        try (BufferedReader okuyucu = new BufferedReader(new FileReader(dosyaAdi))) {
            String satir;
            int satirSayisi = 0, toplamKarakter = 0, toplamKelime = 0;
            while ((satir = okuyucu.readLine()) != null) {
                toplamKarakter += satir.length();
                String kelimeler[] = satir.toLowerCase().split(" ");
                toplamKelime += kelimeler.length;
                satirSayisi++;
                for (String kelime:kelimeler){
                    if (kelimeTekrarlari.containsKey(kelime)){
                        kelimeTekrarlari.put(kelime,kelimeTekrarlari.get(kelime)+1);
                    }else{
                        kelimeTekrarlari.put(kelime,1);
                    }
                }
                for (Map.Entry<String,Integer> temp: kelimeTekrarlari.entrySet()){
                    if (temp.getValue() > tekrarSayisi){
                        enCokTekrarEdenKelime=temp.getKey();
                        tekrarSayisi=temp.getValue();
                    }

                }
            }
            System.out.println("Analiz başarılı.");
            sonuc = toplamKarakter + "\t" + toplamKelime + "\t" + satirSayisi+"\t"+enCokTekrarEdenKelime+" "+ tekrarSayisi+" kere tekrar etti.";
            System.out.println(kelimeTekrarlari);
            return sonuc;
        } catch (Exception e) {
            System.out.println("Hata: " + e);
            return null;
        }
    }


    private static void raporHazirla(int karakter, int kelime, int satir, String enCokTekrarEdenKelime, String dosyaAdi) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dosyaAdi, true))) {
            String sonuc = " Metindeki karakter sayısı: " + karakter +
                    "\n Metindeki kelime sayısı: " + kelime +
                    "\n Metindeki satır sayısı: " + satir+
                    "\n En çok tekrar eden kelime: "+enCokTekrarEdenKelime;

            writer.write(sonuc);
            System.out.println("Rapor " + dosyaAdi + " dosyasına başarıyla yazıldı.");
        } catch (Exception e) {
            System.out.println("Hata: " + e);
        }
    }

    private static void dosyayaYaz() {
        try (BufferedWriter yazici = new BufferedWriter(new FileWriter("istiklal.txt"))) {
            yazici.write("İSTİKLAL MARŞI\n" +
                    "\n" +
                    "    Korkma, sönmez bu şafaklarda yüzen al sancak;\n" +
                    "    Sönmeden yurdumun üstünde tüten en son ocak.\n" +
                    "    O benim milletimin yıldızıdır, parlayacak;\n" +
                    "    O benimdir, o benim milletimindir ancak.\n" +
                    "\n" +
                    "    Çatma, kurban olayım, çehreni ey nazlı hilal!\n" +
                    "    Kahraman ırkıma bir gül! Ne bu şiddet, bu celal?\n" +
                    "    Sana olmaz dökülen kanlarımız sonra helal...\n" +
                    "    Hakkıdır, hakk'a tapan, milletimin istiklal!\n" +
                    "\n" +
                    "    Ben ezelden beridir hür yaşadım, hür yaşarım.\n" +
                    "    Hangi çılgın bana zincir vuracakmış? Şaşarım!\n" +
                    "    Kükremiş sel gibiyim, bendimi çiğner, aşarım.\n" +
                    "    Yırtarım dağları, enginlere sığmam, taşarım.\n" +
                    "\n" +
                    "    Garbın afakını sarmışsa çelik zırhlı duvar,\n" +
                    "    Benim iman dolu göğsüm gibi serhaddim var.\n" +
                    "    Ulusun, korkma! Nasıl böyle bir imanı boğar,\n" +
                    "    'Medeniyet!' dediğin tek dişi kalmış canavar?\n" +
                    "\n" +
                    "    Arkadaş! Yurduma alçakları uğratma, sakın.\n" +
                    "    Siper et gövdeni, dursun bu hayasızca akın.\n" +
                    "    Doğacaktır sana va'dettigi günler hakk'ın...\n" +
                    "    Kim bilir, belki yarın, belki yarından da yakın.\n" +
                    "\n" +
                    "    Bastığın yerleri 'toprak!' diyerek geçme, tanı:\n" +
                    "    Düşün altında binlerce kefensiz yatanı.\n" +
                    "    Sen şehit oğlusun, incitme, yazıktır, atanı:\n" +
                    "    Verme, dünyaları alsan da, bu cennet vatanı.\n" +
                    "\n" +
                    "    Kim bu cennet vatanın uğruna olmaz ki feda?\n" +
                    "    Şuheda fışkıracak toprağı sıksan, şuheda!\n" +
                    "    Canı, cananı, bütün varımı alsın da hüda,\n" +
                    "    Etmesin tek vatanımdan beni dünyada cüda.\n" +
                    "\n" +
                    "    Ruhumun senden, ilahi, şudur ancak emeli:\n" +
                    "    Değmesin mabedimin göğsüne namahrem eli.\n" +
                    "    Bu ezanlar-ki şahadetleri dinin temeli,\n" +
                    "    Ebedi yurdumun üstünde benim inlemeli.\n" +
                    "\n" +
                    "    O zaman vecd ile bin secde eder -varsa- taşım,\n" +
                    "    Her cerihamdan, ilahi, boşanıp kanlı yaşım,\n" +
                    "    Fışkırır ruh-i mücerred gibi yerden na'şım;\n" +
                    "    O zaman yükselerek arsa değer belki başım.\n" +
                    "\n" +
                    "    Dalgalan sen de şafaklar gibi ey şanlı hilal!\n" +
                    "    Olsun artık dökülen kanlarımın hepsi helal.\n" +
                    "    Ebediyen sana yok, ırkıma yok izmihlal:\n" +
                    "    Hakkıdır, hür yaşamış, bayrağımın hürriyet;\n" +
                    "    Hakkıdır, hakk'a tapan, milletimin istiklal!\n");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void menu() {
        System.out.println("##########################");
        System.out.println("1- Dosyayı analiz et.#####");
        System.out.println("2- Sonucları raporla.#####");
        System.out.println("3- Detaylı rapor olustur.#");
        System.out.println("4- Uygulamayı sıfırla.####");
        System.out.println("0- Uygulamadan çık.#######");
        System.out.println("##########################");
    }
}
