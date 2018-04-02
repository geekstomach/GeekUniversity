package Lesson2;

import java.util.Arrays;

public class Lasson2DZ {
    public static void main(String[] args) {

        massZeroOne();
        increaseForThree();
        ifLess();
        squareArray();
        minMaxArr();
        testLeftRight();

        int arrToShift[] = {1, 2, 3, 4, 5};
        int n = -2;
        arrayShift(arrToShift, n);

        bubbleMethod();
    }


    public static void massZeroOne() {
        int massZeroOne[] = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < massZeroOne.length; i++) {
            if (massZeroOne[i] == 1) {
                massZeroOne[i] = 0;
            } else {                 // не понял как без else обойтись
                massZeroOne[i] = 1;
            }
        }
        System.out.println(Arrays.toString(massZeroOne));  // что такое import java.util.Arrays; и почему без него не работает?
        // Сначала написал System.out.println (massZeroOne.toString()); и выводилась всякая билиберда ([I@50cbc42f) как это сработало?
    }

    public static void increaseForThree() {
        int[] massIFT = new int[8];
        for (int i = 0, j = 0; i < massIFT.length; i++, j = j + 3) {
            massIFT[i] = j;

        }
        System.out.println(Arrays.toString(massIFT));
    }

    public static void ifLess() {
        int ifLess[] = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < ifLess.length; i++) {
            if (ifLess[i] < 6) {
                ifLess[i] = ifLess[i] * 2;
            }
        }
        System.out.println(Arrays.toString(ifLess));
    }

    public static void squareArray() {
        int square[][] = new int[5][5];
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[i].length; j++) { //можно сделать оним циклом , с двумя управляющими переменными
                if ((i == j) || (i == square.length - j - 1)) {    //сам не понял почему так(
                    square[i][j] = 1;

                }
                System.out.print((square[i][j]) + " ");
            }
            System.out.println();
        }

    }

    public static void minMaxArr() {

        int LOST[] = {4, 8, 15, 16, 23, 42};
        //  int LOST[] = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        //  int LOST[] = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        int MAX = LOST[0];
        int MIN = LOST[0];
        for (int i = 0; i < (LOST.length - 1); i++) {
            if (MAX < LOST[i + 1]) {                // можно ли как записать короче?
                MAX = LOST[i + 1];
            }
            if (MIN > LOST[i + 1]) {
                MIN = LOST[i + 1];
            }
        }
        System.out.println("Максимальный элемент массива - " + MAX + "\n" + "Минимальный элемент массива - " + MIN);
    }


    public static void testLeftRight() {
        int arr1[] = {1, 1, 1, 2, 1};
        int arr2[] = {2, 1, 1, 2, 1};
        int arr3[] = {10, 10};
        int arr4[] = {4, 1, 1, 1, 1};

        System.out.println(leftRight(arr1));
        System.out.println(leftRight(arr2));
        System.out.println(leftRight(arr3));
        System.out.println(leftRight(arr4));
    }

    public static boolean leftRight(int LeftRight[]) {
        // int LeftRight[] = {4, 8, 15, 16, 23, 42};
        int left = 0, right = 0;
        for (int i = 0; i < LeftRight.length; i++) {
            left = LeftRight[i] + left;
            right = 0;
            for (int j = (LeftRight.length - 1); j > i; j--) {
                right = LeftRight[j] + right;
            }
            if (left == right) {
                break;
            }
        }
        if (left == right) {
            return true;
        } else {
            return false;
        }
    }

    public static void arrayShift(int[] arrToShift, int n) {

        System.out.println(Arrays.toString(arrToShift));
        System.out.println("Сдвигаем на " + n);
        if (n >= 0) {
            for (int i = 0; i < n; i++) {
                int iLast = arrToShift.length - 1;
                int last = arrToShift[iLast];

                for (int j = iLast; j > 0; j--) {
                    arrToShift[j] = arrToShift[j - 1];
                }
                arrToShift[0] = last;
            }
        } else {               // можно было сделать с одним циклом
            for (int i = 0; i > n; i--) {
                int first = arrToShift[0];
                int iLast = arrToShift.length - 1;

                for (int j = 0; j < iLast; j++) {
                    arrToShift[j] = arrToShift[j + 1];
                }
                arrToShift[iLast] = first;
            }
        }
        System.out.println(Arrays.toString(arrToShift));

    }
      /*  Сделать сортировку пузырьком одномерного массива
        {6,5,1,3,9}
        Результат
        {1,3,5,6,9}*/

    public static void bubbleMethod() {
        int arrToBubble[] = {6, 5, 1, 3, 9, 2, 3, 4, 5, 6, 7, 8, 9, 0, -22, -5, -5, -6};
        System.out.println(Arrays.toString(arrToBubble));
  /*
    int n=1;
    for (int j = 0; j < n ; j++) {          //много лишних срабатываний цикла( не успел додуматься как это реализовать(
n--;
        for (int i = 0; i < (arrToBubble.length - 1); i++) {
            if (arrToBubble[i] > arrToBubble[i + 1]) {
                int temp = arrToBubble[i + 1];
                arrToBubble[i + 1] = arrToBubble[i];
                arrToBubble[i] = temp;
                n++;
            }
        }
    }
*/
        int count;
        do {
            count = 0;

            for (int i = 0; i < (arrToBubble.length - 1); i++) {
                if (arrToBubble[i] > arrToBubble[i + 1]) {
                    int temp = arrToBubble[i + 1];
                    arrToBubble[i + 1] = arrToBubble[i];
                    arrToBubble[i] = temp;
                    count++;// как только пройдет цикл в котором count не разу не увеличится все закончится
                }
            }

        }while (count > 0) ;
        System.out.println(Arrays.toString(arrToBubble));
    }
}