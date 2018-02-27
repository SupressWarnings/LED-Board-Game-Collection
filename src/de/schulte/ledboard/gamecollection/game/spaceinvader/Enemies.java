package de.schulte.ledboard.gamecollection.game.spaceinvader;

import de.schulte.ledboard.gamecollection.util.Location;

public class Enemies {

    Location location;
    boolean[][] alive;
    boolean moveMode = true;

    public Enemies(){
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
                location = new Location(4, location.getY() + 1);
                moveMode = false;
            }
        }else{
            location = new Location(location.getX()-1, location.getY());
            if(location.getX() == -1){
                location = new Location(0, location.getY() + 1);
                moveMode = true;
            }
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
}
