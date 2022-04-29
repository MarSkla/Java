package com.epam.rd.autotasks.figures;

class Triangle extends Figure {

    private final Point a;
    private final Point b;
    private final Point c;

    public Triangle(Point a, Point b, Point c) throws IllegalArgumentException {

        if (a == null || b == null || c == null) {
            throw new IllegalArgumentException("Missing Point/s");
        } else if (determinant(a, b, c) == 0) {
            throw new IllegalArgumentException("This cannot be a triangle - collinear Points");
        } else {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    @Override
    public Point centroid() {
        double centroidX = (a.getX() + b.getX() + c.getX()) / 3;
        double centroidY = (a.getY() + b.getY() + c.getY()) / 3;
        return new Point(centroidX, centroidY);
    }

        @Override
    public boolean isTheSame(Figure figure) {
        return false;
    }

    private double determinant(Point a, Point b, Point c) {
        return (a.getX() * b.getY()) + (b.getX() * c.getY()) + (c.getX() * a.getY())
                - (c.getX() * b.getY()) - (b.getX() * a.getY()) - (a.getX() * c.getY());
    }

}
