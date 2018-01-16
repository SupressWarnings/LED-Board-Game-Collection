package de.schulte.ledboard.gamecollection.game.snake;

import de.schulte.ledboard.gamecollection.game.snake.util.Location;

public class AI {

    private Game game;
    private int turn = 0;

    AI(Game game){
        this.game = game;
        game.setEnabledAI(true);
    }

    public void play(){
        boolean state = true;
        if(state){
            if(game.getSnake().getDirection() == 'U'){
                int appleY = game.getSnake().getSnakePositions().get(0).getY() == 0 ? 11 : game.getSnake().getSnakePositions().get(0).getY() - 1;
                if(game.getApple().getY() == appleY){
                    game.setBufferDirection('R');
                }
            }else if(game.getSnake().getDirection() == 'D') {
                int appleY = game.getSnake().getSnakePositions().get(0).getY() == 11 ? 0 : game.getSnake().getSnakePositions().get(0).getY() + 1;
                if (game.getApple().getY() == appleY) {
                    game.setBufferDirection('R');
                }
        }else if(game.getSnake().getDirection() == 'L') {
                int appleX = game.getSnake().getSnakePositions().get(0).getX() == 0 ? 11 : game.getSnake().getSnakePositions().get(0).getX() - 1;
                if (game.getApple().getX() == appleX) {
                    game.setBufferDirection('U');
                }
            }else if(game.getSnake().getDirection() == 'R') {
                int appleX = game.getSnake().getSnakePositions().get(0).getX() == 11 ? 0 : game.getSnake().getSnakePositions().get(0).getX() + 1;
                if (game.getApple().getX() == appleX) {
                    game.setBufferDirection('U');
                }
            }

            if(game.getSnake().getDirection() == 'D'){
                for(Location location : game.getSnake().getSnakePositions()){
                    if(location.getX() == game.getSnake().getSnakePositions().get(0).getX() &&
                            location.getY() == game.getSnake().getSnakePositions().get(0).getY() + 2){
                        game.setBufferDirection('R');
                    }
                }
            }else if(game.getSnake().getDirection() == 'U') {
                for (Location location : game.getSnake().getSnakePositions()) {
                    if (location.getX() == game.getSnake().getSnakePositions().get(0).getX() &&
                            location.getY() == game.getSnake().getSnakePositions().get(0).getY() - 2) {
                        game.setBufferDirection('R');
                    }
                }
            }else if(game.getSnake().getDirection() == 'L') {
                for (Location location : game.getSnake().getSnakePositions()) {
                    if (location.getY() == game.getSnake().getSnakePositions().get(0).getY() &&
                            location.getX() == game.getSnake().getSnakePositions().get(0).getX() - 2) {
                        game.setBufferDirection('U');
                    }
                }
            }else if(game.getSnake().getDirection() == 'R') {
                for (Location location : game.getSnake().getSnakePositions()) {
                    if (location.getY() == game.getSnake().getSnakePositions().get(0).getY() &&
                            location.getX() == game.getSnake().getSnakePositions().get(0).getX() + 2) {
                        game.setBufferDirection('U');
                    }
                }
            }
        }else{
            if(game.getSnake().getSnakePositions().get(0).getX() == turn && game.getSnake().getDirection() != 'D'){
                game.setBufferDirection('D');
                turn = turn + 1 == 12 ? 0 : turn + 1;
            }else if(game.getSnake().getDirection() == 'D'){
                game.setBufferDirection('L');
            }
        }
    }

    public void stop(){
        game.setEnabledAI(false);
    }
}
