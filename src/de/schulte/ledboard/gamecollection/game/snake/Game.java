package de.schulte.ledboard.gamecollection.game.snake;

import de.schulte.ledboard.gamecollection.game.snake.util.Location;
import ledControl.BoardController;

import java.util.Random;

public class Game {
    private Snake snake;
    private Location apple;
    private Random r;
    private BoardController controller;
    private Input input;
    private View view;

    public Game(BoardController controller){
        this.controller = controller;
        r = new Random();
        input = new Input(controller);
        snake = new Snake(new Location((int)controller.getHeight()/2, (int)controller.getWidth()/2));
        view = new View(controller, snake.getSnake());
        createApple();
        view.drawWelcomeScreen();
        controller.sleep(5000);
        view.drawSnake(snake.getSnake());
        view.drawApple(apple);
        play();
    }

    public void play(){
        boolean collision = false;
        while(!collision){
            snake.move();
            collision = checkCollisions();
            char direction = input.getInput();
            if (direction == 'U' || direction == 'D' || direction == 'L' || direction == 'R') {
                snake.setDirection(direction);
            }
            view.drawSnake(snake.getSnake());
            view.drawApple(apple);
            controller.sleep(100);
        }
        controller.sleep(1000);
    }

    private boolean checkCollisions() {
        checkAppleCollision();
        return checkSnakeCollision();
    }

    private boolean checkSnakeCollision(){
        boolean collision = false;
        for(int i = 1; i < snake.getSnake().size(); ++i){
            if(snake.getSnake().get(i).equals(snake.getSnake().get(0))){
                collision = true;
            }
        }
        return collision;
    }

    private void checkAppleCollision(){
        if(snake.getSnake().get(0).equals(apple)){
            snake.grow();
            createApple();
        }
    }

    private void createApple(){
        apple = null;
        while(apple == null){
            apple = new Location(r.nextInt(controller.getHeight()), r.nextInt(controller.getWidth()));
            for(Location element : snake.getSnake()){
                if(element.equals(apple)){
                    apple = null;
                }
            }
        }
    }
}
