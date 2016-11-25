package org.hackathon.bitcommit.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Created by codecadet on 19/11/16.
 */
public class GameClient implements Runnable {
    private DatagramPacket packet;
    private DatagramSocket socket;
    private InetAddress address;
    private int port;

    public GameClient(DatagramPacket receivePacket, DatagramSocket socket) throws SocketException {
        this.socket = socket;
        this.address = receivePacket.getAddress();
        System.out.println(address);
        this.port = receivePacket.getPort();
        System.out.println(port);
    }

    @Override
    public void run() {

    }

    public synchronized void sendPacket(DatagramPacket datagramPacket) {
        System.out.println("enviei");
        try {
            socket.send(new DatagramPacket(datagramPacket.getData(), datagramPacket.getLength(), this.address, this.port));
            System.out.println(address + " " + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getPort() {
        return port;
    }

    public InetAddress getAddress() {

        return address;
    }
}
