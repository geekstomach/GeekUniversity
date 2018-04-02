package Lesson7;

import java.util.ArrayList;

public class EditString {
    public static void main(String[] args) {

        String s = "Проедложение один    Теперь преддлжение два  Теперь предложение 3";
        String s1 = s.replaceAll(" +", " ");

        //Создаем новый объект класса StringBuilder
            //Меняем пробел в конце каждого предложения на точку
            //Предложения ищем по заглавным буквам.

            StringBuilder s2 = new StringBuilder(s1);

            for (int i = 1; i < s1.length(); i++) {

                if (s1.charAt(i) >= 'А' && s1.charAt(i) <= 'Я') {
                    s2.setCharAt(i - 1, '.');
                }

            }

            String s3 = s2.toString();

            s2.append('.');
            System.out.println(s2.toString());



        // Создаем новый объект класса StringBuilder

            //Добавляем в конце каждого предложения пробел.
            StringBuilder s4 = new StringBuilder();

            for (int i = 0; i < s2.length(); i++) {
                s4.append(s2.charAt(i));
                if (s2.charAt(i) == '.') {
                    s4.append(' ');
                }
            }
            System.out.println(s4.toString());

        //Разбиваем строку на массив предложений.
            //не понял как это работает(

            String[] sentence = s3.split(".");





    }
}
