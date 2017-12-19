package de.schulte.ledboard.gamecollection.game.snake;

import de.schulte.ledboard.gamecollection.game.snake.util.Location;

import java.util.ArrayList;

public class Snake {

    private ArrayList<Location> snake;
    private char direction;

    public Snake(Location head){
        snake = new ArrayList<>();
        snake.add(head);
        direction = 'R';
    }

    public void move(){
        snake.remove(snake.size()-1);
        switch(direction){
            case 'R':
                snake.add(0, new Location(snake.get(0).getX()+1 < 11 ? snake.get(0).getX()+1 : 0, snake.get(0).getY()));break;
            case 'L':
                snake.add(0, new Location(snake.get(0).getX()-1 > 0 ? snake.get(0).getX()-1 : 11, snake.get(0).getY()));break;
            case 'U':
                snake.add(0, new Location(snake.get(0).getX(), snake.get(0).getY()-1 > 0 ? snake.get(0).getY()-1 : 11));break;
            case 'D':
                snake.add(0, new Location(snake.get(0).getX(), snake.get(0).getY()+1 < 11 ? snake.get(0).getY()+1 : 0));break;
        }
    }

    public void setDirection(char direction){
        this.direction = direction;
    }

    public char getDirection(){
        return direction;
    }

    public ArrayList<Location> getSnake() {
        return snake;
    }
}
