package org.hackathon.bitcommit.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.hackathon.bitcommit.game.Game;

public class DesktopLauncher {

	public static void main (String[] arg) {

		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.width = Game.WIDTH;
		config.height = Game.HEIGHT;
		config.title = Game.title;

		new LwjglApplication(new Game(), config);
	}

}
