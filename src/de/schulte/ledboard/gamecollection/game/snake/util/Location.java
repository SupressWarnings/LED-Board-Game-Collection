package de.schulte.ledboard.gamecollection.game.snake.util;

public class Location {
    private final int x, y;

    public Location(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Location(Location location){
        this.x = location.getX();
        this.y = location.getY();
    }

    public int getX(){
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean equals(Location location){
        return location != null && x == location.getX() && y == location.getY();
    }
}
