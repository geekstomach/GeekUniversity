package Lesson2DZ;

public class MainHome {
    public static int SumOfArrayNums(String[][] strings) throws MyArraySizeException, MyArrayDataException{
            int sum = 0;

        if (strings.length != 4)
            throw new MyArraySizeException();


        for (int i = 0; i <4 ; i++) {
            if (strings[i].length != 4)

                throw new MyArraySizeException();
            for (int j = 0; j <4 ; j++) {
try{
                sum = sum + Integer.parseInt(strings[i][j]);
            }


        catch (NumberFormatException e){
            System.out.println();
            throw new MyArrayDataException(i,j);
        }}}
    return sum;

    }
public static void printArray(String[][] strings){
    for (int i = 0; i <4 ; i++) {
        for (int j = 0; j <4 ; j++) {
            System.out.print(strings[i][j]+" ");
        }
        System.out.println();
    }
}

    public static void main(String[] args) {
        String[][] normanArray = {
                {"1","2","3","4"},
                {"5","6","7","8"},
                {"9","10","11","12"},
                {"13","14","15","16"}
        };
        String[][] wrongSizeArray = {
                {"1","2","3","4"},
                {"5","6","7","8"},
                {"9","10","11","12"},
                {"13","14","15","16"},
                {"17","18","19","20"}
        };
        String[][] withCharArray = {
                {"1","2","З","4"},
                {"5","6","7","8"},
                {"9","1O","11","12"},
                {"13","14","15","16"},
        };
//printArray(normanArray);

        System.out.println(SumOfArrayNums(normanArray));

       // printArray(wrongSizeArray);
        try {
            System.out.println(SumOfArrayNums(wrongSizeArray));
        }   catch (MyExceptions e) {
        System.err.println(e.getMessage());
    }

    // printArray(withCharArray);
        try {
       System.out.println(SumOfArrayNums(withCharArray));
        }   catch (MyExceptions e) {
            System.err.println(e.getMessage());
            }

    }
}
