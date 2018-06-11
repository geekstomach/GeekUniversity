package lesson5DZ;

import java.util.concurrent.CountDownLatch;

public class Car implements Runnable {
    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }



    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;

        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;

    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            //Автомобиль подъехал к стартовой прямой - условие выполнено
            //уменьшаем счетчик на 1
            CuncurrencyRace.START.countDown();
            CuncurrencyRace.START.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        CuncurrencyRace.FINISH.countDown();


        //логически более правильно вставлять этот блок сюда, но последовательность
        // Участник #3 закончил этап: Дорога 40 метров
        //Участник #3 - WIN
        //не срабатывает.Победитель определяется верно, но пишется через 1((
/*        if (CuncurrencyRace.FINISH.getCount() == CuncurrencyRace.CARS_COUNT - 1) {
            System.out.println(this.getName() + " - WINNER");
        }*/
    }
}
