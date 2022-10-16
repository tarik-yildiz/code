package com.bolum14;

import java.io.*;
import java.util.ArrayList;

public class NesneYazdrmak {
    public static void main(String[] args) {
        nesneYazdir();
        nesneOku();
        //arraylist Yazdirmak
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(12, "AM", false));
        students.add(new Student(123, "dAM", false));
        students.add(new Student(122, "cAM", true));
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("listeYazmak.txt")))) {
            objectOutputStream.writeObject(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Arraylist Okumak
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream("listeYazmak.txt")))) {
            ArrayList<Student> listem = (ArrayList<Student>) objectInputStream.readObject();
            System.out.println(listem);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void nesneOku() {
        boolean satirSonu = false;

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream("Ogrenciler.txt")))) {
            while (!satirSonu) {
                try {
                    Student ogrenci = (Student) objectInputStream.readObject();
                    System.out.println(ogrenci);
                } catch (EOFException e) {
                    satirSonu = true;
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    private static void nesneYazdir() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("Ogrenciler.txt")))) {
            objectOutputStream.writeObject(new Student(1, "Tarik", true));
            objectOutputStream.writeObject(new Student(2, "Hasan", false));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Student implements Serializable {//serializable interface'i classtan olusturulan nesnelerin dosyaya yazdırılabilecegini soyler.
    int id;
    String isim;
    boolean aktif;
    private final long serialVersionUID = 1L;//bu serializable ile alakali bir sey

    public Student(int id, String isim, boolean aktif) {
        this.id = id;
        this.isim = isim;
        this.aktif = aktif;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", isim='" + isim + '\'' +
                ", aktif=" + aktif +
                '}';
    }
}
