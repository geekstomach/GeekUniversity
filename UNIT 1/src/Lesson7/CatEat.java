package Lesson7;



public class CatEat {
    private static Cat[] cats = new Cat[8]; //почему должна быть private static(все никак до конца не разберусь)?

    public static void main(String[] args) {
        //Создаем тарелку
       Plait plait = new Plait(100);

 /*      cats[0] = new Cat("Владимир", 77);
       cats[1] = new Cat("Павел", 12);
       cats[2] = new Cat("ВладимирЖ.", 6);
       cats[3] = new Cat("Ксенья", 2);
       cats[4] = new Cat("Григорий", 2);
       cats[5] = new Cat("Борис", 1);
       cats[6] = new Cat("Максим", 1);
       cats[7] = new Cat("Сергей", 1);*/

        cats[7] = new Cat("Владимир", 77);
        cats[6] = new Cat("Павел", 12);
        cats[5] = new Cat("ВладимирЖ.", 6);
        cats[4] = new Cat("Ксенья", 2);
        cats[3] = new Cat("Григорий", 2);
        cats[2] = new Cat("Борис", 1);
        cats[1] = new Cat("Максим", 1);
        cats[0] = new Cat("Сергей", 1);



//Вступление
        {
            System.out.println("Вчера в тарелке было " + plait.getFood() + " еды.");
            System.out.println();
        }
// Посмотрим как едят коты (сначала использовал простой цикл for
// Идея предложила сделать foreach)
        for (Cat cat : cats) {
            cat.isCatSatiety();

         //   cat.CatEatDiscrete(plait);
            cat.CatEatContinuous(plait);
            cat.isCatSatiety();
            plait.leftFood();

            System.out.println();
        }
//Заключение
        {
            System.out.println("Прошло 5 лет, пора добавлять еды.");
            plait.addFood(100);
            plait.leftFood();
        }

    }
}

//Создаем класс Тарелка.

//Основной изменяемой величиной класса будет являться изменяемоя велична , количество еды.
//
class Plait{
    //Объявляем переменную Еда
    //Модификатор доступа сделаем приватный,чтобы переменная была доступна только в этом классе.
    // создадим геттер и сеттер для неё
    private int food;

    //Создаем конструктор класса.
    //Сначала был public
    //Идея предложила сделать package - private, непонятно зачем)
    Plait(int food) {
        this.food = food;
    }
//Создаем метод класса, который будет отвечать за добавление еды и индикацию оставшейся.
// надо ли частично повторяющиеся методы сеттер и геттер?
public void addFood(int addFood){
        this.food += addFood;
}
public void leftFood() {
    System.out.println("В тарелке осталось " + this.food + " еды.");
}
//Создаем метод который будет проверять , хватит ли еды коту
    public boolean enoughFood (int eatPortion){

        return (this.food - eatPortion) >= 0;
    }



    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }
}
//Создаем класс Кот.

//Основной изменяемой величиной класса будет являться неизменяемоя велична , порция еды при приеме пищи.
// у каждого кота она своя.(можно реализовать расброс с рандомом)
// А также имя и сотояние голоден/сыт
class Cat {
//Объявляем переменные.Нужны ли для них геттеры и сеттеры?

    private String name;
    private int eatPortion;
    // Сначала прочто объявил переменную, а в конструкторе присвоил false
    //Идея предложила сделать так
    private boolean satiety = false;

    //Создаем конструктор класса.Считаем что коты всегда голодны.
    //Сначала был public
    //Идея предложила сделать package - private, непонятно зачем)
    Cat(String name, int eatPortion) {
        this.name = name;
        this.eatPortion = eatPortion;
    }

    // Создаем метод , выводящий информацию о сытости кота на экран.
    public void isCatSatiety() {
        if (this.satiety) {
            System.out.println("Кот " + this.name + " сыт.");
        } else {
            System.out.println("Кот " + this.name + " голоден.");
        }
    }

/*    //Создаем метод поедания еды котом
    public void CatEatDiscrete(Plait plait) {
        if (!satiety && plait.enoughFood(eatPortion)) {
            plait.setFood(plait.getFood() - eatPortion);
            this.satiety = true;
            System.out.println("Кот " + this.name + " хорошенько поел.");
        } else {
            if (this.satiety) {
                isCatSatiety();
            } else {
                System.out.println("Кот " + this.name + " поесть не смог.");
                System.out.println("В тарелке недостаточно еды для кота " + this.name);
            }
        }
    }*/

    public void CatEatContinuous(Plait plait) {

int counte = 0;

             if (!satiety && plait.enoughFood(eatPortion)&&plait.getFood()> 0) {
                plait.setFood(plait.getFood() - eatPortion);
                this.satiety = true;
                System.out.println("Кот " + this.name + " хорошенько поел.");
                } else {
                    if (this.satiety) {
                    isCatSatiety();
                    } else {
                    System.out.println("Кот " + this.name + " доел оставшуюся еду.");
                        for (int i = 0; i < eatPortion; i++) {
                            if (plait.getFood()> 0){
                            plait.setFood(plait.getFood() - 1);
                            counte++;
                                } else {
                                System.out.println("Ему бы еще " + (eatPortion - counte) + " , но нет(");
                                System.out.println("В тарелке недостаточно еды для кота " + this.name);
                                return;
                                }
                    }

            }
        }
    }
}