package de.schulte.ledboard.gamecollection.game.spaceinvader;

import de.schulte.ledboard.gamecollection.util.Location;

public class Shot {

    private Location location;
    public boolean direction = true;

    public Shot(Location startLocation){
        this.location = startLocation;
    }

    public Shot(Location startLocation, boolean direction){
        this.location = startLocation;
        this.direction = direction;
    }

    public void move(){
        if(direction){
            location = new Location(location.getX(), location.getY()-1);
        }else{
            location = new Location(location.getX(), location.getY()+1);
        }
    }

    public Location getLocation() {
        return location;
    }

    public boolean getDirection() {
        return direction;
    }
}
