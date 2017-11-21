package de.schulte.ledboard.gamecollection.drawable;

import ledControl.BoardController;

/**
 * A filled rectangular Drawable in one color.
 */
public class Rectangle extends Drawable {

    /**
     * Creates a new Rectangle with setting the specific attributes.
     *
     * @param controller The BoardController used in the whole application.
     * @param xFactor the x-stretching / size of the Rectangle
     * @param yFactor the y-stretching / size of the Rectangle
     * @param xAdd the lowest x-value for a positive x-factor
     * @param yAdd the lowest y-value for a positive y-factor
     * @param primaryColor defines the main color of the Rectangle as an RGB-code.
     */
    public Rectangle(BoardController controller, int xFactor, int yFactor, int xAdd, int yAdd, int[] primaryColor){
        super(controller, xFactor, yFactor, xAdd, yAdd, primaryColor);
    }

    /**
     * Draws the Rectangle on the LED-matrix.
     */
    @Override
    public void draw() {
        for(int x = xAdd; x < xAdd + xFactor; ++x){
            for(int y = yAdd; y < yAdd + yFactor; ++y){
                controller.setColor(x, y, primaryColor);
            }
        }
    }
}
