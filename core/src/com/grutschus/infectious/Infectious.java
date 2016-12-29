package com.grutschus.infectious;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.grutschus.infectious.input.InputHandler;

public class Infectious extends ApplicationAdapter {
	private static Stage stage;
	private static Viewport viewport;
	
	@Override
	public void create () {
		SpriteBatch batch = new SpriteBatch();
		Camera camera = new OrthographicCamera();
		viewport = new FitViewport(CoreReference.GAMEWORLD_WIDTH, CoreReference.GAMEWORLD_HEIGHT, camera);
		stage = new Stage(viewport, batch);

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
		viewport.update(width, height);
	}
}
