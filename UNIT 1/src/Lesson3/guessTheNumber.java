package Lesson3;

import java.util.Random;
import java.util.Scanner;

public class guessTheNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int yes;
        do {
        guessTheNumber(random());
    System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");  //можно ли это реализовать отдельным методом?
    yes = sc.nextInt();
} while (yes!=0);
        System.out.println("До новых встреч!");
    }

    public static int random() {
        Random random = new Random();
        return random.nextInt(9);

    }

    public static void guessTheNumber(int i) {
        Scanner sc = new Scanner(System.in);
                System.out.println("Угадайте число от 0 до 9. У Вас есть 3 попытки)");
        int num = 0;
           for (int j = 2; j > -1; j--) {
               num = sc.nextInt();
               if (num > i) {
                   System.out.println("Указанное Вами число больше загаданного.\nУ Вас осталось " + j + " попыток!");
               } else {
                   if (num < i) {
                       System.out.println("Указанное Вами число меньше загаданного.\n У Вас осталось " + j + " попыток!");
                   } else {
                       if (num == i) {
                           System.out.println("Поздравляю)! Это победа!)");
                           break;
                       }
                   }
               }
           }
           if (i!=num){System.out.println("Вы проиграли,к сожалению( \nЗагаданное число было - "+i);}

    }

}

