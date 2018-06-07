package lesson4DZ;
//если по 10 строчек то работает
//2. Написать совсем небольшой метод, в котором 3 потока построчно пишут данные в файл
// (по 10 записей с периодом в 20 мс)

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class threeThreads2 {

    static int x = 10;
    static int timeOut = 20;
static String path = "D:\\Distrib\\Google Диск\\GeekBrains\\geekbrains\\UNIT 3\\src\\lesson4DZ\\threeThreads2.txt";
    public static void main(String[] args) {

        PrintWriter pw = null;
        try {
            pw = new PrintWriter(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Thread t1 = new Thread(new dataToFile(pw,"Что я делаю не так?"));
        Thread t2 = new Thread(new dataToFile(pw,"В голове моей опилки?"));
        Thread t3 = new Thread(new dataToFile(pw,"Да?Да.Да!"));


        try {
            t1.start();
            t1.join();
            t2.start();
            t2.join();
            t3.start();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pw.close();
    }
    static class dataToFile implements Runnable{
        PrintWriter pw;
        String s;
        public dataToFile(PrintWriter pw, String s) {
            this.pw = pw;
            this.s = s;
        }

        @Override
        synchronized public void run() {
            for (int i = 0; i <x ; i++) {
                pw.println(s);
                try {
                    //Thread.sleep(timeOut);
                    wait(timeOut);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                pw.flush();


            }
        }
    }
}
