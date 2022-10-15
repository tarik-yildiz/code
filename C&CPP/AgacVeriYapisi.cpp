#include <iostream>
using namespace std;
class MyBinaryTree {
public:
	struct AgacDugum {
		int veri;
		AgacDugum* sol;
		AgacDugum* sag;
	};
	AgacDugum* kok;
	MyBinaryTree() {
		kok = NULL;
	}
	void dugumEkle(int);
};
void MyBinaryTree::dugumEkle(int sayi) {
	AgacDugum *yeni,//yeni dugumu isaret edecek
			  *dugum;//agaci dolasacak
	yeni = new AgacDugum;
	yeni->veri = sayi;
	yeni->sag = yeni->sol = NULL;
	if (!kok) {//agac bossa
		kok = yeni;
	}
	else {//kokun adresini agaci dolasacak isaretciye atadık.
		dugum = kok;
		while (dugum != NULL) //agacta dugum bulundugu surece
		{
			if (sayi<dugum->veri) {
				if (dugum->sol!=NULL)
					dugum = dugum->sol;
				else
				{
					dugum->sol = yeni;
					break;
				}
			}
			else if (sayi > dugum->veri) {
				if (dugum->sag != NULL) 
					dugum = dugum->sag;
				else {
					dugum->sag = yeni;
					break;
				}
			}
			else
			{
				cout << "Agacta deger 2 defa bulundu." << endl;
				break;
			}
		}
	}
}
int main()
{
	MyBinaryTree me;
	me.dugumEkle(3);
	me.dugumEkle(5);
	me.dugumEkle(5);
	me.dugumEkle(7);
	me.dugumEkle(2);
	me.dugumEkle(3);
}

