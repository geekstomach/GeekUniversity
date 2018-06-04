package Lesson5;

public class Chairs {
    public static void main(String[] args) {
        Object стул1 = new Object();
        Object стул2 = new Object();

        Thread человек1 = new Thread(() -> {
            System.out.println("Человек 1 подошел к стулу");
            synchronized (стул1){
                System.out.println("Человек 1 сел на стул");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Человек 1 встал со стула");
            }
        });
        человек1.start();

        Thread человек2 = new Thread(() -> {
            System.out.println("Человек 2 подошел к стулу");
            synchronized (стул1){
                System.out.println("Человек 2 сел на стул");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Человек 2 встал со стула");
            }
        });
        человек2.start();


        Thread человек3 = new Thread(() -> {
            System.out.println("Человек 3 подошел к стулу");
            synchronized (стул1){
                System.out.println("Человек 3 сел на стул");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Человек 3 встал со стула");
            }
        });
        человек3.start();

        Thread человек4 = new Thread(() -> {
            System.out.println("Человек 4 подошел к стулу");
            synchronized (стул1){
                System.out.println("Человек 4 сел на стул");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Человек 4 встал со стула");
            }
        });
        человек4.start();



    }
}
