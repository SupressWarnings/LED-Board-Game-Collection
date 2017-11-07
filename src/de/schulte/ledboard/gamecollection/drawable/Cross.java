package de.schulte.ledboard.gamecollection.drawable;

import ledControl.BoardController;

/**
 * A Drawable Cross which is given its size by x- and y-factor.
 *
 * @author Constantin Schulte
 */
public class Cross extends Drawable {

    /**
     * Calls constructor of Drawable.
     *
     * @param xFactor the x-stretching of the cross (if xFactor > yFactor)
     * @param yFactor the y-stretching of the cross (if yFactor > xFactor)
     * @param xAdd the lowest x-value.
     * @param yAdd the lowest y-value.
     */
    public Cross(BoardController controller, int xFactor, int yFactor, int xAdd, int yAdd, int[] primaryColor){
        super(controller, xFactor, yFactor, xAdd, yAdd, primaryColor);
    }

    @Override
    public void draw() {
        int size = xFactor > yFactor ? xFactor : yFactor;
        for(int x = 0; x < size; ++x){
            controller.setColor(x + xAdd, x + yAdd, primaryColor);
            controller.setColor(size - x - 1 + xAdd, x + yAdd, primaryColor);
        }
    }
}
