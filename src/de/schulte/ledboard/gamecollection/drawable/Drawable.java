package de.schulte.ledboard.gamecollection.drawable;

import ledControl.BoardController;

/**
 * The abstract Overclass of all graphical elements which are reused.
 */
public abstract class Drawable {

    /**
     * Setting the stretching or size of the Drawable. Can be negative in some cases.
     */
    int xFactor, yFactor = 1;

    /**
     * Setting the lowest x- and y-value if x- / y-factor are positive.
     */
    int xAdd, yAdd;

    /**
     * Set all the parameters.
     *
     * @param xFactor the x-stretching / size of the Drawable
     * @param yFactor the y-stretching / size of the Drawable
     * @param xAdd the lowest x-value for a positive x-factor
     * @param yAdd the lowest y-value for a positive y-factor
     */
    Drawable(int xFactor, int yFactor, int xAdd, int yAdd){
        this.xFactor = xFactor;
        this.yFactor = yFactor;
        this.xAdd = xAdd;
        this.yAdd = yAdd;
    }

    /**
     * Draws the specific Drawable with the parameters on the LED-matrix.
     *
     * @param controller the BoardController of the corresponding LED-matrix.
     */
    public abstract void draw(BoardController controller);
}
