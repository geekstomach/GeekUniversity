package lesson4DZ;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
//сделать так чтобы через строчку печатало в файл так и не получилось(
public class threeThreads2v1 {
    static Object monitor = new Object();
    static boolean[] booleans = {true,false,false};

    static int x = 10;
    static int timeOut = 20;
    static String path = "D:\\Distrib\\Google Диск\\GeekBrains\\geekbrains\\UNIT 3\\src\\lesson4DZ\\threeThreads2v1.txt";
    public static void main(String[] args) {

        PrintWriter pw = null;
        try {
            pw = new PrintWriter(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Thread t1 = new Thread(new threeThreads2v1.dataToFile(pw,"Что я делаю не так?",0,1));
        Thread t2 = new Thread(new threeThreads2v1.dataToFile(pw,"В голове моей опилки?",1,2));
        Thread t3 = new Thread(new threeThreads2v1.dataToFile(pw,"Да?Да.Да!",2,0));


        t1.start();

        t2.start();

       t3.start();

        pw.close();
    }
    static class dataToFile implements Runnable{
        PrintWriter pw;
        String s;
        int current;
        int next;
        public dataToFile(PrintWriter pw, String s, int current,int next) {
            this.pw = pw;
            this.s = s;
            this.current =current;
            this.next = next;
        }

        @Override
       public void run() {
            for (int i = 0; i < x; i++) {
            synchronized (monitor) {

                    try {
                    while (!booleans[current]) monitor.wait();
                    pw.println(s);
                    booleans[current] = false;
                    booleans[next] = true;
                    pw.flush();
                    Thread.sleep(timeOut);
                    monitor.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }



                }
            }
        }
    }
}