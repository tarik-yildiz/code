package com.bolum14.alistirma_projesi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class Alistirma2 {
    public static void main(String[] args) {
        ctrlFunc();

    }

    private static void menuGoster() {
        System.out.println("******************************");
        System.out.println("1-Liste oluştur.**************");
        System.out.println("2-Yeni çalışan ekle.**********");
        System.out.println("3-Çalışanları listele.********");
        System.out.println("4-Maaşlara göre sıralama yap.*");
        System.out.println("5-Dosyadan oku.***************");
        System.out.println("0-Dosyaya yaz.****************");
        System.out.println("******************************");
        System.out.print("=>#~ ..");
    }

    private static void ctrlFunc() {
        LinkedHashMap<String, Integer> siraliMaaslar = null;
        LinkedHashMap<String, Integer> calisanlar = null;
        ArrayList<Integer> maaslarList;
        String okunacakDosyaAdi;
        int secim = 0;
        int elemanMaasi = 0;
        String dosyaAdi = null;
        boolean menuAktifMi = true;
        Scanner giris = new Scanner(System.in);
        while (menuAktifMi) {
            menuGoster();
            if (dosyaAdi != null) {
                System.out.println("{" + dosyaAdi + "}");
            }
            if (calisanlar != null) {
                System.out.println("Liste hazır. Listede [" + calisanlar.size() + "] kişi var.");
            }
            try {
                secim = giris.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("Hatalı karakter girişi yaptınız. {" + e + "}");
                break;
            }
            switch (secim) {
                case 0: {
                    if (siraliMaaslar != null) {
                        System.out.println("Dosyanin adini giriniz => ");
                        dosyaAdi = giris.next();
                        dosyaOlustur(dosyaAdi,siraliMaaslar);

                    }else{
                        System.out.println("Dosyaya yazmadan önce çalışanlar maaşlarına göre sıralanmalıdır.");
                    }
                }
                break;
                case 1: {
                    if (calisanlar != null) {
                        System.out.println("[" + calisanlar.size() + "] kişinin kayıt olduğu bir listen var.\n" +
                                "Eğer devam edersen önceki verilerinii kaybedeceksin.\n" +
                                "Devam etmek istediğine emin misin? ~ E/H");
                        String devam = String.valueOf(giris.next().charAt(0)).toUpperCase();
                        if (devam.equals("E")) {
                            System.out.println("Yeni bir liste oluşturuldu.");
                            calisanlar = new LinkedHashMap<>();
                        } else {
                            System.out.println("Eski listeyi korumayı seçtiniz.");
                        }
                    } else {
                        calisanlar = new LinkedHashMap<>();
                        System.out.println("Yeni liste oluşturuldu. Artık ekleme yapılabilir.");
                    }
                }
                break;
                case 2: {
                    if (calisanlar != null) {
                        System.out.println("Eklemek istediğiniz çalışanın adını giriniz =>  ");
                        String eklenecekEleman = giris.next();
                        try {
                            System.out.println("Çalışanın maaşını giriniz => ");
                            elemanMaasi = giris.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Sadece [Integer] tipinde değer girilmelidir.");
                        }
                        if (elemanMaasi <= 0) {
                            System.out.println("Eklenen elemanin maasi pozitif değerde olmalıdır.");
                            eklenecekEleman = null;
                            elemanMaasi = -1;
                        } else {
                            calisanlar.put(eklenecekEleman, elemanMaasi);
                            System.out.println(eklenecekEleman + "," + elemanMaasi + " Başarıyla eklendi.");
                        }
                    } else {
                        System.out.println("Önce bir liste oluşturulmalıdır.");
                    }
                }
                break;
                case 3: {
                    if (calisanlar != null && calisanlar.size() > 0) {
                        System.out.println("Elemanlar listeleniyor...");
                        System.out.println("------------------------------------------");

                        for (Map.Entry<String, Integer> entry : calisanlar.entrySet()) {
                            System.out.println(entry);
                        }
                        System.out.println("------------------------------------------");
                        System.out.println("Listeleme bitti.");
                    } else if (calisanlar == null) {
                        System.out.println("Henüz bir liste oluşturmadınız.");
                    } else {
                        System.out.println("Listede kimse bulunmuyor.");
                    }
                }
                break;
                case 4: {
                    if (calisanlar!=null){
                        siraliMaaslar = new LinkedHashMap<>();
                        maaslarList = new ArrayList<>();
                        for (Map.Entry<String, Integer> entry : calisanlar.entrySet()) {
                            maaslarList.add(entry.getValue());
                        }
                        Collections.sort(maaslarList, new Comparator<Integer>() {
                            @Override
                            public int compare(Integer integer, Integer t1) {
                                if (integer > t1) {
                                    return -1;
                                } else if (integer < t1) {
                                    return 1;
                                } else
                                    return 0;
                            }
                        });
                        for (int i = 0; i < maaslarList.size(); i++) {
                            for (Map.Entry<String, Integer> temp : calisanlar.entrySet()) {
                                if (maaslarList.get(i).equals(temp.getValue())) {
                                    siraliMaaslar.put(temp.getKey(), maaslarList.get(i));
                                }
                            }
                        }
                        System.out.println("*Çalışanlar maaşlarına göre sıralandı.");
                    }else{
                        System.out.println("Henüz bir liste oluşturulmadı.");
                    }

                }
                break;
                case 5: {
                    if (calisanlar != null) {
                        System.out.println("Zaten bir listeniz mevcut.\n Dosya okumayı seçerseniz listeyi kaybedeceksiniz.\n" +
                                "Onaylıyor musunuz? E/H");
                        String devam = String.valueOf(giris.next().charAt(0)).toUpperCase();
                        if (devam.equals("E")) {
                            System.out.println("Okunacak dosyanın adını giriniz => ");
                            okunacakDosyaAdi = giris.next();
                            String satir = null;
                            try (BufferedReader reader = new BufferedReader(new FileReader(okunacakDosyaAdi))) {
                                while ((satir = reader.readLine()) != null) {
                                    String dizi[] = satir.split(" ");
                                    calisanlar = new LinkedHashMap<>();
                                    calisanlar.put(dizi[0], Integer.parseInt(dizi[1]));
                                }
                            } catch (Exception exception) {

                            } finally {
                                System.out.println(calisanlar);
                            }

                        } else {
                            System.out.println("Eski listeyi korumayı seçtiniz.");
                        }
                    } else {
                        System.out.println("Okunacak dosyanın adını giriniz => ");
                        okunacakDosyaAdi = giris.next();
                        String satir = null;
                        try (BufferedReader reader = new BufferedReader(new FileReader(okunacakDosyaAdi))) {
                            calisanlar = new LinkedHashMap<>();
                            while ((satir = reader.readLine()) != null) {
                                String dizi[] = satir.split(" ");

                                calisanlar.put(dizi[0], Integer.parseInt(dizi[1]));
                            }
                            System.out.println("Dosya başarıyla içe aktarıldı.");
                        } catch (Exception exception) {
                            System.out.println("Boyle bir dosya yok.");
                        } finally {
                            System.out.println(calisanlar);
                        }
                    }
                }
                break;

                default:
                    menuAktifMi = false;
                    System.out.println("Çıkış yapmayı seçtiniz.");
                    break;
            }

        }
    }

    private static void dosyaOlustur(String dosyaAdi,LinkedHashMap<String,Integer> map) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dosyaAdi))) {
            for(Map.Entry<String,Integer> temp: map.entrySet()){
                writer.write(temp.getKey()+" "+temp.getValue()+"\n");
            }
            System.out.println("Dosya oluşturuldu. Dosya adı :[" + dosyaAdi + "]");
        } catch (Exception e) {

        }
    }

}
