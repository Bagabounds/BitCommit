package org.hackathon.bitcommit.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector3;
import org.hackathon.bitcommit.game.Game;
import org.hackathon.bitcommit.states.PlayState;

import java.io.IOException;
import java.net.*;

/**
 * Created by codecadet on 24/11/16.
 */
public class Spaceship {

    private DatagramPacket sendPacket;
    private Vector3 position;
    private Vector3 velocity;
    private DatagramSocket socket;
    private byte[] sendBuffer;
    private String hostName = "192.168.1.15";
    private int portNumber = 5000;
    private Thread thread;
    private ReceiveData receiveData;
    private PlayState playState;
    private Spaceship opponent;
    private Circle circle;
    private int asteroidReference;

    private Texture texture;
    private Texture opponentTexture = new Texture("core/assets/resizewithouterglow2.png");
    private Texture transparent = new Texture("core/assets/spritetransparente.png");

    public Spaceship(int x, int y, PlayState playState) throws SocketException {

        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        texture = new Texture("core/assets/resizewithouterglow.png");
        socket = new DatagramSocket();
        sendBuffer = new byte[2048];
        opponent = playState.getOpponent();
        System.out.println("Spaceship get opponent: "+opponent);
        System.out.println(Thread.currentThread().getName() + " spacesho");
        receiveData = new ReceiveData(socket,opponent);

        thread = new Thread(receiveData);
        thread.start();
        this.playState = playState;
        //rectangle = new Rectangle(x, y, texture.getWidth(), texture.getHeight());
        circle = new Circle(x, y, 10);

    }

    public Texture getOpponentTexture() {
        return opponentTexture;
    }

    public void onKeyPressed(int input) {
        if (input == 21) {
            // LEFT

            if (velocity.x <= -240) {
                return;
            } else {
                velocity.x -= 60;
            }

            Gdx.app.log("velocity.x = ", velocity.x + "");

        } else if (input == 22) {
            // RIGHT

            if (velocity.x >= 240) {
                return;
            } else {
                velocity.x += 60;
            }

            Gdx.app.log("velocity.x = ", velocity.x + "");

            // todo: implementar logica UP para quando recebe power up

        }
    }

/*    public void onKeyPressed(int input) {
        if (input == 21) {
            // LEFT

            if (velocity.x > 0) {
                velocity.x = 0;
            } else if (velocity.x <= -240) {
                return;
            } else {
                velocity.x -= 60;
            }

            Gdx.app.log("velocity.x = ", velocity.x + "");

        } else if (input == 22) {
            // RIGHT

            if (velocity.x < 0) {
                velocity.x = 0;
            } else if (velocity.x >= 240) {
                return;
            } else {
                velocity.x += 60;
            }

            Gdx.app.log("velocity.x = ", velocity.x + "");

        }
    }*/

    public void update(float delta) {

        if (velocity.x > 0) {
            velocity.x -= 2;
        } else if (velocity.x < 0) {
            velocity.x += 2;
        }

        position.add(velocity.cpy().scl(delta));

        if (position.x >= Game.WIDTH - texture.getWidth()) {
            position.set(Game.WIDTH - texture.getWidth(), 50, 0);
            velocity.x = 0;
        } else if (position.x <= 0) {
            position.set(0, 50, 0);
            velocity.x = 0;
        }

        //rectangle.setPosition(position.x, position.y);
        circle.setPosition(position.x, position.y);

    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setPosition(Vector3 position) {
        this.position = position;
    }
    public void sendPosition() throws UnknownHostException {
        //System.out.println("Position " + (position).toString() );
        sendBuffer = ("1" + (position).toString()).getBytes();
        sendPacket = new DatagramPacket(sendBuffer,sendBuffer.length, InetAddress.getByName(hostName),portNumber);
        try {
            socket.send(sendPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Circle getCircle() {
        return circle;
    }

    public void dispose() {
        texture.dispose();
    }

    public void setAsteroidReference(int asteroidReference) {
        this.asteroidReference = asteroidReference;
    }

    public int getAsteroidReference() {
        return asteroidReference;
    }

    public void setTransparent() {
        this.transparent = opponentTexture;
    }

    public Texture getTransparent() {
        return transparent;
    }
}
