package com.epam.rd.autotasks.figures;

import java.util.Arrays;

import static com.epam.rd.autotasks.figures.Convex.convex;

class Quadrilateral extends Figure {

    private final Point a;
    private final Point b;
    private final Point c;
    private final Point d;

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        if (a == null || b == null || c == null || d == null) {
            throw new IllegalArgumentException("null parameter");
//        } else if (!convex(a, b, c, d)) {
//            throw new IllegalArgumentException("wrong coordinates");
        }else {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
    }

    @Override
    public boolean isTheSame(Figure figure) {
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
}
