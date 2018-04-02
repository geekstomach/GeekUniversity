package Lesson1;

public class Lasson1DZ {
    public static void main(String[] args) {
        byte b1 = 1;
        short s = 2;
        int i = 3;
        long l = 4;

        float f = 2.2f;
        double d1 = 2.25;

        boolean bool = false;

        char c1 = '=';
        String S3 = ("Результат вычисляющий выражение a * (b + (c / d)) = ");
        String S4 = ("Сумма даух чисел ледит в пределах от 10 до 20 - ");
        //   String S6 = ("Число отрицательое вообщето ");
        System.out.println(S3 + dz1_3(2, 1, 4, 2));
        System.out.println(S4 + dz1_4(14, 3));
        dz1_5(8);
      //  System.out.println(S6 + dz1_6(14));
        System.out.println(dz1_6(-14)==true ? "Число отрицательное)" : "Число положительое)");
        dz1_7("Артем! Ты же проверяешь наши домашние задания?");
       // System.out.println(leapYear(2000));
        System.out.println(leapYear(2002)==true ? "Год оказался високосным)" : "Год оказался обычный таки)");
    }

    public static int dz1_3(int a3, int b3, int c3, int d3) {
        return a3 * (b3 + (c3 / d3));
    }

    public static boolean dz1_4(int a4, int b4) {
        if ((a4 + b4) > 9 && (a4 + b4) < 21) {
            return true;
        } else {
            return false;
        }
    }

    public static void dz1_5(int a5) {
        if (a5 > 0) {
            System.out.println("Число " + a5 + " положительное)");
        } else {
            System.out.println("Число " + a5 + " отрицательное)");
        }
    }

    public static boolean dz1_6(int a6) {
        if (a6 < 0) {
            return true;
        } else {
            return false;
        }
    }
    public static void dz1_7 (String S7){
        System.out.println("Привет, " + S7);
    }
    //год является високосным в двух случаях: либо он кратен 4, но при этом не кратен 100,
    // либо кратен 400. Год не является високосным, если он не кратен 4, либо он кратен 100,
    // но при этом не кратен 400.

    public static boolean leapYear (int year) {
/*        int leap1;
        leap1 = year % 4;
        int leap2;
        leap2 = year % 100;
        int leap3;
        leap3 = year % 400;
        if ((leap1==0&&leap2!=0)||(leap3==0)){
            return true;
        } else {           // Можно ли записать данное выражение без elsa и второго return?
            return false;
        }
        }*/

        return ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));

    }

}