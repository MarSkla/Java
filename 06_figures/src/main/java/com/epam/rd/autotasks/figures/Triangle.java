package com.epam.rd.autotasks.figures;

import java.util.Arrays;

class Triangle extends Figure {

    private final Point first;
    private final Point second;
    private final Point third;

    public Triangle(Point first, Point second, Point third)
    {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    @Override
    public double area() {
        double sideA = length(first, second);
        double sideB = length(second, third);
        double sideC = length(third, first);

        double p = (sideA + sideB + sideC) / 2;

        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));

    }

    @Override
    public String pointsToString() {
        String pointOne = stringFormat(first);
        String pointTwo = stringFormat(second);
        String pointThree = stringFormat(third);
        return pointOne + pointTwo + pointThree;
    }

    @Override
    public Point leftmostPoint() {
        Point[] pointsArray = {
                first,
                second,
                third
        };

        int min = 0;

        for (int i = 1; i < pointsArray.length; i++) {
            if (pointsArray[i].getX() < pointsArray[min].getX()) {
                min = i;
            }
        }

        return pointsArray[min];
    }

    private double length(Point start, Point end) {
        double xDifference = end.getX() - start.getX();
        double yDifference = end.getY() - start.getY();
        return Math.abs(Math.sqrt(Math.pow(xDifference, 2) + Math.pow(yDifference, 2)));
    }

    private String stringFormat(Point point) {
        return String.format("(%s,%s)", point.getX(), point.getY());
    }

}
