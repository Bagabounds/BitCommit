package org.hackathon.bitcommit.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.hackathon.bitcommit.states.GameStateManager;
import org.hackathon.bitcommit.states.Hud;
import org.hackathon.bitcommit.states.MenuState;

import java.net.SocketException;

public class Game extends ApplicationAdapter {

	public static final int WIDTH = 680;
	public static final int HEIGHT = 1024;
	public static final String title = "<Bit Commit_>";
	private GameStateManager gsm;

	private SpriteBatch spriteBatch;
	private Texture img;
	private Hud hud;
	
	@Override
	public void create () {
		spriteBatch = new SpriteBatch();
		img = new Texture("core/assets/badlogic.jpg");
		gsm = new GameStateManager();
		gsm.push(new MenuState(gsm));
		hud = new Hud(spriteBatch);

	}

	// render() method is on loop
	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		try {
			gsm.update(Gdx.graphics.getDeltaTime());
		} catch (SocketException e) {
			e.printStackTrace();
		}
		gsm.render(spriteBatch);
		spriteBatch.setProjectionMatrix(hud.stage.getCamera().combined);
		hud.stage.draw();

/*		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();*/
	}
	
	@Override
	public void dispose () {
		spriteBatch.dispose();
		img.dispose();
	}
}
