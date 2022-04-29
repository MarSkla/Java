package com.epam.rd.autotasks.figures;

class Convex {

    public static boolean convex(Point one, Point two, Point three, Point four) {
        return checkConvex(one, two, three)
                && checkConvex(two, three, four)
                && checkConvex(three, four, one)
                && checkConvex(four, one, two);
    }
    public static boolean checkConvex(Point x, Point y, Point z) {
        double x1 = x.getX(), y1 = x.getY();
        double x2 = x.getX(), y2 = x.getY();
        double x3 = x.getX(), y3 = x.getY();

        Point vectorXY = new Point(x2 - x1, y2 - y1);
        Point vectorYZ = new Point(x3 - x2, y3 - y2);

        return determinant(vectorXY, vectorYZ) < 0;
    }

    public static double determinant(Point vectorXY, Point vectorYZ) {
        return vectorXY.getX() * vectorYZ.getY() - vectorXY.getY() * vectorYZ.getX();
    }
}
