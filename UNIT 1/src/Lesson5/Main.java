package Lesson5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Задание 1.
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Иванов", "Иван", "Иванович", "Программист-стажер", "ivanov@mail.ru", "919-383-85-34", 100000.00f, 30);
        persArray[1] = new Person("Петров", "Петр", "Петрович", "Программист", "petrov@mail.ru", "919-383-85-35", 100001.00f, 31);
        persArray[2] = new Person("Юрьев", "Юрий", "Юрьевич", "Старший программист", "yuri@mail.ru", "919-383-85-36", 100002.00f, 32);
        persArray[3] = new Person("Дмитриев", "Дмитрий", "Дмитриевич", "Ведущий программист", "dmitry@mail.ru", "919-383-85-37", 100003.00f, 33);
        persArray[4] = new Person("Колянов", "Николай", "Николаевич", "Архитектор", "nikola@mail.ru", "919-383-85-38", 100004.00f, 41);

        for (Person persons:persArray)
            if(persons.getAge() > 40)
                persons.GetInfo();

        //Задание 2.SWITCH
        int[] product_price = {1000, 5000, 10000, 50000, 100000};
        Scanner sc = new Scanner(System.in);
        System.out.println("Узнайте скидку: введите сумму покупки!");
        switch(GetDiscount(sc.nextInt())){
            case 1000:
                System.out.println("Скидка: 5%");
                break;
            case 5000:
                System.out.println("Скидка: 10%");
                break;
            case 10000:
                System.out.println("Скидка: 15%");
                break;
            case 50000:
                System.out.println("Скидка: 20%");
                break;
            case 100000:
                System.out.println("Скидка: 25%");
                break;
            default :
                System.out.println("Скидка: 3%");
        }

        //Задание 3.
        Circle circle = new Circle();
        Circle circle1 = new Circle(0,0,12);
        Circle circle2 = new Circle(3,5,11);
        //Поставим разделитель от предыдущего задания
        System.out.println("------------------------------");
        circle.isEqualsSquare(circle1, circle2);
        //Поставим разделитель от предыдущего метода
        System.out.println("------------------------------");
        circle.isIntersect(circle1,circle2);
    }

    public static int GetDiscount(int discount){
        if (discount < 1000) discount = 0;
        if (discount >= 1000 && discount < 5000) discount = 1000;
        if (discount >= 5000 && discount < 10000) discount = 5000;
        if (discount >= 10000 && discount < 50000) discount = 10000;
        if (discount >= 50000 && discount < 100000) discount = 50000;
        if (discount >= 100000) discount = 100000;
        return discount;
    }

}
