package com.epam.rd.autotasks.figures;

import java.util.Arrays;

import static java.lang.Math.sqrt;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Main {

    public static double determinant(Point diagonal, Point vector) {
        return diagonal.getX() * vector.getY() - diagonal.getY() * vector.getX();
    }

    public static void main(String[] args) {

//        Point centroidABC = centroidTriangle(a, b, c);
//        Point centroidACD = centroidTriangle(a, c, d);
//        Point centroidABD = centroidTriangle(a, b, d);
//        Point centroidBCD = centroidTriangle(b, c, d);

        Point a = new Point(0,0);
        Point b = new Point(1,10);
        Point c = new Point(11,11);
        Point d = new Point(19,2);

        double x1 = a.getX(), y1 = a.getY();
        double x2 = b.getX(), y2 = b.getY();
        double x3 = c.getX(), y3 = c.getY();
        double x4 = d.getX(), y4 = d.getY();

        double v = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);

        double parameterT = ((x1 - x3) * (y3 - y4) - (y1 - y3) * (x3 - x4)) / v;
        double parameterU = ((x1 - x3) * (y1 - y2) - (y1 - y3) * (x1 - x2)) / v;

        boolean checkT = (parameterT >= 0 && parameterT <= 1);
        boolean checkU = (parameterU >= 0 && parameterU <= 1);

        if (checkT && checkU) {
            double intersectionX = x1 + (parameterT*(x2-x1));
            double intersectionY = y1 + (parameterT *(y2-y1));

//            return new Point(intersectionX, intersectionY);
            System.out.println("punkt przecięcia: " + intersectionX + "' " + intersectionY);
        }
        else {
            System.out.println("niestety.....");
//            return false;
        }

        System.out.println("parameterT: " + parameterT);
        System.out.println("parameterU: " + parameterU);
        System.out.println("checkT: " + checkT);
        System.out.println("checkU: " + checkU);

//        ===vvv=== Sprawdzenie czy proste tworzone przez odcinki przecinają się ===vvv===
//
//        Point a = new Point(0, 0);
//        Point b = new Point(0, 1);
//        Point c = new Point(1,1);
//        Point d = new Point(10,0);
//
//
//        Point diagonalAC = new Point(c.getX() - a.getX(), c.getY() - a.getY());
//        Point diagonalBD = new Point(d.getX() - b.getX(), d.getY() - b.getY());
//
//        Point segmentAB = new Point(b.getX() - a.getX(), b.getY() - a.getY());
//        Point segmentBA = new Point(a.getX() - b.getX(), a.getY() - b.getY());
//
//        Point segmentAD = new Point(d.getX() - a.getX(), d.getY() - a.getY());
//
//        Point segmentBC = new Point(c.getX() - b.getX(), c.getY() - b.getY());
//
//        double determinantACAB = determinant(diagonalAC, segmentAB);
//        double determinantACAD = determinant(diagonalAC, segmentAD);
//
//        boolean checkACvsBD = determinantACAB * determinantACAD < 0;
//
//        double determinantBDBA = determinant(diagonalBD, segmentBA);
//        double determinantBDBC = determinant(diagonalBD, segmentBC);
//
//        boolean checkBDvsAC = determinantBDBA * determinantBDBC < 0;
//
//        System.out.println("segmentAB " + segmentAB.getX() + ", " + segmentAB.getY());
//        System.out.println("segmentBA " + segmentBA.getX() + ", " + segmentBA.getY());
//        System.out.println("segmentAD " + segmentAD.getX() + ", " + segmentAD.getY());
//        System.out.println("segmentBC " + segmentBC.getX() + ", " + segmentBC.getY());
//
//        System.out.println("diagonalAC: " + diagonalAC.getX() + ", " + diagonalAC.getY());
//        System.out.println("diagonalBD: " + diagonalBD.getX() + ", " + diagonalBD.getY());
//
//
//        System.out.println("determinantACAB: " + determinantACAB);
//        System.out.println("determinantACAD: " + determinantACAD);
//        System.out.println("checkACvsBD: " + checkACvsBD);
//        System.out.println();
//        System.out.println("determinantBDBA: " + determinantBDBA);
//        System.out.println("determinantBDBC: " + determinantBDBC);
//        System.out.println("checkBDvsAC: " + checkBDvsAC);
//        System.out.println();
//        System.out.println("final: " + (checkACvsBD && checkBDvsAC));
    }
}
