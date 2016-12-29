package com.grutschus.infectious;

import com.badlogic.gdx.Gdx;

public abstract class CoreReference {

    public static final String GAME_NAME = "Infectious";
    static final int GAMEWORLD_HEIGHT = 900;
    public static final int CENTER_Y = GAMEWORLD_HEIGHT / 2;
    static final float ASPECT_RATIO = (float) Gdx.graphics.getWidth() / (float) Gdx.graphics.getHeight();
    private static final int GAMEWORLD_WIDTH = 1600;
    public static final int CENTER_X = GAMEWORLD_WIDTH / 2;

    public abstract class Player {
        public static final float PLAYER_SIZE_Y = 50;
        public static final float PLAYER_SIZE_X = 50;
    }

}
