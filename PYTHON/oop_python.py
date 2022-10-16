#instance &attribute & instantiate& init -initialize
class Meyve():
    isim=""
    renk=""
    kalori=0

elma=Meyve()
print(elma)
#init metodu

class Araba():
    def __init__(self,yil,renk,kilometre):
        self.yil=yil
        self.renk=renk
        self.kilometre=kilometre
    def toString(self):
        print(f"Yil: {self.yil} Renk: {self.renk} kilometre: {self.kilometre}")

arabam=Araba(1999,"kirmizi",193600)
arabam.toString()
#kalitim
class Canli():
    def __init__(self):
        print("canli olusturuldu")
    def nefes_al(self):
        print("canli nefes aldi")

class Kopek(Canli):
    def __init__(self):
        Canli.__init__(self)
        print("kopek olusturuldu")
    def havla(self):
        print("hav hav")

kopegim=Kopek()
kopegim.nefes_al()
kopegim.havla()