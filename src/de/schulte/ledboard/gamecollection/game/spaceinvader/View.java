package de.schulte.ledboard.gamecollection.game.spaceinvader;

import de.schulte.ledboard.gamecollection.drawable.Rectangle;
import de.schulte.ledboard.gamecollection.util.Location;
import ledControl.BoardController;

public class View {
    private BoardController controller;

    View(BoardController controller){
        this.controller = controller;
    }

    public void drawPlayer(Location player){
        controller.resetColors();
        controller.setColor(player.getX(), player.getY(), 0, 0, 127);
    }

    public void drawShot(Location shot, boolean direction){
        int[] colors = new int[3];
        if(direction){
            colors[0] = 0;colors[1] = 80;colors[2] = 0;
        }else{
            colors[0] = 60;colors[1] = 30;colors[2] = 0;
        }
        controller.setColor(shot.getX(), shot.getY(), colors);
    }

    public void drawLifes(int lifes){
        Rectangle lifesRectangle = new Rectangle(controller, lifes, 1, 0, 0, new int[]{127, 0, 100});
        lifesRectangle.draw();
    }

    public void drawEnemies(boolean[][] enemies, int xAdd, int yAdd){
        for(int x = 0; x < enemies.length; ++ x){
            for(int y = 0; y < enemies[0].length; ++y){
                if(enemies[x][y]){
                    controller.setColor(x + xAdd, y + yAdd, new int[]{127, 0, 0});
                }
            }
        }
    }

    public void update(){
        controller.updateLedStripe();
    }

    public static void drawMenu(BoardController controller){
        Rectangle enemies = new Rectangle(controller, 6, 4, 4, 1, new int[]{0, 127, 0});
        Rectangle deadEnemies = new Rectangle(controller, 3, 1, 6, 4, new int[]{0, 0, 0});
        controller.setColor(5, 11, new int[]{127, 127, 127});
        controller.setColor(6, 8, new int[]{127, 0, 0});
        enemies.draw();
        deadEnemies.draw();
    }
}
