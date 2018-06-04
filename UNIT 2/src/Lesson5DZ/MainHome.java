package Lesson5DZ;

public class MainHome {
    //Задаем исходные данные для массивов
    private static final int size = 10_000_000;
    private static final int h = size / 2;

//Создаем первый метод который просто бежит по массиву и вычисляет значения.
private static void createArrayOne(){
//Создаем массив развера size
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
//выводим время окончания
        System.out.println((System.currentTimeMillis() - a));

   }
    //Создаем второй метод который разбивает массив на два массива,
    //в двух потоках высчитывает новые значения и потом склеивает
    //эти массивы обратно в один.
    private static void createArrayTwo() {
//Создаем массив развера size
        float[] arr = new float[size];
        //Заполняем массив единицами
        for (int i = 0; i <arr.length ; i++) {
            arr[i] = 1;
        }

        float[] arrFirstHalf = new float[h];
        float[] arrSecondHalf = new float[h];

        // Засекаем время выполнения
        long a = System.currentTimeMillis();
// Делим один массив на два
        System.arraycopy(arr,0, arrFirstHalf, 0,h);
        System.arraycopy(arr,h, arrSecondHalf, 0,h);

//создаем новый поток, и прописываем метод Run
        Thread threadFirstHalf = new Thread(() -> {
            for (int i = 0; i <h ; i++) {
                arrFirstHalf[i] = (float)(arrFirstHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
//создаем новый поток, и прописываем метод Run
        Thread threadSecondHalf = new Thread(() -> {
            for (int i = h; i <arr.length ; i++) {
                arrSecondHalf[i-h] = (float)(arrSecondHalf[i-h] * Math.sin(0.2f + i/ 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        // запускаем потоки
        threadFirstHalf.start();
        threadSecondHalf.start();
//Используем метод join(), чтобы главный поток подождал завершения наших потоков
        try {
           threadFirstHalf.join();
            threadSecondHalf.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//склеиваем массивы обратно
        System.arraycopy(arrFirstHalf,0, arr, 0,h);
        System.arraycopy(arrSecondHalf,0, arr, h,h);
//выводим время окончания
        System.out.print((System.currentTimeMillis() - a));
        }

    public static void main(String[] args) {

        createArrayOne();
        createArrayTwo();

        }
}
