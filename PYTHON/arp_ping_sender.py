import argparse
import scapy.all as scapy

class ARPPing():
    def __init__(self):
        print("ARPPing started")
    def get_input(self):
        parser = argparse.ArgumentParser()
        parser.add_argument('-i','--ipaddress', type=str, help="ip address gir")
        args= parser.parse_args()
        if args.ipaddress != None:
            return args
        else:
            print("IP ALINAMADI")
    def arp_istegi(self,ip):

        #scapy kutuphanesini kullanicaz. cok onemli.
        arp_req_packet=scapy.ARP(pdst=ip)
        broadcast_packet=scapy.Ether(dst="ff:ff:ff:ff:ff:ff")
        combined_packet=broadcast_packet/arp_req_packet
        answered_list, unanswered_list = scapy.srp(combined_packet, timeout=1)
        answered_list.summary()

if __name__=="__main__":
    arp=ARPPing()
    kullanici_girdisi=arp.get_input()
    arp.arp_istegi(kullanici_girdisi.ipaddress)