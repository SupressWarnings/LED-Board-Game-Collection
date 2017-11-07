package de.schulte.ledboard.gamecollection.drawable;

import ledControl.BoardController;

/**
 * A Drawable vertical Arrow which is stretched by xFactor and yFactor.
 *
 * @author Constantin Schulte
 */
public class Arrow extends Drawable{

    /**
     * Calls constructor of Drawable.
     *
     * @param xFactor the x-stretching of the arrow.
     * @param yFactor the y-stretching of the arrow.
     * @param xAdd the lowest x-value (for positive x-factors)
     * @param yAdd the lowest y-value (for positive y-factors)
     */
    public Arrow(BoardController controller, int xFactor, int yFactor, int xAdd, int yAdd){
        super(controller, xFactor, yFactor, xAdd, yAdd);
    }

    @Override
    public void draw() {
        controller.setColor(xFactor + xAdd, yFactor + yAdd, 127, 127, 127);
        controller.setColor(xFactor + xAdd, 2 * yFactor + yAdd, 127, 127, 127);
        controller.setColor(xFactor + xAdd, 3 * yFactor + yAdd, 127, 127, 127);
        controller.setColor(xAdd, yFactor + yAdd, 0, 0, 127);
        controller.setColor(xFactor + xAdd, yAdd, 0, 0, 127);
        controller.setColor(2 * xFactor + xAdd, yFactor + yAdd, 0, 0, 127);
    }
}
