package com.epam.rd.autotasks.figures;

import java.util.Arrays;

class Quadrilateral extends Figure {

    private Point a;
    private Point b;
    private Point c;
    private Point d;

//    private final double lengthAB; //sides
//    private final double lengthBC;
//    private final double lengthCD;
//    private final double lengthDA;
//
//    private final double lengthBD; //diagonals
//    private final double lengthAC;

    public Quadrilateral(Point a, Point b, Point c, Point d) {

//        boolean plainCheck = plainCheck();

//        boolean nullCheck = (a != null && b!= null && c != null && d != null);
//        boolean plainCheck = plainCheck(a, b, c, d); //wywala - gdzieś bład w

//        boolean colinears = colinearsCheck(a, c, b); //działa ale są nie na wsystkie testy



        if ((a == null || b == null || c == null || d == null)) {
            throw new IllegalArgumentException("Missing Point/s"); ////WORKS GREAT
        } if (intersection(a, b, c, d)) {
            throw new IllegalArgumentException("Not convex");
//        }if (colinears) {
//            throw new IllegalArgumentException("Not a quadrilateral");
        }else {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
    }

    private boolean intersection(Point a, Point b, Point c, Point d) {
        Point diagonalAC = new Point(c.getX() - a.getX(), c.getY() - a.getY());
        Point diagonalBD = new Point(d.getX() - b.getX(), d.getY() - b.getY());

        Point segmentAB = new Point(b.getX() - a.getX(), b.getY() - a.getY());
        Point segmentBA = new Point(a.getX() - b.getX(), a.getY() - b.getY());
        Point segmentAD = new Point(d.getX() - a.getX(), d.getY() - a.getY());
        Point segmentBC = new Point(c.getX() - b.getX(), c.getY() - b.getY());

        double determinantACAB = determinant(diagonalAC, segmentBA);
        double determinantACAD = determinant(diagonalAC, segmentBC);

        boolean checkACvsBD = determinantACAB * determinantACAD < 0;

        double determinantBDBA = determinant(diagonalBD, segmentAB);
        double determinantBDBC = determinant(diagonalBD, segmentAD);

        boolean checkBDvsAC = determinantBDBA * determinantBDBC < 0;

        return checkACvsBD && checkBDvsAC;

    }

    public double determinant(Point diagonal, Point vector) {
        return diagonal.getX() * vector.getY() - diagonal.getY() * vector.getX();
    }

//    private boolean plainCheck(Point a, Point b, Point c, Point d) { //Sprawdza po parametrach równoległości
//        Point vectorAB = new Point(b.getX() - a.getX(), b.getY() - a.getY());
//        Point vectorCD = new Point(d.getX() - c.getX(), d.getY() - c.getY());
//        Point vectorAD = new Point(d.getX() - a.getX(), d.getY() - a.getY());
//        Point vectorBC = new Point(c.getX() - b.getX(), c.getY() - b.getY());
//
//        double ratioX = vectorAB.getX()/vectorCD.getX();
//        double ratioY = vectorAB.getY()/vectorCD.getY();
//        double ratioX2 = vectorAD.getX()/vectorBC.getX();
//        double ratioY2 = vectorAD.getY()/vectorBC.getY();
//
//        return (ratioX == ratioY) && (ratioX2 == ratioY2);
//    }
    
//    private boolean plainCheck(Point a, Point b, Point c, Point d) { // SPRAWDZA PO równych polach przylegających trójątów
//        double triangleABDarea = area(a, b, d);
//        double triangleBCDarea = area(b, c, d);
//        double triangleABCarea = area(a, b, c);
//        double triangleACDarea = area(a, c, d);
//
//        if ((triangleABDarea == triangleBCDarea) && (triangleABCarea == triangleACDarea)) {
//            return true;
//        } else {
//            return false;
//        }
//    }

    @Override
    public boolean isTheSame(Figure figure) { //WORKS GREAT
        if (this.getClass().equals(figure.getClass())) {

            Quadrilateral q = (Quadrilateral) figure;

            double[] xArrayOriginal = new double[]{ this.a.getX(), this.b.getX(), this.c.getX(), this.d.getX()};
            double[] xArrayQuadrilateral = new double[]{ q.a.getX(), q.b.getX(), q.c.getX(), q.d.getX()};
            double[] yArrayOriginal = new double[]{ this.a.getY(), this.b.getY(), this.c.getY(), this.d.getY()};
            double[] yArrayQuadrilateral = new double[]{ q.a.getY(), q.b.getY(), q.c.getY(), q.d.getY()};

            Arrays.sort(xArrayOriginal);
            Arrays.sort(xArrayQuadrilateral);
            Arrays.sort(yArrayOriginal);
            Arrays.sort(yArrayQuadrilateral);

            boolean xCheck = checkElements(xArrayOriginal, xArrayQuadrilateral);
            boolean yCheck = checkElements(yArrayOriginal, yArrayQuadrilateral);

            return xCheck && yCheck;
        } else {
            return false;
        }
    }

    boolean checkElements(double[] a, double[] b) {

        int equals = 0;
        double p = 0.01;

        for (int i = 0; i < a.length; i++) {
            if (Math.abs(a[i] - b[i]) <= p) {
                equals++;
            }
        }

        return equals == 4;
    }

    @Override
    public Point centroid() { //WORKS GREAT
        Point centroidABC = centroidTriangle(a, b, c);
        Point centroidACD = centroidTriangle(a, c, d);
        Point centroidABD = centroidTriangle(a, b, d);
        Point centroidBCD = centroidTriangle(b, c, d);

        double x1 = centroidABC.getX();
        double y1 = centroidABC.getY();
        double x2 = centroidACD.getX();
        double y2 = centroidACD.getY();

        double x3 = centroidABD.getX();
        double y3 = centroidABD.getY();
        double x4 = centroidBCD.getX();
        double y4 = centroidBCD.getY();

        double v = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);

        double parameterT = ((x1 - x3) * (y3 - y4) - (y1 - y3) * (x3 - x4)) / v;
        double parameterU = ((x1 - x3) * (y1 - y2) - (y1 - y3) * (x1 - x2)) / v;

        boolean checkT = (parameterT >= 0 && parameterT <= 1);
        boolean checkU = (parameterU >= 0 && parameterU <= 1);

        if (checkT && checkU) {
            double intersectionX = x1 + (parameterT*(x2-x1));
            double intersectionY = y1 + (parameterT *(y2-y1));

            return new Point(intersectionX, intersectionY);
        }
        else {
            return null;
        }
    }

    public Point centroidTriangle(Point a, Point b, Point c) {
        double centroidX = (a.getX() + b.getX() + c.getX()) / 3;
        double centroidY = (a.getY() + b.getY() + c.getY()) / 3;
        return new Point(centroidX, centroidY);
    }

    boolean colinearsCheck(Point start, Point end, Point check) {
        return Math.min(start.getX(), end.getX()) <= check.getX()
                && check.getX() <= Math.max(start.getX(), end.getX())
                && Math.min(start.getY(), end.getY()) <= check.getY()
                && check.getY() <= Math.max(start.getY(), end.getY());
    }



    boolean checkCoordinates(Point a, Point a1) {
        double p = 0.01;
        boolean checkX = Math.abs(a.getX() - a1.getX()) <= p;
        boolean checkY = Math.abs(a.getY() - a1.getY()) <= p;

        return checkX && checkY;
    }

//    public double area(Point a, Point b, Point c) { // do plaincheck() po polach
//
//        double areaCalculated = halfArea(a, b, c);
//        return areaCalculated;
//    }

//    public double halfArea(Point one, Point two, Point three) { // do plaincheck() po polach
//        double sideA = length(one, two);
//        double sideB = length(two, three);
//        double sideC = length(three, one);
//
//        double p = (sideA + sideB + sideC) / 2;
//
//        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
//
//    }

//    private double length(Point start, Point end) { // do plaincheck() po polach
//
//        double xDifference = end.getX() - start.getX();
//        double yDifference = end.getY() - start.getY();
//        return Math.abs(Math.sqrt(Math.pow(xDifference, 2) + Math.pow(yDifference, 2)));
//    }


}
