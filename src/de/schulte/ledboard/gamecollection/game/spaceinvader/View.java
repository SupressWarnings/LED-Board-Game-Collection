package de.schulte.ledboard.gamecollection.game.spaceinvader;

import de.schulte.ledboard.gamecollection.drawable.Rectangle;
import de.schulte.ledboard.gamecollection.game.game_draft.GameObject;
import ledControl.BoardController;

import java.util.List;

public class View implements de.schulte.ledboard.gamecollection.game.game_draft.View {
    private BoardController controller;

    public View(BoardController controller){
        this.controller = controller;
    }

    private void drawPlayer(Player player){
        controller.setColor(player.getLocation().getX(), player.getLocation().getY(), 0, 0, 127);
        Rectangle lifesRectangle = new Rectangle(controller, player.getLives(), 1, 0, 0, new int[]{127, 0, 100});
        lifesRectangle.draw();
    }

    private void drawEnemies(Enemies enemies){
        for(int x = 0; x < enemies.getAliveMatrix().length; ++ x){
            for(int y = 0; y < enemies.getAliveMatrix()[x].length; ++y){
                if(enemies.getAliveMatrix()[x][y]){
                    controller.setColor(x + enemies.getTopLeft().getX(), y + enemies.getTopLeft().getY(), new int[]{127, 0, 0});
                }
            }
        }
    }

    private void drawShot(Shot shot){
        int[] colors = new int[3];
        if(shot.isHostile()){
            colors[0] = 0;colors[1] = 80;colors[2] = 0;
        }else{
            colors[0] = 60;colors[1] = 30;colors[2] = 0;
        }
        controller.setColor(shot.getLocation().getX(), shot.getLocation().getY(), colors);
    }

    @Override
    public void drawUpdates(List<GameObject> gameObjects) {
        controller.resetColors();
        for (GameObject gameObject : gameObjects) {
            switch (gameObject.getType()) {
                case Game.PLAYER:
                    drawPlayer((Player)gameObject);break;
                case Game.ENEMIES:
                    drawEnemies((Enemies)gameObject);break;
                case Game.SHOT:
                    drawShot((Shot)gameObject);break;
            }
        }
        controller.updateLedStripe();
    }

    @Override
    public void drawWelcomeScreen() {
        Rectangle alien1 = new Rectangle(controller, 3, 1, 1, 3, new int[]{127, 0, 0});
        controller.setColor(2, 2, new int[]{127, 0, 0});

        Rectangle alien2 = new Rectangle(controller, 3, 1, 0, 6, new int[]{127, 0, 0});
        controller.setColor(1, 5, new int[]{127, 0, 0});

        Rectangle alien3 = new Rectangle(controller, 3, 1, 1, 9, new int[]{127, 0, 0});
        controller.setColor(2, 8, new int[]{127, 0, 0});

        //water
        Rectangle earth1 = new Rectangle(controller, 6, 3, 6, 9, new int[]{0, 0, 127});
        Rectangle earth2 = new Rectangle(controller, 3, 1, 9, 8, new int[]{0, 0, 127});
        Rectangle earth3 = new Rectangle(controller, 3, 1, 8, 7, new int[]{0, 0, 127});
        controller.setColor(9, 6, new int[]{0, 0, 127});
        //ice
        Rectangle earth4 = new Rectangle(controller, 2, 1, 10, 6, new int[]{127, 127, 127});
        controller.setColor(11, 7, new int[]{127, 127, 127});
        //land
        Rectangle earth5 = new Rectangle(controller, 2, 1, 7, 8, new int[]{0, 127, 0});
        Rectangle earth6 = new Rectangle(controller, 4, 1, 8, 9, new int[]{0, 127, 0});
        Rectangle earth7 = new Rectangle(controller, 2, 1, 9, 10, new int[]{0, 127, 0});

        alien1.draw();
        alien2.draw();
        alien3.draw();

        earth1.draw();
        earth2.draw();
        earth3.draw();
        earth4.draw();
        earth5.draw();
        earth6.draw();
        earth7.draw();

        //draw last pixel of land
        controller.setColor(9, 11, new int[]{0, 127, 0});

        controller.updateLedStripe();
        controller.sleep(2000);
    }

    public static void drawMenuScreen(BoardController controller){
        Rectangle enemies = new Rectangle(controller, 6, 4, 4, 1, new int[]{0, 127, 0});
        Rectangle deadEnemies = new Rectangle(controller, 3, 1, 6, 4, new int[]{0, 0, 0});
        controller.setColor(5, 11, new int[]{127, 127, 127});
        controller.setColor(6, 8, new int[]{127, 0, 0});
        enemies.draw();
        deadEnemies.draw();
    }
}
