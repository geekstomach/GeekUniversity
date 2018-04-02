package Lesson3DZ;

import java.util.*;

public class noDuplicate {



     public static void uniqueWords(){
        ArrayList<String> words = new ArrayList<String>();
        ArrayList<Integer> counts = new ArrayList<>();
        HashMap<String,Integer> mapWords = new HashMap<>();
         ArrayList<String> uniqueWords = new ArrayList<String>();
words = createArray();

        System.out.println(words);
        //Запишем вложенный иттератор
         //Посчитать, сколько раз встречается каждое слово.
         int count;
         Iterator<String> iterator = words.iterator();
         while (iterator.hasNext()){
             count = 0;
             String s = iterator.next();
             for (String it :words)
                   {
                        if (s.equals(it)) {count++;}
                   }
             counts.add(count);
                        if (count==1) {uniqueWords.add(s);}
             mapWords.put(s,count);
             }



         System.out.println(counts);

         //Выводим список уникальных слов
             System.out.println(uniqueWords);

//Выводим список уникальных слов
         for (Map.Entry<String, Integer> e : mapWords.entrySet()) {
             //to get key
             System.out.print(e.getKey()+" ");
             //and to get value
         }
         System.out.println();
         System.out.println(mapWords);







    }


    //Создаем метод создающий массив с набором слов(фамилий)
    static ArrayList createArray(){
        //Создаем массив с набором слов(фамилий)

        ArrayList<String> words = new ArrayList<String>();

        ArrayList<String> wordsWay1 = new ArrayList<String>();
        wordsWay1.add("Иванов");
        wordsWay1.add("Смирнов");
        wordsWay1.add("Кузнецов");
        wordsWay1.add("Попов");
        wordsWay1.add("Васильев");
        wordsWay1.add("Петров");
        wordsWay1.add("Соколов");
        wordsWay1.add("Михайлов");
        wordsWay1.add("Новиков");
        wordsWay1.add("Федоров ");

//Так лаконичей конечно
        ArrayList<String> wordsWay2 = new ArrayList<String>(
                Arrays.asList("Иванов","Иванов","Иванов","Иванов",
                        "Смирнов","Смирнов","Смирнов",
                        "Кузнецов","Кузнецов","Попов"));

        words.addAll(wordsWay1);
        words.addAll(wordsWay2);
    return words;
    }

    public static void main(String[] args) {
        uniqueWords();
    }
}
