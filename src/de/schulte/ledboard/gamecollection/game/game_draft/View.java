package de.schulte.ledboard.gamecollection.game.game_draft;

import ledControl.BoardController;

import java.util.List;

public interface View {
    public void drawUpdates(List<GameObject> gameObjects);

    public void drawWelcomeScreen();
}
