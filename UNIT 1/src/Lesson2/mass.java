package Lesson2;

public class mass {
    public static void main(String[] args) {

 /*       // МАССИВЫ!!!!
        int[] mass = new int[5]; //массив из integer
        // размерность нужно задавать сразу ОГРАНИЧЕНИЕ!
        // изначально там хранится 0 или null если String
        // номера ячеек начинается с 0
        // заполнение массива 1
        mass[0] = 1;
        mass[1] = 2;
        mass[2] = 3;
        mass[3] = 4;
        mass[4] = 5;
        // заполнение массива 2

        for (int i = 0; i < mass.length; i++){
            mass [i] = i;
            System.out.println(mass[i]);
        }
        // заполнение массива 3

        String[] mass1 = {"str1","str2","str3"};
        for (String o: mass1) {
            System.out.println(o);
        }
System.out.println(Arrays.toString(mass1));
*/

        // Двумерные массивы
        int [][] mass2 = new int[3][5]; // первые строки вторые столбцы (двумерный массив это массив массивов)
        // и по сути не бывает многомерных массивов. бывают массивы в массивах.
        int count = 1;
        for (int i = 0; i < mass2.length; i++) {
            for (int j = 0; j < mass2[i].length ; j++) {
                mass2[i][j] =count;
                System.out.print(mass2[i][j]+" ");
                count++;
            }
            System.out.println("");
        }


        int mass3 [][] = {{1,2,3},{1,2,3,4,5,6,7},{1,2,3,4}}; // размерность вложенных массивов может быть разной
        for (int i = 0; i < mass3.length; i++) {
            for (int j = 0; j < mass3[i].length ; j++) {

                System.out.print(" Основной массив "+ mass3.length);
                System.out.print(" Вложенный массив " + mass3[i].length);

            }
            System.out.println("");
        }
    }







}
