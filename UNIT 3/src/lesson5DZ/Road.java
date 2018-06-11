package lesson5DZ;

public class Road extends Stage {
    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }
    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап: " + description);
            //логически неверно сюда этот блок вставлять, а вдруг этап Road не будет последним?
            //лучше бы его в в класс Car
            //Участник #4 закончил этап: Дорога 40 метров
            //Участник #4 - WINNER
            //срабатывает
           if (CuncurrencyRace.FINISH.getCount() == CuncurrencyRace.CARS_COUNT - 1) {
                System.out.println(c.getName() + " - WINNER");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
