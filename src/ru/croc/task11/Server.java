package ru.croc.task11;

import java.net.*; 
import java.io.*;


public class Server {

    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Connected");
        Socket clientSocket =  serverSocket.accept();

        OutputStreamWriter writer = 
            new OutputStreamWriter(
                clientSocket.getOutputStream());

        
        BufferedReader reader = 
            new BufferedReader(
                new InputStreamReader(
                    clientSocket.getInputStream()));


        String username = reader.readLine();
        String inMessage;
        while(true){
            inMessage = reader.readLine();
            if(inMessage.equals("stop")){
                writer.write("Chat stopped" + "\n");
                writer.flush();
                break;
            }
            else{
                String message3 = username + ": " + inMessage;
                writer.write(message3 + "\n");
                writer.flush();
            }
        }

        writer.close();
        reader.close();
        clientSocket.close();
        serverSocket.close();

    }
    
    
}
