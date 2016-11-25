package org.hackathon.bitcommit.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.*;

/**
 * Created by codecadet on 24/11/16.
 */
public class Server implements Runnable {
    static Map<GameClient, String> map;
    private LinkedList<GameClient> clientList;
    boolean gameOnline;


    public Server() {
        map = new HashMap();
    }

    public static Map<GameClient, String> getMap() {
        return map;
    }

    @Override
    public void run() {
        DatagramSocket socket = null;
        int portNumber = 5000;
        clientList = new LinkedList();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new asteroidGenerator(), 0, 4000);


        try {
            socket = new DatagramSocket(portNumber);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        while (true) {
            System.out.println("----- Server open ------");
            byte[] receiveBuffer = new byte[2048];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);

            if (map.size() == 1 && !gameOnline) {
                gameOnline = true;
            }


            try {
                socket.receive(receivePacket);
                String data = new String(receivePacket.getData());
                //System.out.println("John said this : " + data);

                movePlayer(data, receivePacket);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            if (map.containsValue(String.valueOf(receivePacket.getAddress()))) {
                //System.out.println("Cliente existente");
                System.out.println(clientList.size());

                for (int i = 0; i < clientList.size(); i++) {
                    if (clientList.get(i).getAddress().equals(receivePacket.getAddress())) {
                        continue;
                    } else {
                        //System.out.println(clientList.get(i).getAddress() + "receive adress " + receivePacket.getAddress());
                        clientList.get(i).sendPacket(receivePacket);
                        continue;
                    }
                }
            } else {

                String ip = String.valueOf(receivePacket.getAddress());
                GameClient client = null;
                try {
                    client = new GameClient(receivePacket, socket);
                } catch (SocketException e) {
                    e.printStackTrace();
                }

                Thread clientThread = new Thread(client);
                clientThread.start();
                clientList.add(client);
                map.put(client, ip);
                //System.out.println(map.size());

                byte[] sendBuffer = new byte[2048];
                DatagramPacket sendPacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);


                for (int i = 0; i < clientList.size(); i++) {
                    if (clientList.get(i).getAddress().equals(receivePacket.getAddress())) {
                        continue;
                    } else {
                        System.out.println(clientList.get(i).getAddress() + "receive new address " + receivePacket.getAddress());
                        clientList.get(i).sendPacket(receivePacket);
                        continue;
                    }
                }
            }
        }
    }

    private void movePlayer(String data, DatagramPacket datagramPacket) throws IOException, ClassNotFoundException {
        //System.out.println("before sending the message");
        if (map.containsValue(String.valueOf(datagramPacket.getAddress()))) {
            System.out.println("sending message");
        }
    }

    public class asteroidGenerator extends TimerTask {

        @Override
        public void run() {
            String asteroidPlace = String.valueOf((int) (Math.floor(Math.random() * 9) + 1));


            System.out.println("asteroide na posiçao " + asteroidPlace.toString());
            DatagramPacket asteroidPacked = new DatagramPacket(asteroidPlace.getBytes(), asteroidPlace.getBytes().length);
            for (int i = 0; i < clientList.size(); i++) {
                clientList.get(i).sendPacket(asteroidPacked);
            }




        }
    }
}