package ru.croc.task11;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientThread implements Runnable{

    public static ArrayList<ClientThread> users = new ArrayList<>();
    private Socket socket;
    private String username;

    private BufferedReader reader;
    private BufferedWriter writer;
    

    ClientThread(Socket socket) {
        try {
            this.socket = socket;
            this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.username = reader.readLine();
            users.add(this);
            messageForAll("*" + username + " joined the chat*");
        } catch (IOException e) {
            closeAll(socket, reader, writer);
        }
    }

    @Override
    public void run() {
        String messageFromClient;

        while (socket.isConnected()) {
            try {
                messageFromClient = reader.readLine();
                messageForAll(messageFromClient);
            } catch (IOException e) {
                closeAll(socket, reader, writer);
                break;
            }
        }
    }

    public void messageForAll(String messageToSend) {
        for (ClientThread user : users) {
            try {
                if (!user.username.equals(username)) {
                    user.writer.write(messageToSend);
                    user.writer.newLine();
                    user.writer.flush();
                }
            } catch (IOException e) {
                closeAll(socket, reader, writer);
            }
        }
    }

    public void removeClientThread() {
        users.remove(this);
        messageForAll("*" + username + " has left the chat*");
    }

    public void closeAll(Socket socket, BufferedReader reader, BufferedWriter writer) {
        removeClientThread();
        try {
            if (reader != null) {
                reader.close();
            }
            if (writer != null) {
                writer.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e){
        }
    }
}