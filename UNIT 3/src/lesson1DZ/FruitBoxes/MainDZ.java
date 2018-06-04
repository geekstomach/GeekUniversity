package lesson1DZ.FruitBoxes;

public class MainDZ {
    public static void main(String[] args) {
        Box<Orange> box1 = new Box<>(new Orange(),new Orange(),new Orange());
        System.out.println(box1.getWeight());

        System.out.println(box1.getNumbersOfFruit());
        Box<Orange> box2 = new Box<>(new Orange(),new Orange(),new Orange(),new Orange(),new Orange(),new Orange());
        System.out.println(box2.getWeight());

        System.out.println(box2.getNumbersOfFruit());
        System.out.println(box1.Compare(box2));
        Box<Orange> box3 = new Box<>(new Orange(),new Orange(),new Orange());
        System.out.println(box1.Compare(box3));
        box3.pourfbtb(box1);
        System.out.println(box1.getWeight());

        System.out.println(box1.getNumbersOfFruit());
        System.out.println(box1.Compare(box2));
        Box<Apple> box4 = new Box<>(new Apple(),new Apple(),new Apple(),new Apple(),new Apple(),new Apple());
        System.out.println(box4.getWeight());

        System.out.println(box4.getNumbersOfFruit());
        System.out.println(box4.Compare(box2));

        box4.addFruit(new Apple());
      //  box4.addFruit(new Orange());
    }
}
