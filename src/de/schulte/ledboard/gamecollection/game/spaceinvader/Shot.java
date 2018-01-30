package de.schulte.ledboard.gamecollection.game.spaceinvader;

import de.schulte.ledboard.gamecollection.util.Location;

public class Shot {
    private Location location;

    public Shot(Location startLocation){
        this.location = startLocation;
    }

    public void move(){
        location = new Location(location.getX(), location.getY()-1);
    }

    public Location getLocation() {
        return location;
    }
}
