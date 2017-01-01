package com.grutschus.infectious;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.grutschus.infectious.actors.Player;
import com.grutschus.infectious.input.InputHandler;

import static com.badlogic.gdx.graphics.Texture.TextureWrap.Repeat;

public class Infectious extends ApplicationAdapter {
	private static Stage stage;
	private static Texture floor;

	@Override
	public void create () {
		Viewport viewport = new FitViewport(CoreReference.GAMEWORLD_HEIGHT * CoreReference.ASPECT_RATIO, CoreReference.GAMEWORLD_HEIGHT);
		stage = new Stage(viewport);

		floor = new Texture(CoreReference.Assets.TEXTURE_FLOOR);
		floor.setWrap(Repeat, Repeat);
		stage.addActor(new Player());

		Gdx.input.setInputProcessor(new InputHandler());
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		stage.getBatch().begin();
		stage.getBatch().draw(floor, 0, 0, 0, 0, CoreReference.GAMEWORLD_WIDTH, CoreReference.GAMEWORLD_HEIGHT);
		stage.getBatch().end();
		stage.draw();
	}
	
	@Override
	public void dispose () {
		stage.dispose();
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
	}

    public static Stage getStage() {
        return stage;
    }
}
