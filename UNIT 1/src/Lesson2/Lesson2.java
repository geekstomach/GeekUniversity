package Lesson2;

public class Lesson2 {
    public static void main(String[] args) {
  /*    char grade = 'D';

      switch (grade){ // может быть любым типом данных
          case 'A':
              System.out.println("A");
              break; // без break выполнится, кейс  продолжит выполнять остальные кейсы
          case 'B':
              System.out.println("B");
              break;
          case 'C':
              System.out.println("C");
              break;
          case 'D':
              System.out.println("D");
              break;
              default:
                  System.out.println("Неизвестно!");
                  // разница с иф элс стоставные условия
                  // используется когда нам нужен лакончиный понятный код.
*/

                  for (int i = 0, j = 10; i < 10; i++,j--) {
                      System.out.println(i+" "+j);
                  } // домашка с двумя управляющими переменными можно сделать

        for (int i = 0; i < 10; i++) {
                      if (i==5) {continue;} // пропускает данную иттерацию
                      if (i>6) {break;} // вместо 6 может быть некое значение вычисляемое в цыкле
            System.out.println(i);
        }
        // Вложенный цикл
        for (int i = 0; i <10 ; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println( i+" "+j);
            }
        }
// Работа с меткой
       marker1: for (int i = 0; i <10 ; i++) {
            for (int j = 0; j < 10; j++) {
                if (j==5) {
                //    continue; // только на цикл j
                    continue marker1; // не только на цикл j благодаря метке.
                    // также и с break
                }

                System.out.println( i+" "+j);
            }
        }
//
        for (int i = 0; i <10 ; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(0);
            }
        }

// циклы while и do while

 // МАССИВЫ!!!!
    int[] mass = new int[5];



      }
    }

