package com.epam.rd.autotasks.triangle;

import java.util.Arrays;

class Triangle {

    private final Point a;
    private final Point b;
    private final Point c;

    private final double lengthAB;
    private final double lengthBC;
    private final double lengthCA;

    public Triangle(Point a, Point b, Point c) {

        this.lengthAB = length(a, b);
        this.lengthBC = length(b, c);
        this.lengthCA = length(c, a);

        double[] segmentsLength = new double[]{lengthAB, lengthBC, lengthCA};
        Arrays.sort(segmentsLength);

        if (segmentsLength[0] + segmentsLength[1] <= segmentsLength[2]){
            throw new IllegalArgumentException(("this is not a triangle - check your coordinates"));
        } else {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public double area() {

        double p = (lengthAB + lengthBC + lengthCA) / 2;

        return Math.sqrt(p * (p - lengthAB) * (p - lengthBC) * (p - lengthCA));
    }

    public Point centroid() {

        double centroidX = (a.getX() + b.getX() + c.getX()) / 3;
        double centroidY = (a.getY() + b.getY() + c.getY()) / 3;

        return new Point(centroidX, centroidY);
    }

    private double length(Point start, Point end) {

        double xDifference = end.getX() - start.getX();
        double yDifference = end.getY() - start.getY();
        return Math.abs(Math.sqrt(Math.pow(xDifference, 2) + Math.pow(yDifference, 2)));
    }

}

