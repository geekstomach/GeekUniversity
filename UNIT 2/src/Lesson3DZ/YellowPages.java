package Lesson3DZ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class YellowPages {

    static HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();

  static void add(String lastName, String phone){
       if (phoneBook.containsKey(lastName)){
//           phoneBook.value(lastName).add(phone);
           phoneBook.get(lastName).add(phone);
       }else {phoneBook.put(lastName,new ArrayList<String>(Arrays.asList(phone)));}


  }
  public static ArrayList<String> get(String lastName){

  return phoneBook.get(lastName);}


    public static void main(String[] args) {

        add("Иванов","+7 (495) 510-0001");
        add("Смирнов","+7 (495) 510-0002");
        add("Кузнецов","+7 (495) 510-0003");
        add("Попов","+7 (495) 510-0004");
        add("Васильев","+7 (495) 510-0005");
        add("Петров","+7 (495) 510-0006");
        add("Соколов","+7 (495) 510-0007");
        add("Михайлов","+7 (495) 510-0008");
        add("Федоров","+7 (495) 510-0009");
        add("Новиков","+7 (495) 510-0010");
        add("Иванов","+7 (495) 510-0011");
        add("Иванов","+7 (495) 510-0012");
        add("Иванов","+7 (495) 510-0013");
        add("Иванов","+7 (495) 510-0014");
        add("Смирнов","+7 (495) 510-0015");
        add("Смирнов","+7 (495) 510-0016");
        add("Смирнов","+7 (495) 510-0017");
        add("Кузнецов","+7 (495) 510-0018");
        add("Кузнецов","+7 (495) 510-0019");
        add("Попов","+7 (495) 510-0020");
        




        System.out.println(get("Иванов"));
        System.out.println(get("Смирнов"));
        System.out.println(get("Кузнецов"));
        System.out.println(get("Попов"));
        System.out.println(get("Васильев"));


    }
}
