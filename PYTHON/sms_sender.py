import os
import platform
import requests
import time


def perday():
    resp = requests.\
        post('https://textbelt.com/text',
                         {'phone': phone_num,
                          'message': msg,
                          'key': 'textbelt', })
    print(resp.json())


def unlimited():
    resp = requests.\
        post('https://textbelt.com/text',
                         {'phone': phone_num, 'message': msg,
                          'key': 'e1518e2265f09dc16a7b84aa320e418f4309b0acdw3sSg6DxDJOiPU6qbC8NsRaH', })
    print(resp.json())

if platform.system() == "Windows":
    os.system("cls")
else:
    os.system("clear")
print("""
1) One/SMS/PerDay
2) Unlimited/SMS""")
option = int(input())
if option == 1:
    if platform.system() == "Windows":
        os.system("cls")
    else:
        os.system("clear")
        phone_num = input("Enter your phone number : ")
        msg = input("Enter your msg =  ")
        perday()
elif option == 2:
    if platform.system() == "Windows":
        os.system("cls")
    else:
        os.system("clear")
        phone_num = input("Enter your phone number : ")
        msg = input("Enter your msg =  ")
        unlimited()
        time.sleep(6)
