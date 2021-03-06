package de.schulte.ledboard.gamecollection.drawable;

import ledControl.BoardController;

/**
 * The abstract parental class of all graphical elements which are reused.
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
     * The BoardController used in the whole application.
     */
    BoardController controller;

    /**
     * The color that represents the main body of the Drawable. It is chosen when the Drawable is created and is defined as an RGB-code.
     */
    int[] primaryColor;

    /**
     * Set all the parameters.
     *
     * @param controller The BoardController used in the whole application.
     * @param xFactor the x-stretching / size of the Drawable
     * @param yFactor the y-stretching / size of the Drawable
     * @param xAdd the lowest x-value for a positive x-factor
     * @param yAdd the lowest y-value for a positive y-factor
     * @param primaryColor defines the main color of the Drawable as an RGB-code.
     */
    Drawable(BoardController controller, int xFactor, int yFactor, int xAdd, int yAdd, int[] primaryColor){
        this.controller = controller;
        this.xFactor = xFactor;
        this.yFactor = yFactor;
        this.xAdd = xAdd;
        this.yAdd = yAdd;
        this.primaryColor = primaryColor;
    }

    /**
     * Draws the specific Drawable with the parameters on the LED-matrix.
     */
    public abstract void draw();
}
