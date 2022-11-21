package ru.croc.task11;

import java.net.*; 
import java.io.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException{
        Socket clientSocket = new Socket("127.0.0.1", 8000);
        Scanner s = new Scanner(System.in);


        OutputStreamWriter writer = 
            new OutputStreamWriter(
                clientSocket.getOutputStream());
                     
        BufferedReader reader = 
            new BufferedReader(
                new InputStreamReader(
                    clientSocket.getInputStream()));


        System.out.print("Enter your nickname: ");
        String nickname = s.nextLine();
        writer.write(nickname + "\n");
        writer.flush();

        String message1 = "";
        String message2 = "";


        System.out.println("Start chat!");
        while(true){
            message1 = s.nextLine();
            writer.write(message1 + "\n");
            writer.flush();
            message2 = reader.readLine();
            System.out.println(message2);
            if(message2.equals("Chat stopped")) break;
        }
        

        
        s.close();
        writer.close();
        reader.close();
        clientSocket.close();
    }
    
}
