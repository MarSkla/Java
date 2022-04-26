package com.epam.rd.autotasks.figures;

class Circle extends Figure {

    private final Point centre;
    private final double radius;

    Circle(Point centre, double radius) {
        this.centre = centre;
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius,2);
    }

    @Override
    public Point leftmostPoint() {
        return new Point(centre.getX() - radius, centre.getY());
    }

    @Override
    public String toString() {
//        return String.format("(%s,%s)", centre.getX(), centre.getY()) + String.format("%s",radius);
//        return String.format("(%s,%s)", centre.getX(), centre.getY());
        return this.getClass().getSimpleName() + "[" + pointsToString() + String.format("%s",radius) + "]";
    }

    @Override
    public String pointsToString() {
//        return String.format("(%s,%s)", centre.getX(), centre.getY()) + String.format("%s",radius);
        return String.format("(%s,%s)", centre.getX(), centre.getY());
//        return toString();
    }
}
