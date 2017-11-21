package de.schulte.ledboard.gamecollection.drawable;

import ledControl.BoardController;

/**
 * A Drawable Cross which is given its size by x- and y-factor.
 *
 * @author Constantin Schulte
 */
public class Cross extends Drawable {

    /**
     * Creates a new Cross with setting the specific attributes.
     *
     * @param controller The BoardController used in the whole application.
     * @param xFactor the x-stretching / size of the Cross
     * @param yFactor the y-stretching / size of the Cross
     * @param xAdd the lowest x-value for a positive x-factor (top left corner)
     * @param yAdd the lowest y-value for a positive y-factor (top left corner)
     * @param primaryColor defines the main color of the Cross as an RGB-code.
     */
    public Cross(BoardController controller, int xFactor, int yFactor, int xAdd, int yAdd, int[] primaryColor){
        super(controller, xFactor, yFactor, xAdd, yAdd, primaryColor);
    }

    /**
     * Draws the Cross on the LED-matrix.
     */
    @Override
    public void draw() {
        int size = xFactor > yFactor ? xFactor : yFactor;
        for(int x = 0; x < size; ++x){
            controller.setColor(x + xAdd, x + yAdd, primaryColor);
            controller.setColor(size - x - 1 + xAdd, x + yAdd, primaryColor);
        }
    }
}
