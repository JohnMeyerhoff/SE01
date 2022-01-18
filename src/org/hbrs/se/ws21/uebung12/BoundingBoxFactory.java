package org.hbrs.se.ws21.uebung12;

public class BoundingBoxFactory {

    private BoundingBoxFactory() {

    }

    public static MyPrettyRectangle surroundMultiple(MyPrettyRectangle[] rect) {
        if (rect.length == 0) {
            return null; // Wrong call
        }
        double absoluteBottom;
        double absoluteLeft;
        double absoluteTop;
        double absoluteRight;

        absoluteBottom = rect[0].getBottom();
        absoluteLeft = rect[0].getLeft();
        absoluteTop = rect[0].getTop();
        absoluteRight = rect[0].getRight();

        for (MyPrettyRectangle mpr : rect) {
            absoluteBottom = Math.min(absoluteBottom, mpr.getBottom());
            absoluteLeft = Math.min(absoluteLeft, mpr.getLeft());
            // Max for topright, Min for botleft
            absoluteTop = Math.max(absoluteTop, mpr.getTop());
            absoluteRight = Math.max(absoluteRight, mpr.getRight());
        }

        return new MyPrettyRectangle(new MyPoint(absoluteLeft, absoluteBottom),
                new MyPoint(absoluteRight, absoluteTop));
    }

}
