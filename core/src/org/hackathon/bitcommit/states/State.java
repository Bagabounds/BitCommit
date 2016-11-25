package org.hackathon.bitcommit.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Created by codecadet on 24/11/16.
 */
public abstract class State {
    private OrthographicCamera cam;
    private Vector3 mouse;
    public GameStateManager gsm;

    public State(GameStateManager gsm) {
        this.gsm = gsm;
        cam = new OrthographicCamera();
        mouse = new Vector3();
    }

    public abstract void handleInput() throws SocketException;

    public abstract void update(float delta) throws SocketException, UnknownHostException;

    public abstract void render(SpriteBatch spriteBatch);

    public abstract void dispose();

    public OrthographicCamera getCam(){
        return cam;
    }
}
