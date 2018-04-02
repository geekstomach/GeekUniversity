package Animals;
/*
1. Создать классы Собака и Кот с наследованием от класса Животное.
        2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие. В качестве параметра каждому методу передается величина, означающая или длину препятствия (для бега и плавания), или высоту (для прыжков).
        3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; прыжок: кот 2 м., собака 0.5 м.; плавание: кот не умеет плавать, собака 10 м.).
        4. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль. (Например, dog1.runLimit(150); -> результат: runLimit: true)
        5. * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой 600 м.
*/

import java.util.ArrayList;

// Создаю суперкласс Животное.
public class Animal {
    // Создаем  атрибуты класса (Генерализация, обобщение всех котов и собак)
    // Создаем

    int runLimit;
    int swimLimit;
    double jumpLimit;

    //Создаем конструкторы класса используея перегрузку конструкторов
    //Создаем конструктор по умолчанию, для обычных животных(со стандартными ограничениями)
    public Animal(){

    }
        // Создаем конструктор класс со всеми параметрами кроме плавания для кошки
    public Animal( int runLimit, double jumpLimit) {

        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
    }
    // Создаем конструктор класс со всеми параметрами для собаки
       public Animal( int runLimit, int swimLimit, double jumpLimit) {

        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        this.jumpLimit = jumpLimit;
    }



    //Животные могут выполнять действия:
    //Создаем методы суперкласса для всех животных Бежать, Плыть, Прыгать
    // каждому из которых передается дистанция или Высота, и который возвращает Булиевый результат.
    // удалось ли животному ее преодолеть(true) или нет(false).
    public boolean toRun(int runDistance){

        System.out.println(" run : "+ (runDistance > 0 && runDistance <= runLimit));
// Как сделать так чтобы перед надписью писалось имя экземпляра класса?
        return (runDistance > 0 && runDistance <= runLimit);
    }
    public boolean toSwim(int swimDistance){
        System.out.println(" swim : "+ (swimDistance > 0 && swimDistance <= swimLimit));
        return (swimDistance > 0 && swimDistance<=swimLimit );
    }
    public boolean toJump(double jumpHeight){
        System.out.println(" jump : "+ (jumpHeight > 0 && jumpHeight <= jumpLimit));
        return (jumpHeight > 0 && jumpHeight <= jumpLimit);
    }
    //Можно ли создать общий метод to Move, который будет принимать тип Движения и дистанция?
}
//Создаю класс Кот с наследованием от класса Животное.
class Cat extends Animal{
    //Задание на Static. Создаем списочный массив экземпляров класса.
    public static ArrayList<Cat> cats = new ArrayList<Cat>();


    // Создаем конструктор класса кошка
    public Cat(){
        super();
        runLimit = 200;
        jumpLimit = 2;
        // при каждом создании экземпляра класса добавляем его в cats (делать во всех конструкатах класса )
        cats.add(this);
    }
// Создаем конструктор класса кошка, с нестандартными ограничениями
    public Cat( int runLimit, double jumpLimit) {
        super(runLimit, jumpLimit);
        cats.add(this);
    }
    //Так как кошка не умее плавать, переопределяем метод суперкласса toSwim
    @Override
    public boolean toSwim(int swimLimit){
        System.out.println("Кот не умеет плавать.");
        return false;
    }
}
//Создаю класс Собака с наследованием от класса Животное.
class Dog extends Animal {

    public Dog(){
        super();
        runLimit = 500;
        swimLimit= 10;
        jumpLimit = 0.5;
    }
    public Dog( int runLimit, int swimLimit, double jumpLimit) {
        super(runLimit, swimLimit, jumpLimit);
    }
}
