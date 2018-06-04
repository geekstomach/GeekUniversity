package lesson1DZ;

import java.util.ArrayList;
import java.util.Arrays;

public class GenericTypes<E> {


//1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
    public static <E> ArrayList<E> SwitchPlacesArr(ArrayList<E> arrayList, Integer place1, Integer place2){

        E temp = arrayList.get(place1);

        arrayList.set(place1, arrayList.get(place2));
        arrayList.set(place2, temp);

    return arrayList;}

//2. Написать метод, который преобразует массив в ArrayList;


 public static<E> ArrayList<E> ConvertingArr(E[] array) {
        ArrayList<E> arrayList = new ArrayList<E>();
        for (int i = 0; i < array.length; i++) {
            arrayList.add(array[i]);
        }
        return arrayList;
    }

//ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(arr));

    public static void main(String[] args) {
        //String[] array = {"1", "2", "3", "4"};
        Integer[] array = {1, 2, 3, 4};
        ArrayList arrayList = ConvertingArr(array);


        System.out.println(arrayList);
        SwitchPlacesArr(arrayList,1,2);
        System.out.println(arrayList);
    }

    private static void SwitchPlacesArr() {
    }

/*
                                ArrayList<ObjElement> arrayList =
                new ArrayList<ObjElement>(Arrays.asList(arrayOfObjects));

        public ArrayList(Collection<? extends E> c) {
            elementData = c.toArray();
            size = elementData.length;
            // здесь Java проводит "магию" по сохранению данных как части ArrayList
            if (elementData.getClass() != Object[].class)
                elementData = Arrays.copyOf(elementData, size, Object[].class);
        }*/



    }
