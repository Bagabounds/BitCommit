package org.hackathon.bitcommit.scrollable;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import javafx.scene.control.TextField;
import org.hackathon.bitcommit.game.Game;

/**
 * Created by codecadet on 24/11/16.
 */
public abstract class Scrollable {


    private Texture texture;
    private Vector3 position;
    private Vector3 velocity;
    private boolean isScrolledDown;

    public Scrollable(int x, int y, float scrollSpeed, String path) {
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, scrollSpeed, 0);
        isScrolledDown = false;
        texture = new Texture(path);
    }

    public void update(float delta) {

        position.add(velocity.cpy().scl(delta));

        if(position.y + Game.HEIGHT < 0){
            isScrolledDown = true;
        }
    }

    public void reset(float x, float y){
        position.x = x;
        position.y = y;
        isScrolledDown = false;
    }

    public void reset(float y){
        position.y = y;
        isScrolledDown = false;
    }

    public void dispose(){
        texture.dispose();
    }

    public boolean isScrolledDown() {
        return isScrolledDown;
    }

    public Vector3 getPosition() {
        return position;
    }

    /*public Vector3 getVelocity() {
        return velocity;
    }*/

    public Texture getTexture(){
        return texture;
    }

}
