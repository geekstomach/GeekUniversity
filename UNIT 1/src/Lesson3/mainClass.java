package Lesson3;

import java.util.Arrays;
import java.util.Random;

public class mainClass {
    public static void main(String[] args) {
/*int a = 1;
        System.out.println(a);
        inttest(a);
        System.out.println(a);
        int [] mass  = {1,2,3,4,5};
        System.out.println(Arrays.toString(mass));
        massTest(mass);
        System.out.println(Arrays.toString(mass));*/
        Random random = new Random();
        String colors[] = {"Red","Green","Yellow","Orange"};
        int pos = random.nextInt(colors.length);
        System.out.println(colors[pos]);

int [] mass = getRandomNumber();    // бывает SecureRandom
System.out.println(Arrays.toString(mass));
    }
    static void inttest (int a){
        a++;
    }
    static void StrintTest (String str){
        str = str+"1";
    }
    static void massTest (int[] mass){
        mass[2]=55;
    }


    static int [] getRandomNumber() {
        int [] mass = new int[6];

        for (int i = 0; i <mass.length ; i++) {
            Random random = new Random();
            mass[i] = random.nextInt(48)+1;
        }
        return mass;
    }

         static void strTest(String str) {
        System.out.println(str);
    }// перегрузка методов (ачем нужна)
        static void strTest (int s,int a) {
        System.out.println(s+" "+a);
}
}
