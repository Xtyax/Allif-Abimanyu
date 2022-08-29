package RentalMobil;

import java.util.Scanner;

public class menuMain {

    static Scanner input = new Scanner(System.in);
    
    static void menu(){
        
    }

    static String pilihan() {
        String answer;
        System.out.print("\n Anda Ingin Lanjut (Y/N)?");
        answer = input.next().toUpperCase();
        if (answer.equals("N")) {
            System.out.println("------------------------------------------------\n");
            menu();
        }
        return answer;
    }

    public static void main(String[] args) {
        String answr;

        Scanner input = new Scanner(System.in);
        StackDinamisObject sdo = new StackDinamisObject();
        System.out.println("Selamat Datang Dirental Mobil");

        sdo.push(new Mobil("Avanza", 1, 300000));
        sdo.push(new Mobil("Brio", 1, 275000));
        sdo.push(new Mobil("Xpander", 1, 300000));
        sdo.push(new Mobil("Agya", 1, 200000));

        System.out.println(sdo.toString());
        
        if (sdo.pop() == null) {
            System.out.println("data sudah habis");
        } else {
            System.out.println("Ukuran : " + sdo.size() + " => \n" + sdo.toString()); 
        }

        if (sdo.pop() == null) {
            System.out.println("data sudah habis");
        } else {
            System.out.println("Ukuran : " + sdo.size() + " => \n" + sdo.toString()); 
        }

        if (sdo.pop() == null) {
            System.out.println("data sudah habis");
        } else {
            System.out.println("Ukuran : " + sdo.size() + " => \n" + sdo.toString()); 
        }

        if (sdo.pop() == null) {
            System.out.println("data sudah habis");
        } else {
            System.out.println("Ukuran : " + sdo.size() + " => \n" + sdo.toString()); 
        }
    }

}
