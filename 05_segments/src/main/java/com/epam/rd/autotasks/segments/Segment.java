package com.epam.rd.autotasks.segments;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Segment {

    private Point startPoint;
    private Point endPoint;

    public Segment(Point startPoint, Point endPoint) {
        if (startPoint.getX() == endPoint.getX() && startPoint.getY() == endPoint.getY()) {
            throw new IllegalArgumentException("Check coordinates");
        } else {
            this.startPoint = startPoint;
            this.endPoint = endPoint;
        }
    }

    double length() {
        double xDifference = endPoint.getX() - startPoint.getX();
        double yDifference = endPoint.getY() - startPoint.getY();
        return Math.abs(Math.sqrt(Math.pow(xDifference, 2) + Math.pow(yDifference, 2)));
    }

    Point middle() {
        double middleX = (startPoint.getX() + endPoint.getX()) / 2;
        double middleY = (startPoint.getY() + endPoint.getY()) / 2;
        return new Point(middleX, middleY);
    }

    Point intersection(Segment another) {

        double x1 = startPoint.getX();
        double y1 = startPoint.getY();
        double x2 = endPoint.getX();
        double y2 = endPoint.getY();

        double x3 = another.startPoint.getX();
        double y3 = another.startPoint.getY();
        double x4 = another.endPoint.getX();
        double y4 = another.endPoint.getY();

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

}
