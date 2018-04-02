package Lesson6;

public class Circles {
     int x;
     int y;
     int r;
     static final double  p = 3.14;


    public Circles(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public static void main(String[] args) {
        Circles cOne = new Circles(0,0,11);
        Circles cTwo = new Circles(3,5,12);
        equalSquare(cOne.r,cTwo.r);
        System.out.println(
                (intersection(cOne, cTwo) == true) ?
                        "Заданные окружности пересекаются" :
                        "Заданные окружности не пересекаются");
    }

    private static void equalSquare(int r1, int r2) {
        double s1 = p*(Math.pow(r1,2)/4);
        double s2 = p*(Math.pow(r2,2)/4);
        if (s1==s2) {
            System.out.println("Площади заданных окружностей равны");
    }
    }





    public static boolean intersection(Circles circleOne, Circles circleTwo ){
    double dx = circleOne.x - circleTwo.x;
    double dy = circleOne.y - circleTwo.y;
    double cToCdistance = Math.sqrt(Math.pow(dx,2)+Math.pow(dy,2));
        return (circleOne.r + circleTwo.r) >= cToCdistance;
    }
}
