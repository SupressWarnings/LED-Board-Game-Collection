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
        createSnake();
    }

    private void createSnake(){
        for(int i = 0; i < 3; ++i){
            snake.add(snake.size(), new Location(snake.get(snake.size()-1).getX()-1, snake.get(snake.size()-1).getY()));
        }
    }

    public void move(){
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

    public void grow(){
        snake.add(new Location(snake.get(snake.size()-1)));
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
