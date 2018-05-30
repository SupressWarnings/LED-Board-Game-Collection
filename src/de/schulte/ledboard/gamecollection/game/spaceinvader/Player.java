package de.schulte.ledboard.gamecollection.game.spaceinvader;

import de.schulte.ledboard.gamecollection.game.game_draft.GameObject;
import de.schulte.ledboard.gamecollection.util.Location;

import java.util.ArrayList;

public class Player implements GameObject {

    private Location location;
    private int lives = 3;
    private Game game;
    private int width, height;
    private long lastShot;

    public Player(Location location, Game game, int width, int height){
        this.location = location;
        this.game = game;
        this.width = width;
        this.height = height;
        lastShot = System.currentTimeMillis();
    }

    private void shoot(){
        if(lastShot + 250 < System.currentTimeMillis()){
            game.insertGameObject(new Shot(new Location(location.getX(), location.getY()), game, false, 1));
            lastShot = System.currentTimeMillis();
        }
    }

    public Location getLocation() {
        return location;
    }

    public int getLives() {
        return lives;
    }

    @Override
    public boolean update(ArrayList<GameObject> gameObjects, ArrayList<Character> input) {
        if(input.contains('S')){
            shoot();
        }

        for (GameObject gameObject : gameObjects) {
            if (gameObject.getType() == Game.SHOT && location.equals(((Shot)gameObject).getLocation())){
                if (((Shot) gameObject).isHostile()) {
                    --lives;
                }
            }
        }

        if(input.contains('L') && location.getX() != 0){
            location = new Location(location.getX() - 1, location.getY());
        }else if(input.contains('R') && location.getX() != 11){
            location = new Location(location.getX() + 1, location.getY());
        }
        return lives == 0;
    }

    @Override
    public int getType() {
        return Game.PLAYER;
    }
}
