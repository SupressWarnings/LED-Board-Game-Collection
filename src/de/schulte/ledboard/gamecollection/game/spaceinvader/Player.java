package de.schulte.ledboard.gamecollection.game.spaceinvader;

import de.schulte.ledboard.gamecollection.util.Location;

public class Player {

    private Location location;
    private long lastShot;

    public Player(Location startLocation){
        this.location = startLocation;
        lastShot = System.currentTimeMillis();
    }

    public Shot shoot(){
        if(lastShot < System.currentTimeMillis() - 500){
            lastShot = System.currentTimeMillis();
            return new Shot(location);
        }else{
            return null;
        }
    }

    public void move(char direction){
        switch(direction){
            case 'L':
                if(location.getX() >= 1){
                    location = new Location(location.getX()-1, location.getY());
                }break;
            case 'R':
                if(location.getX() <= 10){
                    location = new Location(location.getX()+1, location.getY());
                }
        }
    }

    public Location getLocation() {
        return location;
    }
}
