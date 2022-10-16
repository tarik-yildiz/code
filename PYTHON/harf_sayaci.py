a="pijamali hasta yağız şoföre çabucak güvendi"

adet=0
alfabe="abcçdefgğhıijklmnoöprsştuüvyz"
for i in alfabe:
    for j in a:
        if i==j:
            adet+=1

    print("[", i, "] harfinden [", adet, "] kadar var")
    adet=0
