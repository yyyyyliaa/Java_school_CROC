package ru.croc.task11;

import java.net.*; 
import java.io.*;
import java.util.Scanner;

public class Client{

    private Socket socket;
    private String username;

    public BufferedReader reader;
    public BufferedWriter writer;


    public Client(Socket socket, String username){
        try{
            this.socket = socket;
            this.username = username;
            this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e){
        }
        
    }

    public void sendMessage(){
        try{
            writer.write(username + "\n");
            writer.flush();

            Scanner sc = new Scanner(System.in);
            while(socket.isConnected()){
                String message = sc.nextLine();
                writer.write(username + ": " + message + "\n");
                writer.flush();
            }
            sc.close();
        }catch (IOException e){

        }
    }

    public void receiveMessage(){
        new Thread(new Runnable() {
            @Override
            public void run(){
                String message;

                while(socket.isConnected()){
                    try{
                        message = reader.readLine();
                        System.out.println(message);
                    } catch (IOException e){

                    }
                }
            }
        }).start();;
    }

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String username = sc.nextLine();

        Socket socket = new Socket("127.0.0.1", 8000);

        Client client = new Client(socket, username);
        client.sendMessage();
        client.receiveMessage();
        
        sc.close();
        
    }


    // public static void main(String[] args) throws IOException{
    //     Socket clientSocket = new Socket("127.0.0.1", 8000);
    //     Scanner s = new Scanner(System.in);


    //     OutputStreamWriter writer = 
    //         new OutputStreamWriter(
    //             clientSocket.getOutputStream());
                     
    //     BufferedReader reader = 
    //         new BufferedReader(
    //             new InputStreamReader(
    //                 clientSocket.getInputStream()));


    //     System.out.print("Enter your nickname: ");
    //     String nickname = s.nextLine();
    //     writer.write(nickname + "\n");
    //     writer.flush();

    //     String message1 = "";
    //     String message2 = "";


    //     System.out.println("Start chat!");
    //     while(true){
    //         message1 = s.nextLine();
    //         writer.write(message1 + "\n");
    //         writer.flush();
    //         message2 = reader.readLine();
    //         System.out.println(message2);
    //         if(message2.equals("Chat stopped")) break;
    //     }
        

        
    //     s.close();
    //     writer.close();
    //     reader.close();
    //     clientSocket.close();
    // }

    // public void run(){
        
    // }
    
}
