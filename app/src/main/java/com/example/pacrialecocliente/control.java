package com.example.pacrialecocliente;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import java.util.UUID;

public class control extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener, ObserverMessage {
    private Button up;
    private Button down;
    private Button right;
    private Button left;
    private Button color;
    Gson gson = new Gson();
    SingletonC1 tcp;
    boolean buttonTrue = false;
    Coordenada c = new Coordenada(50,50, "");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);

        up = findViewById(R.id.up);
        down = findViewById(R.id.down);
        left = findViewById(R.id.left);
        right = findViewById(R.id.right);
        color = findViewById(R.id.color);

        left.setOnTouchListener(this);
        right.setOnTouchListener(this);
        down.setOnTouchListener(this);
        up.setOnTouchListener(this);
        tcp = SingletonC1.getInstance();
        tcp.suscription(this);
        color = findViewById(R.id.color);
        color.setOnClickListener(this);


    }

    @Override
    public void readMessage(String a) {

    }

    @Override
    public void onClick(View view) {
        ColorFill currentColor = new ColorFill( (int)Math.floor( Math.random()*255),(int)Math.floor( Math.random()*255),(int)Math.floor( Math.random()*255), UUID.randomUUID().toString());
        String coloreando = gson.toJson(currentColor);
        tcp.sendMessage(coloreando);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int x,y, speed;
        speed = 20;
        switch (motionEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                buttonTrue = true;
                new Thread(
                        ()->{
                            while(buttonTrue){
                                switch (view.getId()){
                                    case R.id.up:
                                        c.setY(c.getY()-speed);
                                        break;
                                    case R.id.down:
                                        c.setY(c.getY()+speed);
                                        break;
                                    case R.id.left:
                                        c.setX(c.getX()-speed);
                                        break;
                                    case R.id.right:
                                        c.setX(c.getX()+speed);
                                        break;
                                }
                                c.id = UUID.randomUUID().toString();
                                String json;
                                json = gson.toJson(c);
                                tcp.sendMessage(json);
                                try {
                                    Thread.sleep(20);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                ).start();
                break;
            case MotionEvent.ACTION_UP:
                buttonTrue = false;
                break;
        }
        return true;
    }
}