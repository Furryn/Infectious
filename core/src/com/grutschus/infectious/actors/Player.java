package com.grutschus.infectious.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.grutschus.infectious.CoreReference;
import com.sun.istack.internal.NotNull;

public class Player extends Actor {

    private ShapeRenderer shapeRenderer;
    private float vel = CoreReference.Player.PLAYER_VEL;
    private Vector2 direction = new Vector2();

    public Player() {
        setSize(CoreReference.Player.PLAYER_SIZE_X, CoreReference.Player.PLAYER_SIZE_Y);
        setOrigin(getWidth() / 2, getHeight() / 2);
        setPosition(CoreReference.CENTER_X, CoreReference.CENTER_Y);

        shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.end();
        shapeRenderer.setProjectionMatrix(batch.getProjectionMatrix());
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.rect(getX() - getWidth() / 2, getY() - getHeight() / 2, getWidth(), getHeight());
        shapeRenderer.setColor(1, 1, 1, 1);
        shapeRenderer.end();
        batch.begin();
    }

    @Override
    public void act(float delta) {
        moveBy(vel * direction.x * delta, vel * direction.y * delta);
    }

    /**
     * Sets the direction the player is currently moving.
     *
     * @param v Vector2 pointing in the direction. X and Y component should have the values -1, 0 or 1.
     * @throws IllegalArgumentException when the values are not -1, 0 or 1.
     */
    public void setDirection(@NotNull Vector2 v) {
        if (!(v.x == 0 || v.x == -1 || v.x == 1 || v.y == 0 || v.y == -1 || v.y == 1)) {
            throw new IllegalArgumentException("Invalid Vector! This might cause further problems.");
        }
        direction = v.cpy();
    }

    /**
     * Changes the direction the player is currently moving.
     *
     * @param v Vector2 pointing in the direction. X and Y component should have the values -1, 0 or 1.
     * @throws IllegalArgumentException when the values are not -1, 0 or 1.
     */
    public void changeDirection(@NotNull Vector2 v) {
        if (!(v.x == 0 || v.x == -1 || v.x == 1 || v.y == 0 || v.y == -1 || v.y == 1)) {
            throw new IllegalArgumentException("Invalid Vector! This might cause further problems.");
        }
        direction.x = direction.x + v.x;
        direction.y = direction.y + v.y;
    }

    /**
     * Changes the direction the player is currently moving.
     *
     * @param x float of the X component. Should have the values -1, 0 or 1.
     * @param y float of the Y component. Should have the values -1, 0 or 1.
     * @throws IllegalArgumentException when the values are not -1, 0 or 1.
     */
    public void changeDirection(float x, float y) {
        if (!(x == 0 || x == -1 || x == 1 || y == 0 || y == -1 || y == 1)) {
            throw new IllegalArgumentException("Invalid Vector! This might cause further problems.");
        }
        direction.x = direction.x + x;
        direction.y = direction.y + y;
    }

    public Vector2 getDirection() {
        return direction;
    }
}
