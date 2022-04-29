package com.epam.rd.autotasks.figures;

import static com.epam.rd.autotasks.figures.Convex.checkConvex;

public class Main {

    public static void main(String[] args) {

        Point a = new Point(0,0);
        Point b = new Point(1, 10);
        Point c = new Point(11,11);
        Point d = new Point(19,2);

        boolean convex = checkConvex(a, b, c)
                && checkConvex(b, c ,d)
                && checkConvex(c, d, a)
                && checkConvex(d, a, b);

        System.out.println();
        System.out.println("checkConvex(a, b, c): " + checkConvex(a, b, c));
        System.out.println("checkConvex(b, c ,d): " + checkConvex(b, c ,d));
        System.out.println("checkConvex(c, d, a): " + checkConvex(c, d, a));
        System.out.println("checkConvex(d, a, b): " + checkConvex(d, a, b));

        System.out.println("convex: " + convex);
    }
}
