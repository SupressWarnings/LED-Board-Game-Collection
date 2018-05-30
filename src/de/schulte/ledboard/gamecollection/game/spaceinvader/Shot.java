package de.schulte.ledboard.gamecollection.game.spaceinvader;

import de.schulte.ledboard.gamecollection.game.game_draft.GameObject;
import de.schulte.ledboard.gamecollection.util.Location;

import java.util.ArrayList;

public class Shot implements GameObject {

    private Location location;
    private long lastMoved;
    private Game game;
    private boolean hostile;
    private int endY;
    private boolean isEnded = false;

    public Shot(Location location, Game game, boolean hostile, int endY){
        this.location = location;
        this.game = game;
        this.hostile = hostile;
        this.endY = endY;
        lastMoved = System.currentTimeMillis();
    }

    private void move(){
        if(lastMoved + 1000 > System.currentTimeMillis()){
            location = new Location(location.getX(), hostile ? location.getY() + 1 : location.getY() - 1);
            lastMoved = System.currentTimeMillis();
        }
    }

    public Location getLocation() {
        return location;
    }

    public boolean isHostile() {
        return hostile;
    }

    @Override
    public boolean update(ArrayList<GameObject> gameObjects, ArrayList<Character> input) {
        if(isEnded){
            gameObjects.remove(this);
        }
        if(location.getY() == endY){
            isEnded = true;
        }else{
            move();
        }
        for (int i = 0; i < gameObjects.size(); ++i) {
            if (hostile && gameObjects.get(i).getType() == Game.PLAYER && location.equals(((Player) gameObjects.get(i)).getLocation())) {
                isEnded = true;
            }else if(!hostile && gameObjects.get(i).getType() == Game.ENEMIES && ((Enemies)gameObjects.get(i)).belongsToThis(location)){
                isEnded = true;
            }
        }
        return false;
    }

    @Override
    public int getType() {
        return Game.SHOT;
    }
}
