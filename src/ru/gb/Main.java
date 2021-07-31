package ru.gb;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Server server = new Server();
        new Thread(server::start).start();
        Client client = new Client();
        new Thread(client::start).start();

        Thread.sleep(1000);

        client.sendMessageToServer("Hello");
        client.sendMessageToServer("This is a test");

        Thread.sleep(1000);

        server.sendMessageToClient("Hi");
        server.sendMessageToClient("Ok");

        Thread.sleep(1000);
        client.sendMessageToServer(Server.EXIT_MSG);

    }
}
