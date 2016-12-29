package com.grutschus.infectious;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Infectious extends ApplicationAdapter {
	private static SpriteBatch batch;
	private static Stage stage;
	private static Camera camera;
	private static Viewport viewport;

	private static Texture texture;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		viewport = new FitViewport(CoreReference.GAMEWORLD_WIDTH, CoreReference.GAMEWORLD_HEIGHT, camera);
		stage = new Stage(viewport, batch);

		texture = new Texture(Gdx.files.internal("badlogic.jpg"));
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(texture, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);
	}
}
