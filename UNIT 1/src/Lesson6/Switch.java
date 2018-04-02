package Lesson6;

import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int price = sc.nextInt();
        double lastPrice, sail;

int saleCase;
if (price>=100&&price<1000){
    saleCase = 1;
} else {
    if (price>=1000&&price<10000) {saleCase = 2;
    } else {
        saleCase = 3;
    }
}

        switch (saleCase){
            case 1:
                sail= 0.95;

                break;
            case 2:
                sail= 0.9;

                break;
            case 3:
                sail = 0.85;
                break;
            default:
                sail = 1;

        }
        lastPrice = price * sail;
int sailInPersent = (int) ((100 - sail*100));
        System.out.println("Ваша цена составит - "+ lastPrice+"c учетом скидки " + sailInPersent+ " процентов.");
    }
}
