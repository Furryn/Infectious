package com.grutschus.infectious.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.grutschus.infectious.CoreReference;
import com.grutschus.infectious.Infectious;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = CoreReference.GAME_NAME;
		new LwjglApplication(new Infectious(), config);
	}
}
