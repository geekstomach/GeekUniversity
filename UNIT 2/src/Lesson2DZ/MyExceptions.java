package Lesson2DZ;
//Создаем класс Мои Исключительные события и наследуемся от
//RuntimeException к которым относятся как неверный размер массива
//и неверное заполнение IndexOutOfBoundsException и ArrayStoreException
public class MyExceptions extends RuntimeException{




    public MyExceptions(String message) {
        super(message);
    }
}
