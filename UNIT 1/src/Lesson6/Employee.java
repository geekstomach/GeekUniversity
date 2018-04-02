package Lesson6;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Employee {
   private String fullName;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;
   public static Employee[] empArray = new Employee[5]; //объязательно должен быть Public и static/Разобраться!

    public Employee(String fullName, String position, String email, String phone, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public Employee(String fullName, String position, String email, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = "unknown";
        this.salary = salary;
        this.age = age;
    }

    public static void main(String[] args) {

        empArray[0] = new Employee("Корчагин Павел", "революционер", "pavka@ckkpss.ussr", "88009012491", 0, 30);
        empArray[1] = new Employee("Ivanov Alex", "chemist", "ivanov@issp.ru", "84967777879", 28000, 31);
        empArray[2] = new Employee("Eckel Bruce", "author", "mindviewinc@gmail.com", 1200000, 61);
        empArray[3] = new Employee("Bolit Ai", "doctor", "doctorAiBolit@yandex.ru", 56000, 47);
        empArray[4] = new Employee("Barmaley", "bandit", "BarmaleyTheBandit@mail.ru", 1200000000, 52);

        for (int i = 0; i < empArray.length; i++) {
            if (empArray[i].age > 40) {
                printObject(i);
            }
        }
    }
public static void printObject(int i){
    System.out.println("ФИО "+ empArray[i].fullName +", должность :"+ empArray[i].position +
            ", email - " + empArray[i].email + ", телефон :"+ empArray[i].phone +
            ", зарплата " + empArray[i].salary + ", возраст - " + empArray[i].age);

}
}
