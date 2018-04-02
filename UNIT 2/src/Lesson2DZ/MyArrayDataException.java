package Lesson2DZ;

public class MyArrayDataException extends MyExceptions {
    public MyArrayDataException(int i,int j) {
        super (String.format("Ошибка размера массива", i, j));
    }
}
