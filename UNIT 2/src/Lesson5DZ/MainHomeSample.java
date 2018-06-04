package Lesson5DZ;

import java.util.Arrays;
// Здесть я отрабатывал всякие вопросы.
public class MainHomeSample {
    //Задаем исходные данные для массивов
    static final int size = 10_000_000;
    static final int h = size / 2;
    private static float[] arr1;
    private static float[] arr2;
//Создаем первый метод который просто бежит по массиву и вычисляет значения.
    public void createArrayOne(){
//Создаем массив развера size(зачем float?)
        float[] arr = new float[size];
        //Заполняем массив единицами

        for (int i = 0; i <arr.length ; i++) {
            arr[i] = 1;

        }
        //Засекаем время выполнения
        long a = System.currentTimeMillis();
        for (int i = 0; i <arr.length ; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
       // printArr(arr);
        System.out.print((System.currentTimeMillis() - a)+" ");
        arr1 = arr;


   }
    //Создаем второй метод который разбивает массив на два массива,
    //в двух потоках высчитывает новые значения и потом склеивает
    //эти массивы обратно в один.
    public void createArrayTwo () throws InterruptedException {
//Создаем массив развера size(зачем float?)
        float[] arr = new float[size];
        //Заполняем массив единицами
        for (int i = 0; i <arr.length ; i++) {
            arr[i] = 1;

        }
        // Засекаем время выполнения
        long a = System.currentTimeMillis();

        float[] arrFirstHalf = new float[size];
        float[] arrSecondHalf = new float[size];
System.arraycopy(arr,0, arrFirstHalf, 0,h);
System.arraycopy(arr,h, arrSecondHalf, 0,h);
//printArr(arrFirstHalf);
       // System.out.println(arrFirstHalf.length);
//printArr(arrSecondHalf);
       // System.out.println(arrSecondHalf.length);
        Thread threadFirstHalf = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <h ; i++) {
                    //System.out.print(arrFirstHalf[i]+" ");
                    arrFirstHalf[i] = (float)(arrFirstHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                   // System.out.print(arrFirstHalf[i]+" ");
                }
            }
        });
       // System.out.println();
        Thread threadSecondHalf = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = h; i <arr.length ; i++) {
                 //   System.out.print(arrSecondHalf[i]+" ");
                    arrSecondHalf[i-h] = (float)(arrSecondHalf[i-h] * Math.sin(0.2f + i/ 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                  //  System.out.print(arrSecondHalf[i]+" ");
                }
            }
        });
       threadFirstHalf.start();
    /*    try {
            threadFirstHalf.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        threadSecondHalf.start();

  //     try {
           threadFirstHalf.join();
            threadSecondHalf.join();
    //    } catch (InterruptedException e) {
   //         e.printStackTrace();
  //      }

      //  printArr(arrFirstHalf);
      //  printArr(arrSecondHalf);
        System.arraycopy(arrFirstHalf,0, arr, 0,h);
        System.arraycopy(arrSecondHalf,0, arr, h,h);
      //  printArr(arr);
        System.out.print((System.currentTimeMillis() - a)+" ");
        arr2 = arr;

        }

    public static void main(String[] args) throws InterruptedException {
        MainHomeSample mainHomeSample = new MainHomeSample();
        for (int i = 0; i <100 ; i++) {


        mainHomeSample.createArrayOne();
        mainHomeSample.createArrayTwo();
        //System.out.println(arr1.equals(arr2));
        System.out.print(Arrays.equals(arr1,arr2));
            System.out.println();
        //System.out.println(arr1==arr2);
       // printArr(arr1);
       // System.out.println(arr1.length);
       // printArr(arr2);
       // System.out.println(arr2.length);
        }
    }
public static void printArr(float[] arr){
    for (int i = 0; i <arr.length ; i++) {
        System.out.print(arr[i]+" ");
            }
    System.out.println();
}

}
//Если просто засекать два одинаковых метода то получается
//1454
//1280
//Примерно всегда около этого