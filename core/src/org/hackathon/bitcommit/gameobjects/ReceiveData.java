package org.hackathon.bitcommit.gameobjects;

import com.badlogic.gdx.math.Vector3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by codecadet on 24/11/16.
 */
public class ReceiveData implements Runnable{

    private DatagramSocket socket;
    private DatagramPacket receivePacket;
    private byte[] receiveBuffer = new byte[1024];
    private Spaceship opponent;

    public ReceiveData(DatagramSocket socket, Spaceship opponent) {
        this.socket = socket;
        this.opponent = opponent;
    }

    @Override
    public void run() {
        receivePacket = new DatagramPacket(receiveBuffer,receiveBuffer.length);
        try {
            while(true){
                socket.receive(receivePacket);
                String input = new String(receivePacket.getData(),0,receivePacket.getLength());

                System.out.println("Received "+input);
                System.out.println("opponent: " + opponent);
                float x = Float.parseFloat(input.substring(input.indexOf("(")+1,input.indexOf(",")));
                float y = Float.parseFloat(input.substring(input.indexOf(",")+1,input.lastIndexOf(",")));
                float z = 0;
                Vector3 opponentPosition = new Vector3(x,y,z);
                System.out.println(x + " " + y + " " + z);
                opponent.setPosition(opponentPosition);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
