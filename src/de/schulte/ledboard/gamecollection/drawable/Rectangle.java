package de.schulte.ledboard.gamecollection.drawable;

import ledControl.BoardController;

public class Rectangle extends Drawable {

    public Rectangle(BoardController controller, int xFactor, int yFactor, int xAdd, int yAdd, int[] primaryColor){
        super(controller, xFactor, yFactor, xAdd, yAdd, primaryColor);
    }

    @Override
    public void draw() {
        for(int x = xAdd; x < xAdd + xFactor; ++x){
            for(int y = yAdd; y < yAdd + yFactor; ++y){
                controller.setColor(x, y, primaryColor);
            }
        }
    }
}
