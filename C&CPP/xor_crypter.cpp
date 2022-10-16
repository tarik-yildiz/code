#include <iostream>
#include <fstream>
#include <string>

using namespace std;
void menu();
void crypt_menu(int secim);
#define ENCRYPT 1
#define DECRYPT 2

int main(void)
{
	while (true)
	{
		menu();
		int secim = 0;
		cin >> secim;
		if (secim == 1 || secim == 2)
		{
			crypt_menu(secim);

		}
		else if (secim == 3) {
			cout << "Program bitti\n";
			break;
		}
		else
		{
			cout << "hatali secim\n";
		}

	}

}


void menu() {
	cout << "####################" << endl;
	cout << "#   {XOR CRYPTER}  #" << endl;
	cout << "####################" << endl;
	cout << "# 1- Dosya encrypt #" << endl;
	cout << "# 2- Dosya decrypt #" << endl;
	cout << "# 3- Cikis.        #" << endl;
	cout << "####################" << endl;
}
void crypt_menu(int secim) {
	string islem = "";
	switch (secim)
	{
	case ENCRYPT:
		islem = "ENCRYPT";
		break;
	case DECRYPT:
		islem = "DECRYPT";
		break;
	default:
		islem = "hata";
		break;
	}
	cout << "####################" << endl;
	cout << "#     {" << islem << "}    #" << endl;
	cout << "####################" << endl;
	cout << "Dosya konumu:";
	string dosya_konumu = "";
	if (secim == ENCRYPT) {
		cin >> dosya_konumu;
		ifstream dosyaOku(dosya_konumu);
		char karakter;
		string kelime;
		char xor_anahtar;
		if (dosyaOku.is_open()) {
			cout << "Lutfen sifrelemede kullanilacak anahtari giriniz:";
			cin >> xor_anahtar;

			while (dosyaOku.get(karakter)) {
				karakter ^= xor_anahtar;
				kelime += karakter;
			}
			dosyaOku.close();
			dosya_konumu += ".encrypted";
			ofstream dosya_yaz(dosya_konumu);
			dosya_yaz << kelime;
			dosya_yaz.close();
			cout << "Dosya sifrelendi.\n";
		}
		else {
			cout << "dosya acilamadi";
		}
	}
	else if (secim == DECRYPT) {
		cin >> dosya_konumu;
		ifstream dosyaOku(dosya_konumu);
		char karakter;
		string kelime;
		char xor_anahtar;
		if (dosyaOku.is_open()) {
			cout << "Lutfen sifre cozmede kullanilacak anahtari giriniz:";
			cin >> xor_anahtar;
			while (dosyaOku.get(karakter)) {
				karakter ^= xor_anahtar;
				kelime += karakter;
			}
			dosyaOku.close();
			dosya_konumu += ".decrypted";
			ofstream dosya_yaz(dosya_konumu);

			cout << "Dosyada gizlenen metin: " << kelime << endl;
			dosya_yaz << kelime;
			dosya_yaz.close();
			cout << "Dosya sifresi kirildi.\n";
		}
		else {
			cout << "dosya acilamadi";
		}
	}
}