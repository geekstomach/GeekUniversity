package Lesson5;

public class Person {
    private String surname;
    private String name;
    private String patronomic;
    private String post;
    private String email;
    private String phone;
    private float salary;
    private int age;

    public Person(String surname, String name, String patronomic, String post, String email, String phone, float salary, int age) {
        this.surname = surname;
        this.name = name;
        this.patronomic = patronomic;
        this.post = post;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void GetInfo(){
        System.out.println("Фамилия: " + surname);
        System.out.println("Имя: " + name);
        System.out.println("Отчество: " + patronomic);
        System.out.println("Должность: " + post);
        System.out.println("Электронная почта: " + email);
        System.out.println("Телефон: " + phone);
        System.out.printf("Зарплата: %.2f \n", salary);
        System.out.println("Возраст: " + age);
        System.out.println("------------------------------");
    }
}
