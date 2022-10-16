liste=[1,2,3,4,5]
sozluk={"key":"val","key2":"val2"}
print(sozluk)
ic_ice_liste=[1,2,[0,25,50],3,4]
ic_ice_sozluk={"kelime1":{"icerdeki_anahtar":1,"icerdeki_anahtar2":2},"kelime2":"anlami"}
print(ic_ice_sozluk)
print(ic_ice_sozluk["kelime1"]["icerdeki_anahtar"])
print(ic_ice_liste[2][1])
#sozluge eleman eklemek append metodu veya sozluk["anahtar"]="deger" seklinde olır

#set
bos_set=set()
print(type(bos_set))
#tuple: degistirilemeyen listeler olusturmak icin kullanilir
my_tuple=(1,2,3,4,5,6) #bu listeye ekleme cikarma degistirme yapilamaz!!

def ikiyleCarp(sayi):
    return 2*sayi
sayilar=[1,2,3,4,5,6,7,8,9,10]
yeni_liste=[]
for sayi in sayilar:
    yeni_liste.append(ikiyleCarp(sayi))

#map fonksiyonu bu for dongusunu kolaylastirir.
#veri dizisini baska bir veri dizisine cevirir.
list(map(ikiyleCarp, sayilar))
#fonksiyonun icine tek tek listedeki elemanlari gonderir.
#map onemli

#lambda: tek satirda fonksiyon
carpma=lambda num: num*20
#ornak kullanim
string_liste= ["b","a"]
list(filter(lambda string : "a" in string, string_liste))
