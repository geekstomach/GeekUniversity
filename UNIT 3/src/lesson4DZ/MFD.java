package lesson4DZ;

/*3. Написать класс МФУ, на котором возможны одновременная печать и сканирование документов, при этом нельзя одновременно
        печатать или сканировать два документа (при печати в консоль выводится сообщения «отпечатано 1, 2, 3,... страницы»,
        при сканировании – «отсканировано...». Вывод в консоль все так же с периодом в 50 мс.)*/
public class MFD {
    Object lock1 = new Object();
    Object lock2 = new Object();
    public void print(String doc, int n){
        synchronized (lock1){
            System.out.println("Печать документа: "+doc);
            for (int i = 0; i < n; i++) {
                int percent = (i*100)/n;
                System.out.println("Прогресс печати "+percent+" %.");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }System.out.println("Печать документа "+doc+" завершена.");
    }
    public void scan(String doc, int n){
        synchronized (lock2){
            System.out.println("Сканирование документа: "+doc);
            for (int i = 0; i < n; i++) {
                int percent = (i*100)/n;
                System.out.println("Прогресс сканирования "+percent+" %.");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Сканирование документа "+doc+" завершено.");
    }

    public static void main(String[] args) {
        MFD mfd = new MFD();
        new Thread(()-> mfd.scan("А",4)).start();
        new Thread(()-> mfd.print("А",4)).start();
        new Thread(()-> mfd.scan("B",8)).start();
    }
    }
