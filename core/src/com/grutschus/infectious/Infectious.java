package com.grutschus.infectious;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.grutschus.infectious.actors.Player;
import com.grutschus.infectious.input.InputHandler;

public class Infectious extends ApplicationAdapter {
	private static Stage stage;

	@Override
	public void create () {
		Viewport viewport = new FitViewport(CoreReference.GAMEWORLD_HEIGHT * CoreReference.ASPECT_RATIO, CoreReference.GAMEWORLD_HEIGHT);
		stage = new Stage(viewport);
		stage.addActor(new Player());

		Gdx.input.setInputProcessor(new InputHandler());
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
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
}
