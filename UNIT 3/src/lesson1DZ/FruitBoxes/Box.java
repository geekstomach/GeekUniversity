package lesson1DZ.FruitBoxes;

import java.util.ArrayList;
import java.util.Arrays;
//Класс Box, в который можно складывать фрукты.
// Коробки условно сортируются по типу фрукта,
// поэтому в одну коробку нельзя сложить и яблоки, и апельсины;

public class Box<BoxType extends Fruit> {
//    Для хранения фруктов внутри коробки можно использовать ArrayList;
    private ArrayList<BoxType> boxOfFruits;

    private float weightOfTheBox;
//создаем конструктор класса
public Box(BoxType ...fruits){
    this.boxOfFruits = new ArrayList<BoxType>(Arrays.asList(fruits));
    for (BoxType a :
            boxOfFruits) {
        weightOfTheBox += a.weight();
    }

}

//    Сделать метод getWeight(), который высчитывает вес коробки,
// зная количество фруктов и вес одного фрукта
// (вес яблока – 1.0f, апельсина – 1.5f. Не важно, в каких это единицах);
    public float getWeight(){
    float weight = 0.0f;
        for (BoxType b :
                boxOfFruits) {
            weight += b.weight();
        }
        return weight;
    }

    public float getWeightOfTheBox() {
        return weightOfTheBox;
    }

    public int getNumbersOfFruit(){
    return (this.boxOfFruits.size());
    }

    //Внутри класса Коробка сделать метод compare, который позволяет сравнить текущую коробку с той,
 // которую подадут в compare в качестве параметра, true – если она равны по весу,
 // false – в противном случае (коробки с яблоками мы можем сравнивать с коробками с апельсинами);
    public boolean Compare (Box box){
//шляпа с округлением?

    return (this.weightOfTheBox == box.weightOfTheBox);}
 //    Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую
 // (помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами).
 // Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты,
 // которые были в этой коробке;

    public void pourfbtb(Box<BoxType> anotherBox){
        anotherBox.boxOfFruits.addAll(this.boxOfFruits);
        anotherBox.weightOfTheBox = anotherBox.weightOfTheBox+this.weightOfTheBox;
    this.boxOfFruits.clear();
    this.weightOfTheBox = 0;
    }
    //Не забываем про метод добавления фрукта в коробку.
    public void addFruit(BoxType fruit){
    this.boxOfFruits.add(fruit);
    this.weightOfTheBox= this.weightOfTheBox+fruit.weight;
    }


}
