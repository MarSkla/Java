package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure {

    private final Point first;
    private final Point second;
    private final Point third;
    private final Point fourth;

    Quadrilateral(Point first, Point second, Point third, Point fourth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
    }

    @Override
    public double area() {
        double firstTriangle = halfArea(first, second, fourth);
        double secondTriangle = halfArea(second, third, fourth);

        return firstTriangle + secondTriangle;
    }

    @Override
    public String pointsToString() {
        String pointOne = stringFormat(first);
        String pointTwo = stringFormat(second);
        String pointThree = stringFormat(third);
        String pointFour = stringFormat(fourth);
        return pointOne + pointTwo + pointThree + pointFour;
    }

    @Override
    public Point leftmostPoint() {
        Point[] pointsArray = {
                first,
                second,
                third,
                fourth
        };

        int min = 0;

        for (int i = 1; i < pointsArray.length; i++) {
            if (pointsArray[i].getX() < pointsArray[i-1].getX()) {
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

    public double halfArea(Point one, Point two, Point three) {
        double sideA = length(one, two);
        double sideB = length(two, three);
        double sideC = length(three, one);

        double p = (sideA + sideB + sideC) / 2;

        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));

    }

    private String stringFormat(Point point) {
        return String.format("(%s,%s)", point.getX(), point.getY());
    }
}
