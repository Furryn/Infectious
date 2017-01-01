package com.grutschus.infectious.actors;

import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.grutschus.infectious.CoreReference;
import com.sun.istack.internal.NotNull;

public class Player extends Actor {

    private float vel = CoreReference.Player.PLAYER_VEL;
    private float rotation = 0;
    private Vector2 direction = new Vector2();
    private Vector2 mousePosition = new Vector2();
    private Vector2 tempVec2 = new Vector2();
    private Animation<TextureRegion> walkingAnimation;
    private float animationTimer = 0f;

    public Player() {
        setSize(CoreReference.Player.PLAYER_SIZE_X, CoreReference.Player.PLAYER_SIZE_Y);
        setOrigin(getWidth() / 2, getHeight() / 2);
        setPosition(CoreReference.CENTER_X, CoreReference.CENTER_Y);

        TextureAtlas walkingAnimationAtlas = new TextureAtlas(CoreReference.Assets.ANIMATION_WALKING);
        walkingAnimation = new Animation<TextureRegion>(0.25f, walkingAnimationAtlas.findRegions("player"), Animation.PlayMode.LOOP);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        Sprite currentFrame = new Sprite(walkingAnimation.getKeyFrame(animationTimer, true));
        currentFrame.setRotation(rotation);
        currentFrame.setOrigin(getOriginX(), getOriginY());
        currentFrame.setPosition(getX(), getY());
        currentFrame.setSize(getWidth(), getHeight());
        currentFrame.draw(batch);
    }

    @Override
    public void act(float delta) {
        moveBy(vel * direction.x * delta, vel * direction.y * delta);

        if (!direction.equals(Vector2.Zero)) // Only animate when moving
            animationTimer = (animationTimer + delta) % 1; // Prevents timer from going to infinity.

        tempVec2 = mousePosition.cpy();
        tempVec2.sub(getX() + getOriginX(), getY() + getOriginY()); // Calculate a Vector pointing from Mouse to Player
        rotation = tempVec2.angle();
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

    public void setMousePosition(Vector2 v)
    {
        mousePosition = v.cpy();
    }

}
