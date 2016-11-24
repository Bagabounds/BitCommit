package org.hackathon.bitcommit.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import org.hackathon.bitcommit.game.Game;

/**
 * Created by codecadet on 24/11/16.
 */
public class Spaceship {

    private Vector3 position;
    private Vector3 velocity;

    private Texture texture;

    public Spaceship(int x, int y) {
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        texture = new Texture("core/assets/ship1.gif");
    }

    public void update(float delta){

        velocity.scl(delta);
        position.add(10, 0, 0);
        velocity.scl(1/delta);

        if(position.x >= Game.WIDTH - texture.getWidth()){
            position.set(Game.WIDTH - texture.getWidth(), 50, 0);
        }

    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return texture;
    }
}
