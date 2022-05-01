package com.epam.rd.autotasks.figures;

class Convex {

    public static int convex(Point one, Point two, Point three, Point four) {

        return Math.abs(checkConvex(one, two, three) + checkConvex(two, three, four)
                + checkConvex(three, four, one) + checkConvex(four, one, two));
    }
    public static int checkConvex(Point x, Point y, Point z) {
        double x1 = x.getX(), y1 = x.getY();
        double x2 = y.getX(), y2 = y.getY();
        double x3 = z.getX(), y3 = z.getY();

        Point vectorXY = new Point(x2 - x1, y2 - y1);
        Point vectorYZ = new Point(x3 - x2, y3 - y2);

        if (determinant(vectorXY, vectorYZ) < 0) {
            return -1;
        } else if (determinant(vectorXY, vectorYZ) > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    private static double determinant(Point vectorXY, Point vectorYZ) {
        return vectorXY.getX() * vectorYZ.getY() - vectorXY.getY() * vectorYZ.getX();
    }
}
