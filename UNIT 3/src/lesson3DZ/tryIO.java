package lesson3DZ;

import java.io.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Enumeration;

public class tryIO {
    public static void main(String[] args) {
        try {
            readFileToBiteArray("C:\\Users\\XE\\Google Диск\\GeekBrains\\geekbrains\\UNIT 3\\src\\lesson3DZ\\file1.txt");
            //readFileToBiteArray("file1.txt");
            stitchFiles();
            readPages();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
//1. Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль;

    private static void readFileToBiteArray(String path) throws FileNotFoundException {
        //используем конструкцию try-with-resources
        try (FileInputStream in = new FileInputStream(path)) {
            byte[] b = new byte[50];
            for (int i = 0; i < b.length; i++) {
                b[i] = (byte) in.read();
                // System.out.println(b[i]);
                System.out.print((char) b[i]);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //2. Последовательно сшить 5 файлов в один (файлы также ~100 байт).
    private static void stitchFiles() {
        String filePathString = "C:\\Users\\XE\\Google Диск\\GeekBrains\\geekbrains\\UNIT 3\\src\\lesson3DZ\\totalFile.txt";
        Path path = Paths.get(filePathString);
        if (Files.exists(path)) {
            System.out.println("Файл существует");
        } else {
            System.out.println("Файл не существует");
        }
        //почемуто неполучается короткий путь указать нигде(
        try (FileOutputStream out = new FileOutputStream(filePathString)) {
            ArrayList<InputStream> a1 = new ArrayList<>();
            for (int i = 1; i <= 5; i++) {
                a1.add(new FileInputStream("C:\\Users\\XE\\Google Диск\\GeekBrains\\geekbrains\\UNIT 3\\src\\lesson3DZ\\file" + i + ".txt")); //здесь создается потоки?и нужно их закрывать?
            }
            //интерфейс который перечисляет все файлы занеченные в поток?
            Enumeration<InputStream> e = Collections.enumeration(a1);
//конструктор, который принимает в качестве аргументов перечисления стримов
            SequenceInputStream s = new SequenceInputStream(e);

            int a;
            while ((a = s.read()) != -1) {
                out.write(a);
            }
            s.close();
//можно например проверить создался ли файл, и написать в консоль об этом
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //3. Написать консольное приложение, которое умеет постранично читать текстовые
    // файлы (размером > 10 mb). Вводим страницу, программа выводит ее в консоль
    // (за страницу можно принять 1800 символов). Время чтения файла должно оставаться
    // в разумных пределах: программа не должна загружаться дольше 10 секунд.
    // Чтение тоже не должно занимать более 5 секунд.
    private static void readPages() {
        long startTimeP = System.currentTimeMillis();

        String path = "C:\\\\Users\\\\XE\\\\Google Диск\\\\GeekBrains\\\\geekbrains\\\\UNIT 3\\\\src\\\\lesson3DZ\\\\fileMultiPage.txt";
        //воспользуемся RandomAccessFile, который позволяет обращатся к хранящимя в файле данным в произвольном порядке
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(path, "r")) {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            long pageSize = 1800;
            long pages = randomAccessFile.length() / pageSize;

            byte[] b = new byte[1800];
//что значит программа не должна загружатьс более 10 секунд, как это проверить?
            System.out.println();
            System.out.println("В файле " + pages + " страниц.");
            long stopTimeP = System.currentTimeMillis();
            long elapsedTimeP = stopTimeP - startTimeP;
            System.out.println();
            System.out.println("На запуск программы ушло "+elapsedTimeP+" миллисекунд");
            while (true) {
                System.out.println("Введите номерс страницы от 0 до " + pages + " или введите -1 чтобы выйти");
                long pN = Long.parseLong(bufferedReader.readLine()); //получаем строку , парсим в long
                long startTimeR = System.currentTimeMillis();
                if (pN >= 0 && pN <= pages) {
                    randomAccessFile.seek(pN * pageSize); //задаем положение указателя файла
                    randomAccessFile.read(b, 0, b.length);
                    for (byte aB : b) {
                        System.out.print((char) aB);
                    }
                    long stopTimeR = System.currentTimeMillis();
                    long elapsedTimeR = stopTimeR - startTimeR;
                    System.out.println();
                    System.out.println("На чтение из файла конкретной страницы ушло "+elapsedTimeR+" миллисекунд");
                } else if (pN == -1) {
                    System.out.println("Спасибо, досвидания!");
                    System.exit(0);
                } else {
                    System.out.println("Неверно задан номер страницы");
                }

            }

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }}




