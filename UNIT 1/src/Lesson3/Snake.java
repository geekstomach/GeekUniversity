package Lesson3;

import java.util.Arrays;
import java.util.Scanner;

public class Snake {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите два числа, которые задают размерность матрицы");
        int iL , jL;
        do {
            System.out.println("Введите количество строк, в пределах от 5 до 20");
            iL = sc.nextInt();
        } while (iL<=5||iL>=20);
        do {
            System.out.println("Введите количество столбцов, в пределах от 5 до 20");
            jL = sc.nextInt();
        } while (jL<=5||jL>=20);

//int iL = 3;
//int jL = 3;  //не успел доразобраться не работает при занчениях 1.1 3.3 5.5 7.7 9.9
        int[][] arr = new int[iL][jL];



int i = 0;
int j = 0;
        int k = 0;
        int count = 0;
        int maxCount = (arr.length*arr[i].length);
do {
        for (j = k; j < arr[i].length - k - 1; j++) {
            arr[i][j] = count;                         // Верхяя строчка
            count++;
            if (count >= maxCount) {break;}
        }

        for (i = k; i < arr.length - 1 - k; i++) {
            arr[i][j] = count;                         // Правая строчка
            count++;
            if (count >= maxCount) {break;}
        }
        for (j = arr[i].length - 1 - k; j > k; j--) {
            arr[i][j] = count;                         // Нижняя строчка
            count++;
            if (count >= maxCount) {break;}
        }
        for (i = arr.length - 1 - k; i > k; i--) {
            arr[i][j] = count;                         // Левая строчка
            count++;
            if (count >= maxCount) {break;}
        }
        if (count >= maxCount) {break;}
      //    System.out.println(Arrays.deepToString(arr));
        i++;
        k++;}while (count != maxCount);

        //System.out.println(Arrays.deepToString(arr));
        for (int l = 0; l < arr.length; l++) {
            System.out.println(Arrays.toString(arr[l]));

        }

        }




}
/*
1 С консоли внести два целоцисленных числа (в границах от 5 до 20)
        2 Создать матрицу с указанной размерностью
        3 Заполнить матрицу по спирали (числа увеличиваются на 1)*/
