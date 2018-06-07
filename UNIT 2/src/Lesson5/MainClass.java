package Lesson5;

public class MainClass {
    static class ATM{
        int money;

        public ATM(int money) {
            this.money = money;
        }

        public synchronized void takeMoney(String name, int amount){
            if (money >= amount){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                money -=amount;
                System.out.println(name + " взял " + amount);
            } else {
                System.out.println(name + " не хватает денег");
            }
            info();
        }

        public void info(){
            System.out.println("ATM: " + money);
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM(100);
        new Thread(() -> {atm.takeMoney("Bob1", 50);}).start();
        new Thread(() -> {atm.takeMoney("Bob2", 50);}).start();
        new Thread(() -> {atm.takeMoney("Bob3", 50);}).start();



//        Counter counter = new Counter();
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 1_000_000; i++) {
//                    counter.inc();
//                }
//            }
//        });
//
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 1_000_000; i++) {
//                    counter.dec();
//                }
//            }
//        });
//
//        t1.start();
//        t2.start();
//
//
//        try {
//            t1.join();
//            t2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(counter.value());
//

    }
}
