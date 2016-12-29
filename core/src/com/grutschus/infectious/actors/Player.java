package com.grutschus.infectious.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.grutschus.infectious.CoreReference;

public class Player extends Actor {

    private ShapeRenderer shapeRenderer;

    public Player() {
        setSize(CoreReference.Player.PLAYER_SIZE_X, CoreReference.Player.PLAYER_SIZE_Y);
        setOrigin(getWidth() / 2, getHeight() / 2);
        setPosition(CoreReference.CENTER_X, CoreReference.CENTER_Y);

        shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.end();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.rect(getX() - getWidth() / 2, getY() - getHeight() / 2, getWidth(), getHeight());
        shapeRenderer.setColor(1, 1, 1, 1);
        shapeRenderer.setProjectionMatrix(batch.getProjectionMatrix());
        shapeRenderer.end();
        batch.begin();
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
