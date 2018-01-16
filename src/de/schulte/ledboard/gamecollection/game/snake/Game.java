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

    private boolean enabledAI = false;
    private char bufferDirection = 'R';
    private AI watson;

    public Game(BoardController controller){
        this.controller = controller;
        r = new Random();
        input = new Input(controller);
        snake = new Snake(new Location(controller.getHeight()/2, controller.getWidth()/2));
        view = new View(controller);
        createApple();
        view.drawWelcomeScreen();
        controller.sleep(5000);
        view.drawSnake(snake.getSnakePositions());
        view.drawApple(apple);
        play();
    }

    private void play(){
        boolean collision = false;
        while(!collision){
            snake.move();
            collision = checkCollisions();
            char direction = input.getInput();
            if(!enabledAI){
                if (direction == 'U' || direction == 'D' || direction == 'L' || direction == 'R') {
                    snake.setDirection(direction);
                }else if(direction == 'C'){
                    watson = new AI(this);
                }
            }else{
                snake.setDirection(bufferDirection);
                watson.play();
                if(direction == 'C'){
                    watson.stop();
                }
            }
            view.drawSnake(snake.getSnakePositions());
            view.drawApple(apple);
            controller.sleep(100);
        }
        controller.sleep(1500);
        controller.resetColors();
        controller.sleep(1500);
        view.drawScore(snake.getSnakePositions().size() - 4);
        controller.sleep(5000);
    }

    private boolean checkCollisions() {
        checkAppleCollision();
        return checkSnakeCollision();
    }

    private boolean checkSnakeCollision(){
        boolean collision = false;
        for(int i = 1; i < snake.getSnakePositions().size(); ++i){
            if(snake.getSnakePositions().get(i).equals(snake.getSnakePositions().get(0))){
                collision = true;
            }
        }
        return collision;
    }

    private void checkAppleCollision(){
        if(snake.getSnakePositions().get(0).equals(apple)){
            snake.grow();
            createApple();
        }
    }

    private void createApple(){
        apple = null;
        while(apple == null){
            apple = new Location(r.nextInt(controller.getHeight()), r.nextInt(controller.getWidth()));
            for(Location element : snake.getSnakePositions()){
                if(element.equals(apple)){
                    apple = null;
                }
            }
        }
    }

    public Snake getSnake() {
        return snake;
    }

    public Location getApple() {
        return apple;
    }

    public void setBufferDirection(char bufferDirection) {
        this.bufferDirection = bufferDirection;
    }

    public void setEnabledAI(boolean enabledAI) {
        this.enabledAI = enabledAI;
    }
}
