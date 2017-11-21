package de.schulte.ledboard.gamecollection.drawable;

import ledControl.BoardController;

/**
 * A Drawable vertical Arrow which is stretched by xFactor and yFactor.
 *
 * @author Constantin Schulte
 */
public class Arrow extends Drawable{

    /**
     * Creates a new Arrow with setting the specific attributes.
     *
     * @param controller The BoardController used in the whole application.
     * @param xFactor the x-stretching / size of the Arrow
     * @param yFactor the y-stretching / size of the Arrow
     * @param xAdd the lowest x-value for a positive x-factor
     * @param yAdd the lowest y-value for a positive y-factor
     * @param primaryColor defines the main color of the Arrow as an RGB-code.
     */
    public Arrow(BoardController controller, int xFactor, int yFactor, int xAdd, int yAdd, int[] primaryColor){
        super(controller, xFactor, yFactor, xAdd, yAdd, primaryColor);
    }

    /**
     * Draws the Arrow on the LED-matrix.
     */
    @Override
    public void draw() {
        Rectangle line = new Rectangle(controller, xFactor - 1, 1, xAdd + 1, yAdd + 1, primaryColor);
        line.draw();
        controller.setColor(xAdd, yFactor + yAdd, 0, 0, 127);
        controller.setColor(xFactor + xAdd, yAdd, 0, 0, 127);
        controller.setColor(2 * xFactor + xAdd, yFactor + yAdd, 0, 0, 127);
    }
}
