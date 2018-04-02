package Animals;

public class MainClass {
  public static void main (String[] args) {
      Cat cat1 = new Cat();
      Cat cat2 = new Cat(100, 4);

      Dog dog1 = new Dog();
      Dog dog2 = new Dog(400, 25, 2.5);

      System.out.println(cat1.getClass().getSimpleName()+ " swim : "+ cat1.toSwim(10));
      System.out.println(cat2.getClass().getName()+" swim: "+cat2.toSwim(10));
      //Можно ли создать в классе переменную String name  и ей автоматически присваивать имя экземпляра класса или наоборот?
      System.out.println(cat1.getClass()+" run: "+cat1.toRun(25));
      // Как сделать так чтобы перед надписью писалось имя экземпляра класса?

      cat1.toRun(250);
      cat2.toRun(10);
      cat2.toRun(150);

      dog1.toRun(10);
      dog1.toSwim(5);
      dog1.toJump(0.4);
      dog2.toRun(150);
      dog2.toRun(10000);

printCats();
  }
    public static void printCats() {
        for (int i = 0; i < Cat.cats.size(); i++) {
            System.out.println(Cat.class.getSimpleName()+" "+(i+1)+" "+
                    " Limits : Run: " + Cat.cats.get(i).runLimit +
                    " meters |" + " Swim: " + Cat.cats.get(i).swimLimit +
                    " | Jump: " + Cat.cats.get(i).jumpLimit + " meters");
            }
    }
}
