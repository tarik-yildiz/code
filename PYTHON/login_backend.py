metin_giris_yapilmadi="""
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@ WEBSITE LOGIN SCREEN V.01 @
@ 1 - UYE OL                @
@ 2 - GIRIS YAP             @
@ 3 - UYGULAMADAN CIK       @
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
"""

metin_giris_yapildi="""
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@ 1 - PAROLA DEGISTIR       @
@ 2 - BILGILERINI YAZDIR    @
@ 3 - CIKIS YAP             @
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
"""
k_adi_metni="KULLANICI ADI: "
sifre_metni="PAROLA: "
sifre_metni2="PAROLA YENIDEN: "
hesap_olsumadi_metni="HENUZ BIR HESAP OLUSTURULMADI"
hesap_sayisi=0
giris_yapildi_mi=False
k_adi=""
k_adi_giris=""
parola=""
parola_giris=""
parola_kontrol=""
hesap_olustu_metni="HESAP BASARIYLA OLUSTURULDU."
while True:
    if giris_yapildi_mi:
        print(metin_giris_yapildi)
        secim = input("--> : ")
        if secim=="1":
            pass
        elif secim=="2":
            pass
        elif secim=="3":
            pass
    else:
        print(metin_giris_yapilmadi)
        secim = input("--> : ")
        if secim == "1":
            k_adi = input(k_adi_metni)
            parola = input(sifre_metni)
            parola_kontrol = input(sifre_metni2)
            if parola == parola_kontrol:
                hesap_sayisi += 1
                print(hesap_olustu_metni, k_adi, sep="\n")

        elif secim == "2":
            k_adi_giris = input(k_adi_metni)
            parola_giris = input(sifre_metni)
            if k_adi_giris == k_adi and parola_giris == parola:
                giris_yapildi_mi = True
                print("@@@@@ Giris yapildi @@@@@@")

            pass


