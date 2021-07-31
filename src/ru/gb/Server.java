package ru.gb;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;

public class Server {

    public final static String EXIT_MSG = "-exit";
    private ServerSocket socket;
    private Socket client;
    private DataInputStream in;
    private DataOutputStream out;
    private final AtomicBoolean isAlive = new AtomicBoolean(true);

    public Server() {
    }

    public void start() {
        init();
        listenMessages();
        System.out.println("Closing the connection...");
        System.out.println("Shutting down...");
        System.out.println("STATUS OK.");
    }

    private void init() {
        try {
            socket = new ServerSocket(8899);
            System.out.println("Socket created...");
            System.out.println("Waiting for a connection...");
            client = socket.accept();
            in = new DataInputStream(client.getInputStream());
            out = new DataOutputStream(client.getOutputStream());

            System.out.println("Client connected...");
            System.out.println(client);
            System.out.println("STATUS OK.");
        } catch (IOException e) {
            System.out.println("STATUS NOK.");
            e.printStackTrace();
        }
    }

    private void listenMessages() {
        try {
            while (true) {
                String inboundMessage = in.readUTF();

                System.out.println("SERVER ECHO: get \"" + inboundMessage + "\"");
                if (inboundMessage.equals(EXIT_MSG)) {
                    System.out.println("SERVER ECHO: Good bye!");
                    isAlive.set(false);
                    out.writeUTF(EXIT_MSG);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessageToClient(String message) {
        try {
                if (!isAlive.get()) {
                    System.out.println("Server closing...");
                    System.out.println("STATUS OK.");
                    return;
                }
                out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
