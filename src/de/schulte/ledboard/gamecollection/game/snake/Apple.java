package de.schulte.ledboard.gamecollection.game.snake;

import de.schulte.ledboard.gamecollection.game.game_draft.GameObject;
import de.schulte.ledboard.gamecollection.util.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Apple implements GameObject {

    private Location apple;
    private Random r;

    private int xDimension, yDimension;

    public Apple(int xDimension, int yDimension){
        this.xDimension = xDimension;
        this.yDimension = yDimension;
        r = new Random();
        createApple(null);
    }

    private void createApple(Snake snake){
        apple = null;
        while(apple == null){
            apple = new Location(r.nextInt(yDimension), r.nextInt(xDimension));
            if(snake != null){
                for(Location element : snake.getSnakePositions()){
                    if(element.equals(apple)){
                        apple = null;
                    }
                }
            }
        }
    }

    public Location getLocation(){
        return null;
    }

    @Override
    public boolean update(List<GameObject> gameObjects, List<Character> input) {
        for (GameObject gameObject : gameObjects) {
            if (gameObject.getType() == Game.SNAKE) {
                if (apple.equals(((Snake) gameObjects.get(0)).getSnakePositions().get(0))) {
                    createApple((Snake) gameObject);
                }
            }
        }
        return false;
    }

    @Override
    public int getType() {
        return Game.APPLE;
    }
}
