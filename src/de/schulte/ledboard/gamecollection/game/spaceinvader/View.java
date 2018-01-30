package de.schulte.ledboard.gamecollection.game.spaceinvader;

import de.schulte.ledboard.gamecollection.util.Location;
import ledControl.BoardController;

public class View {
    private BoardController controller;

    View(BoardController controller){
        this.controller = controller;
    }

    public void drawPlayer(Location player){
        controller.resetColors();
        controller.setColor(player.getX(), player.getY(), 127, 127, 127);
    }

    public void drawShot(Location shot){
        controller.setColor(shot.getX(), shot.getY(), 127, 0, 0);
    }

    public void update(){
        controller.updateLedStripe();
    }
}
