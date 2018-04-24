package de.schulte.ledboard.gamecollection.game.snake;

import de.schulte.ledboard.gamecollection.game.game_draft.GameObject;
import de.schulte.ledboard.gamecollection.util.Location;

import java.util.ArrayList;
import java.util.List;

public class Snake implements GameObject {

    private ArrayList<Location> snake;
    private char direction;

    public Snake(Location head){
        snake = new ArrayList<>();
        snake.add(head);

        direction = 'R';

        initSnake();
    }

    private void initSnake(){
        for(int i = 0; i < 3; ++i){
            snake.add(snake.size(), new Location(snake.get(snake.size()-1).getX()-1, snake.get(snake.size()-1).getY()));
        }
    }

    private void move(){
        snake.remove(snake.size()-1);
        switch(direction){
            case 'R':
                snake.add(0, new Location(snake.get(0).getX()+1 <= 11 ? snake.get(0).getX()+1 : 0, snake.get(0).getY()));break;
            case 'L':
                snake.add(0, new Location(snake.get(0).getX()-1 >= 0 ? snake.get(0).getX()-1 : 11, snake.get(0).getY()));break;
            case 'U':
                snake.add(0, new Location(snake.get(0).getX(), snake.get(0).getY()-1 >= 0 ? snake.get(0).getY()-1 : 11));break;
            case 'D':
                snake.add(0, new Location(snake.get(0).getX(), snake.get(0).getY()+1 <= 11 ? snake.get(0).getY()+1 : 0));break;
        }
    }

    private boolean checkCollisions(List<GameObject> gameObjects){
        // apple collision
        for (GameObject gameObject : gameObjects) {
            if (gameObject.getType() == Game.APPLE) {
                if(((Apple) gameObject).getLocation().equals(snake.get(0))){
                    grow();
                }

            }
        }

        boolean breakingCondition = false;
        for(int i = 2; i < snake.size(); ++i){
            if(snake.get(0).equals(snake.get(i))){
                breakingCondition = true;
            }
        }
        return breakingCondition;
    }

    private void grow(){
        snake.add(new Location(snake.get(snake.size()-1)));
    }

    public void setDirection(char direction){
        if(!(direction == 'U' && this.direction == 'D' || direction == 'D' && this.direction == 'U' || direction == 'L' && this.direction == 'R' || direction == 'R' && this.direction == 'L')){
            this.direction = direction;
        }
    }

    public char getDirection(){
        return direction;
    }

    public ArrayList<Location> getSnakePositions() {
        return snake;
    }

    @Override
    public boolean update(List<GameObject> gameObjects, List<Character> input) {
        if(input.contains('R')){
            direction = 'R';
        }else if(input.contains('L')){
            direction = 'L';
        }else if(input.contains('D')){
            direction = 'D';
        }else if(input.contains('U')){
            direction = 'U';
        }
        move();
        return checkCollisions(gameObjects);
    }

    @Override
    public int getType() {
        return Game.SNAKE;
    }
}
