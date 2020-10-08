package com.example.pacrialecocliente;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class SingletonC1 extends Thread {

    //Globales
    private static SingletonC1 uniq;
    private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;

    private ObserverMessage app;
    public void suscription(ObserverMessage app){
        this.app = app;
    }

    public static SingletonC1 getInstance(){
        if(uniq==null){
            uniq = new SingletonC1();
            uniq.start();
        }
        return uniq;
    }
    public void run() {
        try {
            socket = new Socket("192.168.0.10",6000);
            //esperando
            System.out.println("me conecte");
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            reader = new BufferedReader(isr);
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            writer = new BufferedWriter(osw);

            while(true) {
                String line = reader.readLine();
                app.readMessage(line);

            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void sendMessage(String ms) {
        new Thread(
                ()->{
                    try {
                        writer.write(ms+"\n");
                        writer.flush();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

        ).start();
    }
}
