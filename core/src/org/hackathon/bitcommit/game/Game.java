package org.hackathon.bitcommit.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
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
	public static SpriteBatch spriteBatch;
	private GameStateManager gsm;
	public static AssetManager assetManager;


	
	@Override
	public void create () {
		spriteBatch = new SpriteBatch();
		assetManager = new AssetManager();

		assetManager.load("core/assets/audio/sfx/clicktostart.wav",Sound.class);
		assetManager.load("core/assets/audio/sfx/turnsound_final_.wav" , Sound.class);
		assetManager.load("core/assets/audio/music/gameplaysound.wav",Music.class);
		assetManager.load("/Users/codecadet/Desktop/BitCommit/core/assets/audio/sfx/shipsound_1.wav",Music.class);
		assetManager.load("core/assets/audio/music/gameoversound(1).ogg",Music.class);
		assetManager.load("core/assets/audio/music/menusound.mp3",Music.class);
		assetManager.load("core/assets/audio/music/eastereggsound.ogg", Music.class);
		assetManager.finishLoading();



		gsm = new GameStateManager();
		gsm.push(new MenuState(gsm));

	}

	// render() method is on loop
	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		assetManager.update();

		try {
			gsm.update(Gdx.graphics.getDeltaTime());
		} catch (SocketException e) {
			e.printStackTrace();
		}
		gsm.render(spriteBatch);
	}
	
	@Override
	public void dispose () {
		spriteBatch.dispose();
	}
}
