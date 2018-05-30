package de.schulte.ledboard.gamecollection.game.spaceinvader;

import de.schulte.ledboard.gamecollection.game.game_draft.GameObject;
import de.schulte.ledboard.gamecollection.util.Location;

import java.util.ArrayList;
import java.util.Random;

public class Enemies implements GameObject {

    private int movingTime = 1500;
    private int shootingTime = 2000;

    private Location firstTopLeft, topLeft;
    private boolean movingRight = true;
    private boolean[][] alive;
    private long lastShot, lastMoved;
    private int width, height, ownWidth;
    private Game game;
    private Random r = new Random();

    public Enemies(Location topLeft, int width, int height, int ownWidth, Game game){
        this.firstTopLeft = topLeft;
        this.topLeft = topLeft;
        this.width = width;
        this.height = height;
        this.ownWidth = ownWidth;
        this.game = game;
        alive = new boolean[ownWidth][3];
        for(int i = 0; i < alive.length; ++i){
            for(int j = 0; j < alive[i].length; ++j){
                alive[i][j] = true;
            }
        }
        lastShot = System.currentTimeMillis();
        lastMoved = System.currentTimeMillis();
    }

    private void move(){
        if(lastMoved + movingTime < System.currentTimeMillis()) {
            if((movingRight && topLeft.getX() == width - ownWidth) || (topLeft.getX() == 0 && !movingRight)) {
                if(topLeft.getY() < height - 6){
                    topLeft = new Location(topLeft.getX(), topLeft.getY() + 1);
                }
                movingRight = !movingRight;
            }else{
                if(movingRight){
                    topLeft = new Location(topLeft.getX() + 1, topLeft.getY());
                }else{
                    topLeft = new Location(topLeft.getX() - 1, topLeft.getY());
                }
            }
            lastMoved = System.currentTimeMillis();
        }
    }

    private void shoot(){
        if(lastShot + shootingTime < System.currentTimeMillis()){
            Shot shot;
            int x;
            do{
                x = r.nextInt(8);
            }while(!alive[x][0]);
            if(alive[x][2]){
                shot = new Shot(new Location(x + topLeft.getX(), topLeft.getY()+2), game, true, 11);
            }else if(alive[x][1]){
                shot = new Shot(new Location(x + topLeft.getX(), topLeft.getY()+1), game, true, 11);
            }else{
                shot = new Shot(new Location(x + topLeft.getX(), topLeft.getY()), game, true, 11);
            }
            game.insertGameObject(shot);
            lastShot = System.currentTimeMillis();
        }
    }

    public Location getTopLeft() {
        return topLeft;
    }

    public boolean[][] getAliveMatrix() {
        return alive;
    }

    public boolean getAlive(){
        boolean isAlive = false;

        for(boolean[] row : alive){
            for(boolean dot : row){
                if(dot){
                    isAlive = true;
                }
            }
        }

        return isAlive;
    }

    private boolean isAlive(Location location){
        return alive[location.getX() - topLeft.getX()][location.getY() - topLeft.getY()];
    }

    public boolean belongsToThis(Location location){
        return location.getX() < topLeft.getX() + ownWidth && location.getX() >= topLeft.getX()
                && location.getY() < topLeft.getY() + 3 && location.getY() >= topLeft.getY() && isAlive(location);
    }

    private void reset(){
        for(int i = 0; i < alive.length; ++i){
            for(int j = 0; j < alive[i].length; ++j){
                alive[i][j] = true;
            }
        }
        lastShot = System.currentTimeMillis();
        lastMoved = System.currentTimeMillis();
        topLeft = firstTopLeft;
        movingTime = (int) (movingTime * 0.9);
        shootingTime = (int) (shootingTime * 0.9);
        movingRight = true;
    }

    @Override
    public boolean update(ArrayList<GameObject> gameObjects, ArrayList<Character> input) {
        move();
        shoot();

        for (GameObject gameObject : gameObjects) {
            if (gameObject.getType() == Game.SHOT && !((Shot) gameObject).isHostile()
                    && belongsToThis(((Shot) gameObject).getLocation()) && isAlive(((Shot)gameObject).getLocation())) {
                alive[((Shot) gameObject).getLocation().getX() - topLeft.getX()][((Shot) gameObject).getLocation().getY() - topLeft.getY()] = false;
            }
        }

        if(!getAlive()){
            reset();
        }

        return false;
    }

    @Override
    public int getType() {
        return Game.ENEMIES;
    }
}
