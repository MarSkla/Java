package com.epam.rd.autotasks.figures;

class Circle extends Figure {

    private final Point center;
    private final double radius;

    Circle(Point center, double radius) {

        if (radius <= 0 || center == null) {
            throw new IllegalArgumentException("radius must be positive number");
        } else {
            this.center = center;
            this.radius = radius;
        }
    }

    public double getCenterX() {
        return this.center.getX();
    }
    public double getCenterY() {
        return this.center.getY();
    }

    public double getRadius() {
        return this.radius;
    }

    @Override
    public Point centroid() {
        return this.center;
    }

    @Override
    public boolean isTheSame(Figure figure) {

        if (this.getClass().equals(figure.getClass())) {

            Circle circle = (Circle) figure;
            double p = 0.01;

            boolean checkX = Math.abs(this.getCenterX() - circle.getCenterX()) <= p;
            boolean checkY = Math.abs(this.getCenterY() - circle.getCenterY()) <= p;
            boolean checkRadius = Math.abs(this.getRadius() - circle.getRadius()) <= p;

            return checkX && checkY && checkRadius;

        } else {
            return false;
        }
    }
}
