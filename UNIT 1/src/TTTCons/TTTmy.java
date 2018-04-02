package TTTCons;


import java.util.Random;
import java.util.Scanner;

public class TTTmy {
    public static int numOfCheckX = 5;
    public static int numOfCheckY = 5;
    public static int marksForWin = 4;
    public static char[][] playField;
    public static char emptyCheck ='□';
    public static char playersMark = '☻';
    public static char computersMark = '☺';

    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();



    public static void main(String[] args) {
initField();
printField();
for (int i = 0; i < marksForWin-1; i++) {
    playersTurn();
    printField();
    computersTurn();
    printField();
}

while(true) {
    playersTurn();
    printField();
    if (checkWin(playersMark)) {
        System.out.println("Вы победили!");
        break;
    }
    if (isFieldFull()) {
        System.out.println("Ничья.");
        break;
    }
    computersTurn();
    printField();
    if (checkWin(computersMark)){
        System.out.println("Вы проиграли!");
        break;
    }
    if (isFieldFull()) {
        System.out.println("Ничья.");
        break;
    }

}
        System.out.println("Игра закончена.");

    }
    public static void initField(){
playField = new char[numOfCheckY][numOfCheckX];
        for (int i = 0; i < numOfCheckY ; i++) {
            for (int j = 0; j <  numOfCheckX ; j++) {
                playField[i][j] =emptyCheck;
            }
        }
    }
     public static void printField(){

         System.out.print(" ");
         for (int i = 1; i <numOfCheckX+1; i++) {
             System.out.print(i + "  ");
         }
         System.out.println();
         for (int i = 0; i < numOfCheckY ; i++) {
             System.out.print((i+1) + " ");
             for (int j = 0; j <  numOfCheckX ; j++) {
                 System.out.print(playField[i][j]+ " ");

             }
             System.out.println();
         }

     }
     public static void fillCheck(int x, int y,char sym){
        playField[y][x] = sym;
     }
     public static void playersTurn(){
         System.out.println("Введите координаты в формате X Y");
         int x, y;
         do {
         x = sc.nextInt()-1;
         y = sc.nextInt()-1;

    if (!isCheckEmpty(x, y) == true){
        System.out.println("Возможно поле занято\nВведите корректные значения координтат");
    }
}while (!isCheckEmpty(x, y) == true);
        // playField[y][x] = playersMark;
         fillCheck(x,y,playersMark);
     }
     public static boolean isCheckEmpty(int x, int y){
        // проверяем лежат ли в пределах поля введенные игроком значения
        if ((x < 0 || x >= numOfCheckX)||(y < 0 || y >= numOfCheckY)){return false;}

         // проверяем пустое ли поле
        if (playField[y][x] == emptyCheck) {

            return true;
        }
         return false;
     }
    public static void computersTurn() {
        int x, y;
        do {
            x = rand.nextInt(numOfCheckX) - 1;
            y = rand.nextInt(numOfCheckY) - 1;

        } while (!isCheckEmpty(x, y) == true);
        System.out.println("Ход компьютера - "+(x+1)+" "+(y+1));
        fillCheck(x,y,computersMark);
    }

    public static boolean checkWin(char point) {



      for (int i = 0; i <numOfCheckX ; i++) {
            for (int j = 0; j <numOfCheckY ; j++) {
                int count1 = 0;
                int count2 = 0;
                int count3 = 0;
                int count4 = 0;
        for (int m = 0; m <marksForWin; m++) {

           if ((i + m)<numOfCheckX) {
           if ((playField[i + m][j]==point)&&((i + m)<numOfCheckX)){
               count1++;   //проверка по горизонтали
           }} //else {break;}

           if ((j + m) < numOfCheckX){
           if (playField[i][j+m]==point){
            count2++;    // проверка по вертикали
            }} //else {break;}

            if (((i + m)<numOfCheckX)&&((j + m)<numOfCheckX)){
            if (playField[i + m][j+m]==point){
                count3++; // проверка по диаганали вниз
            }} //else {break;}

           if (((i + m)<numOfCheckX)&&((j - m)>=0)) {
            if ((playField[i + m][j - m] == point)){
                count4++; // проверка по диаганали вверх
            }} //else {break;}

            if (count1==(marksForWin)||count2==(marksForWin)||count3==(marksForWin)||count4==(marksForWin)){
               return true;
            }
    }}}
    return false;}



    public static boolean isFieldFull(){
        for (int i = 0 ; i < numOfCheckX ; i ++){
            for (int j = 0; j <numOfCheckY ; j++) {
                if ( playField[i][j] == emptyCheck) return false;
            }
        }
        return true;
    }
}








//Старался но подглядывал(
//Почемуто подчеркивает красным все что связано со сканером.


/*
1. Полностью разобраться с кодом, попробовать переписать с нуля, стараясь не подглядывать в методичку;
        2. Переделать проверку победы, чтобы она не была реализована просто набором условий, например, с использованием циклов.
        3. * Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и количества фишек 4. Очень желательно не делать это просто набором условий для каждой из возможных ситуаций;
        4. *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.*/
