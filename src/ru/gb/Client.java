package ru.gb;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Client {

    private Socket socket;
    private final AtomicBoolean isAlive = new AtomicBoolean(true);
    private DataInputStream in;
    private DataOutputStream out;

    public Client() {
    }

    public void start() {
        init();
        listenMessages();
    }

    private void init() {
        try {
            socket = new Socket("localhost", 8899);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void listenMessages() {
        new Thread(() -> {
            try {
                while (true) {
                    String inboundMessage = in.readUTF();
                    if (inboundMessage.equals(Server.EXIT_MSG)) {
                        isAlive.set(false);
                        System.out.println("Please press ENTER to close client...");
                        break;
                    }
                    System.out.println("CLIENT ECHO: get " + "\"" + inboundMessage + "\"");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        })
                .start();
    }

    public void sendMessageToServer(String message) {
        try {
                if (!isAlive.get()) {
                    System.out.println("Client closing...");
                    System.out.println("STATUS OK.");
                    return;
                }
                out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
