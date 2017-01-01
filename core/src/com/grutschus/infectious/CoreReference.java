package com.grutschus.infectious;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public abstract class CoreReference {

    public static final String GAME_NAME = "Infectious";
    public static final int GAMEWORLD_HEIGHT = 900;
    public static final int CENTER_Y = GAMEWORLD_HEIGHT / 2;
    static final float ASPECT_RATIO = (float) Gdx.graphics.getWidth() / (float) Gdx.graphics.getHeight();
    public static final int GAMEWORLD_WIDTH = 1600;
    public static final int CENTER_X = GAMEWORLD_WIDTH / 2;

    public abstract class Player {
        public static final float PLAYER_SIZE_Y = 150;
        public static final float PLAYER_SIZE_X = 150;

        public static final float PLAYER_VEL = 500;
    }

    public static abstract class Assets {
        public static final FileHandle TEXTURE_FLOOR = Gdx.files.internal("textures/game/floor.jpg");
        public static final FileHandle ANIMATION_WALKING = Gdx.files.internal("textures/game/player/player.atlas");
    }

}
