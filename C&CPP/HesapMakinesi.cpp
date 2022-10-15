
#include <stdio.h>
int main()
{
	int secim;
	float num1, num2;
	while(true){

		printf("1- Toplama\n");
		printf("2- Cikarma\n");
		printf("3- Carpma\n");
		printf("4- Bolme\n");
		printf("0- Cikis\n");
		scanf_s("%d", &secim);
		if (secim == 0) {
			printf("Cikis yaptiniz...");
			break;
		}
		else if (secim==1)
		{
			printf("Toplama-> 1.sayiyi giriniz: ");
			scanf_s("%f", &num1);
			printf("Toplama-> 2.sayiyi giriniz: ");
			scanf_s("%f", &num2);
			printf("sonuc: %f\n",num1+num2);
		}
		else if (secim==2)
		{
			printf("Cikarma-> 1.sayiyi giriniz: ");
			scanf_s("%f", &num1);
			printf("Cikarma-> 2.sayiyi giriniz: ");
			scanf_s("%f", &num2);
			printf("sonuc: %f\n", num1 - num2);
		}
		else if (secim == 3) {
			printf("Carpma-> 1.sayiyi giriniz: ");
			scanf_s("%f", &num1);
			printf("Carpma-> 2.sayiyi giriniz: ");
			scanf_s("%f", &num2);
			printf("sonuc: %f\n", num1 * num2);

		}
		else if (secim == 4) {
			printf("Bolme-> 1.sayiyi giriniz: ");
			scanf_s("%f", &num1);
			printf("Bolme-> 2.sayiyi giriniz: ");
			scanf_s("%f", &num2);
			printf("sonuc: %f\n", num1 / num2);
		}
		else {
			printf("Yanlis secim\n");
		}
	}
}
