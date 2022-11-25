package ru.croc.task11;

import java.net.*; 
import java.io.*;


public class Server{

    private ServerSocket serverSocket;

    public Server(ServerSocket serverSocket){
        this.serverSocket = serverSocket;
    }

    public void startServer() throws IOException{
        while(!serverSocket.isClosed()){
            Socket socket = serverSocket.accept();
            System.out.println("New user connected");
            ClientThread clientThread = new ClientThread(socket); 

            Thread t = new Thread(clientThread);
            t.start();
        }
    }

    public void closeServerSocket() throws IOException{
        if(serverSocket != null){
            serverSocket.close();
        }
    }



    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = new ServerSocket(8000);
        Server server = new Server(serverSocket);
        server.startServer(); 
        // System.out.println("Connected");
        
        // Socket clientSocket =  serverSocket.accept();

        // OutputStreamWriter writer = 
        //     new OutputStreamWriter(
        //         clientSocket.getOutputStream());

        
        // BufferedReader reader = 
        //     new BufferedReader(
        //         new InputStreamReader(
        //             clientSocket.getInputStream()));


        // String username = reader.readLine();
        // String inMessage;
        // while(true){
        //     inMessage = reader.readLine();
        //     if(inMessage.equals("/stop")){
        //         writer.write("Chat stopped" + "\n");
        //         writer.flush();
        //         break;
        //     }
        //     else{
        //         String message3 = username + ": " + inMessage;
        //         writer.write(message3 + "\n");
        //         writer.flush();
        //     }
        // }

        // writer.close();
        // reader.close();
        // clientSocket.close();
        // serverSocket.close();

    }
}
