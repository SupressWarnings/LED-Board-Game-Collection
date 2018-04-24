package de.schulte.ledboard.gamecollection.game.spaceinvader;

import de.schulte.ledboard.gamecollection.util.Location;

import java.util.Random;

public class Enemies {

    private Location location;
    private boolean[][] alive;
    private boolean moveMode = true;
    private boolean movingDown = true;

    private Random r;

    public Enemies(){
        r = new Random();
        alive = new boolean[8][3];
        location = new Location(0, 1);
        for(int x = 0; x < alive.length; ++x){
            for(int y = 0; y < alive[0].length; ++y){
                alive[x][y] = true;
            }
        }
    }

    public void kill(int x, int y){
        alive[x][y] = false;
    }

    public boolean getAlive(int x, int y){
        return alive[x][y];
    }

    public void move(){
        if(moveMode){
            location = new Location(location.getX()+1, location.getY());
            if(location.getX() == 5){
                if(movingDown){
                    location = new Location(4, location.getY() + 1);
                }else{
                    location = new Location(4, location.getY());
                }
                moveMode = false;
            }
        }else{
            location = new Location(location.getX()-1, location.getY());
            if(location.getX() == -1){
                if(movingDown){
                    location = new Location(0, location.getY() + 1);
                }else{
                    location = new Location(0, location.getY());
                }
                moveMode = true;
            }
        }
        if(location.getY() == 7){
            movingDown = false;
        }
    }

    public Location getLocation() {
        return location;
    }

    public boolean[][] getAlive() {
        return alive;
    }

    public boolean stillAlive(){
        boolean dead = true;
        for(int x = 0; x < alive.length; ++x){
            for (int y = 0; y < alive[0].length; ++y){
                if(alive[x][y]){
                    dead = false;
                }
            }
        }
        return !dead;
    }

    public Shot shoot(){
        Shot shot = null;
        int x = -1;
        do{
            x = r.nextInt(8);
        }while(!alive[x][0]);
        if(alive[x][2]){
            shot = new Shot(new Location(x, location.getY()+2), false);
        }else if(alive[x][1]){
            shot = new Shot(new Location(x, location.getY()+1), false);
        }else{
            shot = new Shot(new Location(x, location.getY()), false);
        }
        return shot;
    }
}
