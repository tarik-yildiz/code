import socket


target_h="www.google.com"
target_p=80

client=socket.socket(socket.AF_INET,socket.SOCK_STREAM)

client.connect((target_h,target_p))

client.send("GET / HTTP/1.1\r\nHost: google.com\r\n\r\n")

response=client.recv(4096)
print(response)

#############
# UDP CLIENT

import socket
target_h="127.0.0.1"
target_p=80
client= socket.socket(socket.AF_INET,socket.SOCK_DGRAM)

#send some data
client.sendto("AAABBBCCC",(target_h,target_p))
#receive some data
data, addr=client.recvfrom(4096)
print(data)

##########
#TCP SERVER KURMA
import socket
import threading
bind_ip="0.0.0.0"
bind_port=9999
server=socket.socket(socket.AF_INET,socket.SOCK_STREAM)
server.bind((bind_ip,bind_port))
server.listen(5)
print "[*] listening on %s:%d" % (bind_ip,bind_port)
#this is our client-handling thread
def handle_client(client_socket):
    #print out what the client sends
    request=client_socket.recv(1024)

    print "[*] Received: %s "% request
    #send back packet
    client_socket.send("ACK!")
    client_socket.close()

while True:
    client,addr=server.accept()
    print "[*] Accepted connection from: %s:%d" % (addr[0],addr[1])

    #spin up our client thread to  handle incoming data
    client_handler=threading.Thread(target=handle_client,args=(client,))
    client_handler.start()