package de.schulte.ledboard.gamecollection.game.snake;

import de.schulte.ledboard.gamecollection.drawable.Rectangle;
import de.schulte.ledboard.gamecollection.game.game_draft.GameObject;
import ledControl.BoardController;

import java.util.List;

public class View implements de.schulte.ledboard.gamecollection.game.game_draft.View {

    private BoardController controller;

    public View(BoardController controller){
        this.controller = controller;
    }

    void drawScore(int points){
        controller.resetColors();
        Rectangle relativeLine = new Rectangle(controller, 9, 1, 1, 4, new int[]{100, 30, 100});
        Rectangle relativeLine2 = new Rectangle(controller, 9, 1, 1, 6, new int[]{100, 30, 100});
        relativeLine.draw();
        relativeLine2.draw();
        int i = 1;
        while(points > 0){
            if(points % 2*i != 0){
                controller.setColor(i + 1, 5, 127, 127, 127);
            }
            points = points >>> 1;
            ++i;
        }
        controller.updateLedStripe();
        controller.sleep(10000);
    }

    private void drawSnake(Snake snake){
        for(int i = 0; i < snake.getSnakePositions().size(); ++i){
            controller.setColor(snake.getSnakePositions().get(i).getX(), snake.getSnakePositions().get(i).getY(), 10, 100, 10);
        }
        controller.setColor(snake.getSnakePositions().get(0).getX(), snake.getSnakePositions().get(0).getY(), 10, 120, 10);
    }

    private void drawApple(Apple apple){
        controller.setColor(apple.getLocation().getX(), apple.getLocation().getY(), 120, 10, 10);
    }

    @Override
    public void drawUpdates(List<GameObject> gameObjects) {
        controller.resetColors();
        for(GameObject object : gameObjects){
            if(object.getType() == Game.APPLE){
                drawApple((Apple) object);
            }else if(object.getType() == Game.SNAKE){
                drawSnake((Snake) object);
            }
        }
        controller.updateLedStripe();
    }

    @Override
    public void drawWelcomeScreen() {
        controller.resetColors();
        Rectangle s1 = new Rectangle(controller, 3, 1, 0, 0, new int[]{120, 120, 120});
        controller.setColor(0, 1, new int[]{120, 120, 120});
        Rectangle s2 = new Rectangle(controller, 3, 1, 0, 2, new int[]{120, 120, 120});
        controller.setColor(2, 3, new int[]{120, 120, 120});
        Rectangle s3 = new Rectangle(controller, 3, 1, 0, 4, new int[]{120, 120, 120});
        Rectangle n1 = new Rectangle(controller, 1, 5, 4, 0, new int[]{120, 120, 120});
        controller.setColor(5, 1, new int[]{120, 120, 120});
        Rectangle n2 = new Rectangle(controller, 1, 2, 6, 2, new int[]{120, 120, 120});
        Rectangle n3 = new Rectangle(controller, 1, 5, 7, 0, new int[]{120, 120, 120});
        Rectangle a1 = new Rectangle(controller, 1, 4, 9, 1, new int[]{120, 120, 120});
        controller.setColor(10, 0, new int[]{120, 120, 120});
        controller.setColor(10, 2, new int[]{120, 120, 120});
        Rectangle a2 = new Rectangle(controller, 1, 4, 11, 1, new int[]{120, 120, 120});
        Rectangle k1 = new Rectangle(controller, 1, 5, 2, 6, new int[]{120, 120, 120});
        controller.setColor(3, 8, new int[]{120, 120, 120});
        controller.setColor(4, 7, new int[]{120, 120, 120});
        controller.setColor(4, 9, new int[]{120, 120, 120});
        controller.setColor(5, 6, new int[]{120, 120, 120});
        controller.setColor(5, 10, new int[]{120, 120, 120});
        Rectangle e1 = new Rectangle(controller, 1, 5, 7, 6, new int[]{120, 120, 120});
        Rectangle e2 = new Rectangle(controller, 2, 1, 8, 6, new int[]{120, 120, 120});
        controller.setColor(8, 8, new int[]{120, 120, 120});
        Rectangle e3 = new Rectangle(controller, 2, 1, 8, 10, new int[]{120, 120, 120});
        s1.draw();
        s2.draw();
        s3.draw();
        n1.draw();
        n2.draw();
        n3.draw();
        a1.draw();
        a2.draw();
        k1.draw();
        e1.draw();
        e2.draw();
        e3.draw();
        controller.updateLedStripe();
        controller.sleep(2000);
    }

    public static void drawMenuScreen(BoardController controller) {
        Rectangle line1 = new Rectangle(controller, 6, 1, 5, 2, new int[]{10, 100, 10});
        Rectangle line2 = new Rectangle(controller, 1, 2, 10, 3, new int[]{10, 100, 10});
        Rectangle line3 = new Rectangle(controller, 1, 6, 8, 4, new int[]{10, 100, 10});
        controller.setColor(9, 4, new int[]{10, 100, 10});
        controller.setColor(7, 9, new int[]{10, 120, 10});
        controller.setColor(6, 7, new int[]{120, 10, 10});
        line1.draw();
        line2.draw();
        line3.draw();
    }
}
