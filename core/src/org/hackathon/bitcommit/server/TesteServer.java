package org.hackathon.bitcommit.server;

/**
 * Created by codecadet on 24/11/16.
 */
public class TesteServer {

    public static void main(String[] args) {
        Server server = new Server();
        Thread thread = new Thread(server);

        thread.start();

    }
}
