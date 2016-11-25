package org.hackathon.bitcommit.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.net.SocketException;
import java.util.Stack;

/**
 * Created by codecadet on 24/11/16.
 */
public class GameStateManager {

    private Stack<State> states;

    public GameStateManager() {
        states = new Stack<State>();
    }

    public void push(State state){
        states.push(state);
    }

    public void pop(){
        states.pop();
    }

    public void set(State state){
        states.pop();
        states.push(state);
    }

    public void update(float delta) throws SocketException {
        states.peek().update(delta);
    }

    public void render(SpriteBatch spriteBatch){
        states.peek().render(spriteBatch);
    }

}
