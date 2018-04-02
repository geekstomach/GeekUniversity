package Lesson5;

public class Circle {
    private int X0;
    private int Y0;
    private double RAD;

    public Circle() {
    }

    public Circle(int x0, int y0, double rad) {
        X0 = x0;
        Y0 = y0;
        RAD = rad;
    }

    public int getX0() {
        return X0;
    }

    public void setX0(int x0) {
        X0 = x0;
    }

    public int getY0() {
        return Y0;
    }

    public void setY0(int y0) {
        Y0 = y0;
    }

    public double getRad() {
        return RAD;
    }

    public void setRad(double rad) {
        RAD = rad;
    }

    public void isEqualsSquare(Circle c1, Circle c2){
        if (Math.PI * Math.pow(c1.RAD, 2) ==  Math.PI * Math.pow(c2.RAD, 2)) {
            System.out.println("Площади данных окружностей равны");
        }
        else {
            System.out.println("Площади данных окружностей не равны");
        }
    }

    public void isIntersect(Circle c1, Circle c2){
        //Согласно математике есть уравнение, которое описывает координату точки касания окружности.
        //Соответственнодля того, чтобы 2 окружности имели пересечения или касание необходимо
        //эти уравнения приравнять, а решение сводится к тому, что если мы найдем дискриминант,
        //например, по координате X, то должны понимать следующее:
        //- если D > 0, то имеем 2 корня, соответственно окружности пересекаются в 2 точках
        //- если D == 0, то имеем 1 корень, соответственно окружности касаются друг друга в одной точке
        //- если D < 0, то нет решений, то есть окружности либо не пересекаются одна находится в другой
        //уравнения такие:
        //(x-a1)*(x-a1) + (y-b1)*(y-b1) = r1*r1
        //(x-a2)*(x-a2) + (y-b2)*(y-b2) = r2*r2
        //где a1 и b1 - точки центра окружности 1, с радиусом r1
        //где a2 и b2 - точки центра окружности 2, с радиусом r2
        //после того, как мы выразим y через x из первого уравнения и подставим во второе, то получим
        //квадратное уравнение вида a*x*x + b*x + c = 0, где условия дискриминанта такие:
        //D=b*b-4*a*c, a!=0
        //После моих вычислений на бумаге, если всё правильно рассчитал, то:
        double a;
        double b;
        double c;
        double D;

        a = Math.pow((2*(c1.X0-c2.X0)) ,2) + 4*Math.pow(c2.Y0,2);
        if (a != 0){
            b = 2 * (2*(c1.X0-c2.X0)) * (Math.pow(c1.RAD,2)-Math.pow(c1.X0,2)+c1.Y0-2*c2.Y0*c1.Y0+Math.pow(c2.X0,2)-Math.pow(c2.RAD,2)) - 8 * Math.pow(c2.Y0,2) * c1.X0;
            c = Math.pow(Math.pow(c1.RAD,2)-Math.pow(c1.X0,2)+c1.Y0-2*c2.Y0*c1.Y0+Math.pow(c2.X0,2)-Math.pow(c2.RAD,2),2) - 4*Math.pow(c2.Y0,2)*(Math.pow(c1.RAD,2)-Math.pow(c1.X0,2));
            D = b*b - 4*a*c;
            if (D < 0){
                System.out.println("Окружности не пересекаются, либо одна находится в другой!");
            } else if (D > 0){
                System.out.println("Окружности пересекаются в 2 точках!");
            } else if (D == 0){
                System.out.println("Окружности касаются друг друга в одной точке!");
            }
        } else {
            System.out.println("Ошибка при вычислении уравнений точек пересечения окружностей. На 0 делить нельзя!");
        }
    }
}
