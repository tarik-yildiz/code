metin="# Television v0.1 #"
power_status_str="# Power: "
power=0
channel_status_str="# Channel: "
channel=0
volume_status_str="# Volume: "
volume=0
choice=-2
dies="#"*len(metin)
ch1="# 1-) ON/OFF"
ch2="# 2-) CH++"
ch3="# 3-) CH--"
ch4="# 4-) VOL++"
ch5="# 5-) VOL--"
power_off_text=dies+"\n"\
               +metin+"\n"\
               +power_status_str+ "OFF\n"\
               +channel_status_str+"TV is off\n"\
               +volume_status_str+"TV is off\n" \
               + dies + "\n" \
               +ch1+"\n"\
               +ch2+"\n"\
               +ch3+"\n"\
               +ch4+"\n"\
               +ch5+"\n"\
               +dies
power_on_text=dies+"\n"\
               +metin+"\n"\
               +power_status_str+"ON\n"\
               +channel_status_str+str(channel)+"\n"\
               +volume_status_str+str(volume)+"\n"\
                +dies+"\n"\
               +ch1+"\n"\
               +ch2+"\n"\
               +ch3+"\n"\
               +ch4+"\n"\
               +ch5+"\n"\
               +dies
while choice!=-1 :
    power_on_text = dies + "\n" \
                    + metin + "\n" \
                    + power_status_str + "ON\n" \
                    + channel_status_str + str(channel) + "\n" \
                    + volume_status_str + str(volume) + "\n" \
                    + dies + "\n" \
                    + ch1 + "\n" \
                    + ch2 + "\n" \
                    + ch3 + "\n" \
                    + ch4 + "\n" \
                    + ch5 + "\n" \
                    + dies
#iki turlu de string hazirlayabilirsin. bence 2. daha kolay...
    power_on_text2 = "{}\n{}\n{} ON\n" \
                     "{}{}\n{}" \
                     "{}\n{}\n{}\n" \
                     "{}\n{}\n{}\n" \
                     "{}\n{}".format(dies,
                                        metin,
                                        power_status_str,
                                        channel_status_str,str(channel),
                                        volume_status_str,str(volume),
                                        dies,ch1,ch2,ch3,ch4,ch5,
                                        dies)

    if power==0:
        print(power_off_text)
    else:
        print(power_on_text2)
    choice=int(input("= "))
    if power==1:
        if choice==1:
            power=0
        if choice==2:
            channel+=1
        if choice==3:
            channel-=1
        if choice==4:
            volume+=1
        if choice==5:
            volume-=1
    elif power==0:
        if choice==1:
            power=1