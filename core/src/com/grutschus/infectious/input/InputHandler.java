package com.grutschus.infectious.input;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.grutschus.infectious.Infectious;
import com.grutschus.infectious.actors.Player;

public class InputHandler implements InputProcessor {

    Player player;

    public InputHandler() {
    }

    @Override
    public boolean keyDown(int keycode) {
        try {
            switch (keycode) {
                case Controls.KEY_ATTACK_1:
                    if (player == null) initPlayer();
                    break;
                case Controls.KEY_ATTACK_2:
                    if (player == null) initPlayer();
                    break;
                case Controls.KEY_ATTACK_3:
                    if (player == null) initPlayer();
                    break;
                case Controls.KEY_ATTACK_4:
                    if (player == null) initPlayer();
                    break;
                case Controls.KEY_MOVE_DOWN:
                    if (player == null) initPlayer();
                    player.changeDirection(0, -1);
                    break;
                case Controls.KEY_MOVE_LEFT:
                    if (player == null) initPlayer();
                    player.changeDirection(-1, 0);
                    break;
                case Controls.KEY_MOVE_RIGHT:
                    if (player == null) initPlayer();
                    player.changeDirection(1, 0);
                    break;
                case Controls.KEY_MOVE_UP:
                    if (player == null) initPlayer();
                    player.changeDirection(0, 1);
                    break;
            }
        } catch (IllegalStateException | IllegalArgumentException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        try {
            switch (keycode) {
                case Controls.KEY_ATTACK_1:
                    if (player == null) initPlayer();
                    break;
                case Controls.KEY_ATTACK_2:
                    if (player == null) initPlayer();
                    break;
                case Controls.KEY_ATTACK_3:
                    if (player == null) initPlayer();
                    break;
                case Controls.KEY_ATTACK_4:
                    if (player == null) initPlayer();
                    break;
                case Controls.KEY_MOVE_DOWN:
                    if (player == null) initPlayer();
                    player.changeDirection(0, 1);
                    break;
                case Controls.KEY_MOVE_LEFT:
                    if (player == null) initPlayer();
                    player.changeDirection(1, 0);
                    break;
                case Controls.KEY_MOVE_RIGHT:
                    if (player == null) initPlayer();
                    player.changeDirection(-1, 0);
                    break;
                case Controls.KEY_MOVE_UP:
                    if (player == null) initPlayer();
                    player.changeDirection(0, -1);
                    break;
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    private void initPlayer() {
        for (Actor a : Infectious.getStage().getActors()) {
            if (a instanceof Player) {
                player = (Player) a;
                return;
            }
        }
        throw new IllegalStateException("Could not find a player object in stage. Player might not have been added to stage yet!");
    }
}
