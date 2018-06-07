package lesson4DZ;
/*1. Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз. Порядок должен быть именно таким:
        ABСABСABС. Используйте wait/notify/notifyAll.*/


public class threeThreads {
    static final Object object = new Object();
    static boolean[] booleans = {true,false,false};
    public static void main(String[] args) {


       // System.out.println("Запуск основного потока");
        //сначала создаем объект типа threadA
        ThreadA threadA = new ThreadA();
        //затем формируем поток на основе этого объекта
        Thread tA = new Thread(threadA);
        ThreadB threadB = new ThreadB();
        Thread tB = new Thread(threadB);
        ThreadC threadC = new ThreadC();
        Thread tC = new Thread(threadC);

       // System.out.println("Запуск потока А");
        //запускаем выполнение потока
        tA.start();
      //  System.out.println("Запуск потока В");
        tB.start();
       // System.out.println("Запуск потока С");
        tC.start();
    }

    //создаем класс с реализацией интерфейса Runnable(самы простой способ создания потока), также позволяет классу наследоваться
    static class ThreadA implements Runnable{

        @Override
       public void run() {
            for (int i = 0; i < 5; i++) {
                synchronized (object){
                    try {
                        while (!booleans[0]) object.wait();

                        System.out.print("A");

                        booleans[0] = false;
                        booleans[1] = true;

                        object.notifyAll();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        }
        }
    }



    //расширение класса Thread(необходимо если требуется дополникь подкласс новыми функциями), не позволяет классу наследоваться
    static class ThreadB implements Runnable{

        @Override
      public void run() {
            for (int i = 0; i <5 ; i++) {
                synchronized (object){
                     try {
                    while (!booleans[1]) object.wait();

                    System.out.print("B");

                    booleans[1]=false;
                    booleans[2]=true;

                    object.notifyAll();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        }

    static class ThreadC implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                synchronized (object) {
                    try {

                        while (!booleans[2]) object.wait();

                        System.out.print("C");

                        booleans[2] = false;
                        booleans[0] = true;

                        object.notifyAll();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }

    }
}
