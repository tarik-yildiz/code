#include<GL/glut.h>
#include<math.h>

int en = 300, boy = 300;
void CizimFonksiyonu(void);
void Ayarlar(void);
void GorunumAyari(int en, int boy);

void AltigenDeneme(void);
void NoktaCiz(void);
void CizgiCiz(void);
void IzgaraCiz(void);
void KoordinatCiz(void);
void UcgenCiz(void);
void CemberCiz(void);
void DaireCiz(void);
void CizgilerleUcgenCiz(void);
void DortgenPrizmaCiz(void);

int main(int argc, char **argv) {
	
	glutInit(&argc, argv); //GLUT YORDAMLARINI BASALTMAK
	glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB);//TEK TAMPON

	glutInitWindowPosition(100,100);// pencere konumu
	glutInitWindowSize(en,boy); //pencere boyutu

	glutCreateWindow("OPENGL WORKS");
	Ayarlar();
	glutReshapeFunc(GorunumAyari);
	glutDisplayFunc(CizimFonksiyonu);//pencere goruntuleme

	glutMainLoop();//akiskanlik icin dongu
	return 0;
}


void CizimFonksiyonu(void) 
{
	glClear(GL_COLOR_BUFFER_BIT);//glclearcolorun yaptigi isi siliyor
	glLoadIdentity();//donusum sorounu ıcın
	glTranslatef(0.0,0.0,-2.0);//kamera uzaklastirma
	//DortgenPrizmaCiz();
	AltigenDeneme();
	glFlush();//tek arabellekkte şeklin ekranda gorunmesi icin
}
void GorunumAyari(int en, int boy) {
	glViewport(0,0,en,boy);
	glMatrixMode(GL_PROJECTION);//izdusum gorunumu ayarlamak icin
	gluPerspective(90,en/boy,1,10);
	glMatrixMode(GL_MODELVIEW);
}

void Ayarlar(void)
{
	glClearColor(0, 1, 1, 1);//pencere arkaplan rengi
	glShadeModel(GL_FLAT);//tek rengin hakim olmasi
	glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);
}


void NoktaCiz(void) {
	glPointSize(8.0);
	glBegin(GL_POINTS);
	glVertex2f(0.5, 0.4);//ILK NOKTAMIZ
	glVertex2f(0.6, 0.6); //IKINCI NOKTAMIZ
	glEnd();
}
void CizgiCiz(void) {
	glLineWidth(2.0);//kalinlik degeri
	glBegin(GL_LINES); //cizgi cizmeye basla...
	glVertex2f(0.5, 0.8); //cizgi a noktasi
	glVertex2f(-0.5, 0.1); //cizgi b noktasi
	glEnd();
}
void IzgaraCiz(void) {
	int cizgiSayisi = 10;
	glLineWidth(2.0);//kalinlik degeri
	glBegin(GL_LINES); //cizgi cizmeye basla...
	for (int i = 0; i < cizgiSayisi; i++) {
		glVertex2f(1 - i * 0.2, 1);
		glVertex2f(1 - i * 0.2, -1);
	}
	for (int i = 0; i < cizgiSayisi; i++) {
		glVertex2f(1, 1 - i * 0.2);
		glVertex2f(-1, 1 - i * 0.2);
	}
	glEnd();
}
void KoordinatCiz(void) {
	glLineWidth(2.0);//kalinlik degeri
	glBegin(GL_LINES); //cizgi cizmeye basla...
	glVertex2f(0.0, -0.7);//birinci cizgi a noktasi
	glVertex2f(0.0, 0.7);//birinci cizgi b noktasi
	glVertex2f(0.7, 0.0);//ikinci cizgi a noktasi
	glVertex2f(-0.7, 0.0);//ikinci cizgi b noktasi
	glEnd();
}
void UcgenCiz(void) {
	glBegin(GL_TRIANGLES);//ucgen cizmek
	glColor3f(1.0, 0.0, 0.0);//rgb degerleri cizim rengi
	glVertex2f(-1.0, 0.0);
	glVertex2f(1.0, 0.0);
	glVertex2f(0.0, 1.0);
	glColor3f(0.0, 0.0, 1.0);//rgb degerleri cizim rengi
	glVertex2f(-1.0, 0.0);
	glVertex2f(1.0, 0.0);
	glVertex2f(0.0, -1.0);
	glEnd();
}
void CemberCiz(void) {
	int der = 0;
	float rad = 0;
	glBegin(GL_LINE_LOOP);/// yuvarlak cizer
	glLineWidth(10);
	for (der = 0; der < 360; der++) {
		rad = 2 * 3.14 * der / 360;
		glVertex2f(cos(rad) * 0.5, sin(rad) * 0.5);
	}
}
void DaireCiz(void){
	int der = 0;
	float rad = 0;
	//glBegin(GL_LINE_LOOP);/// yuvarlak cizer
	glBegin(GL_POLYGON);//daire cizer
	glLineWidth(10);
	for (der = 0; der < 360; der++) {
		rad = 2 * 3.14 * der / 360;
		glVertex2f(cos(rad)*0.5, sin(rad)*0.5);
	}
}
void AltigenDeneme(void) {
	glBegin(GL_LINES);//daire cizer
	glVertex2f(0.8,0.0);
	glVertex2f(0.8,0.4);
	glVertex2f(-0.8,0.4);
	glVertex2f(-0.8,0.0);
	glVertex2f(-0.8,-0.4);
	glVertex2f(0.8,-0.4);

	glEnd();
}
void CizgilerleUcgenCiz(void) {
	glBegin(GL_LINES); //cizgi cizme
	glVertex2f(1.0, 0.0);
	glVertex2f(0.0, 1.0);

	glVertex2f(0.0, 1.0);
	glVertex2f(-1.0, 0.0);

	glVertex2f(-1.0, 0.0);
	glVertex2f(1.0, 0.0);
	glEnd();
}
void DortgenPrizmaCiz(void) {
	glColor3f(1.0, 0.0, 0.5);
	glLineWidth(3);
	glRotatef(60, 0, 1, 0);
	glBegin(GL_QUADS);//onyuz
	glVertex3f(-0.8,0.6,0.2);
	glVertex3f(0.8,0.6,0.2);
	glVertex3f(0.8,-0.6,0.2);
	glVertex3f(-0.8,-0.6,0.2);
	glEnd();
	glBegin(GL_QUADS);//sol yan yuz
	glVertex3f(-0.8,0.6,-0.2);
	glVertex3f(-0.8,0.6,0.2);
	glVertex3f(-0.8,-0.6,0.2);
	glVertex3f(-0.8,-0.6,-0.2);
	glEnd();
	glBegin(GL_QUADS);//arka yuz
	glVertex3f(-0.8,0.6,-0.2);
	glVertex3f(0.8,0.6,-0.2);
	glVertex3f(0.8,-0.6,-0.2);
	glVertex3f(-0.8,-0.6,-0.2);
	glEnd();
	glBegin(GL_QUADS);//sag yan yuz
	glVertex3f(0.8,0.6,-0.2);
	glVertex3f(0.8,0.6,0.2);
	glVertex3f(0.8,-0.6,0.2);
	glVertex3f(0.8,-0.6,-0.2);
	glEnd();
	glBegin(GL_QUADS);//ust yuz
	glVertex3f(-0.8,0.6,0.2);
	glVertex3f(0.8,0.6,0.2);
	glVertex3f(0.8,0.6,-0.2);
	glVertex3f(-0.8,0.6,-0.2);
	glEnd();
	glBegin(GL_QUADS);//alt yuz
	glVertex3f(0.8,-0.6,0.2);
	glVertex3f(-0.8,-0.6,0.2);
	glVertex3f(-0.8,-0.6,-0.2);
	glVertex3f(0.8,-0.6,-0.2);
	glEnd();
}
