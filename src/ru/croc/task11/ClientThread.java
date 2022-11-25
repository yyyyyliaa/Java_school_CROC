package ru.croc.task11;

import java.net.*;
import java.util.ArrayList;
import java.io.*;

public class ClientThread extends Thread{

    public static ArrayList<ClientThread> users = new ArrayList<>();

    private Socket socket;
    private String username;

    public BufferedReader reader;
    public BufferedWriter writer;

    

    public ClientThread(Socket socket) throws IOException{
        try{
            this.socket = socket;
            this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.username = reader.readLine();
            users.add(this); 
            messageForAll("*" + username + "joined the chat*");
        }catch(IOException e){
            socket.close();
            reader.close();
            writer.close();
        }
    }

    @Override
    public void run() { 
        String message; 

        while(socket.isConnected()){
            try{
                message = reader.readLine();
                messageForAll(message);
            } catch (IOException e){
            }
        }
    }

    public void messageForAll(String message) throws IOException{

        for(ClientThread user : users){
            if(!user.username.equals(this.username)){
                user.writer.write(message + "\n");
                user.writer.flush();
            }
        }

    }

    public void removeClientThread() throws IOException{
        users.remove(this);
        messageForAll(username + "has left the chat");
    }

    public void closeAll(Socket socket, BufferedReader reader, BufferedWriter writer) throws IOException{
        removeClientThread();
        if(socket != null) socket.close();
        if (reader != null) reader.close();
        if(writer != null) writer.close();
    }
}
