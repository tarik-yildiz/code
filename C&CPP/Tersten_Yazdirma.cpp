#include <iostream>
#include <fstream>
#include <string>
using namespace std;

void reverseStr(string& str)
{
    int n = str.length();
    for (int i = 0; i < n / 2; i++)
        swap(str[i], str[n - i - 1]);
}
int main()
{
    const char* DOSYA_KONUMU = "C:\\Users\\KULLANICI_ADI\\Desktop\\DOSYA.txt";
    const char* CIKTI_KONUMU = "C:\\Users\\KULLANICI_ADI\\Desktop\\TERSTEN_DOSYA.txt";
    fstream newfile;
    fstream secondfile;
    string temp;
    newfile.open(DOSYA_KONUMU, ios::in);
    if (newfile.is_open())
    {
        string tp;
        while (getline(newfile, tp)) {
            reverseStr(tp);
            temp += tp;
            temp += "\n";
        }

        newfile.close();
    }
    secondfile.open(CIKTI_KONUMU, ios::out);
    if (secondfile.is_open())
    {
        cout << "dosya basariyla tersten yazdirildi";
        secondfile << temp;
        secondfile.close();
    }


    else {
        cout << "hata verdi ";
    }
    getchar();
    return 0;
}
