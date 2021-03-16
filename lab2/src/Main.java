import java.math.BigDecimal;
import java.math.RoundingMode;
import  java.util.Scanner;

public class Main {

    public  static float distanceTo(Point3d Point3d_1, Point3d Point3d_2){
        double distance = Math.sqrt((Point3d_1.getX() - Point3d_2.getX())*(Point3d_1.getX() - Point3d_2.getX()) + (Point3d_1.getY() - Point3d_2.getY())*(Point3d_1.getY() - Point3d_2.getY()) + (Point3d_1.getZ() - Point3d_2.getZ())*(Point3d_1.getZ() - Point3d_2.getZ()));
        BigDecimal rez = new BigDecimal(distance);
        float rez1 = rez.setScale(2, RoundingMode.HALF_UP).floatValue();
        return rez1;
    }
    public  static double computeArea(Point3d Point3d_1, Point3d Point3d_2, Point3d Point3d_3){
        float line1 = distanceTo(Point3d_1, Point3d_2);
        float line2 = distanceTo(Point3d_2, Point3d_3);
        float line3 = distanceTo(Point3d_1, Point3d_3);
        float p = (line1+line2+line3)/2;
        double Square = Math.sqrt(p*(p-line1)*(p-line2)*(p-line3));
        return  Square;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите координаты 2 точки");
        double x = in.nextDouble(), y = in.nextDouble(), z = in.nextDouble();

        Point3d MyPoint = new Point3d();
        Point3d MyOyherPoint = new Point3d(x, y, z);
        Point3d MyThirdPoint = new Point3d();

        System.out.println("Измените координаты 3 точки");
        MyThirdPoint.setX(in.nextDouble());
        MyThirdPoint.setY(in.nextDouble());
        MyThirdPoint.setZ(in.nextDouble());

        System.out.println("Координаты 3 точек");
        System.out.println(MyPoint.getX() + "; " + MyPoint.getY() + "; " + MyPoint.getZ());
        System.out.println(MyOyherPoint.getX() + "; " + MyOyherPoint.getY() + "; " + MyOyherPoint.getZ());
        System.out.println(MyThirdPoint.getX() + "; " + MyThirdPoint.getY() + "; " + MyThirdPoint.getZ());

        if((MyPoint.getX()==MyOyherPoint.getX())&&(MyPoint.getY()==MyOyherPoint.getY())&&(MyPoint.getZ()==MyOyherPoint.getZ())){
            System.out.println("Заданны 2 одинаковые точки");
        }
        else if((MyPoint.getX()==MyThirdPoint.getX())&&(MyPoint.getY()==MyThirdPoint.getY())&&(MyPoint.getZ()==MyThirdPoint.getZ())){
            System.out.println("Заданны 2 одинаковые точки");
        }
        else if((MyOyherPoint.getX()==MyThirdPoint.getX()) && (MyOyherPoint.getY()==MyThirdPoint.getY())&&(MyOyherPoint.getZ()==MyThirdPoint.getZ())){
            System.out.println("Заданны 2 одинаковые точки");
        }
        else {
            double Square = computeArea(MyPoint, MyOyherPoint, MyThirdPoint);
            System.out.println("Площадь треуголика:");
            System.out.println(Square);
        }
    }
}