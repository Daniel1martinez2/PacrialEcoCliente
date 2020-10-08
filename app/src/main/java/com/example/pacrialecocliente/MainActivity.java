package com.example.pacrialecocliente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import java.util.UUID;

public class MainActivity extends AppCompatActivity implements ObserverMessage {
    SingletonC1 tcp;
    private Button ok;
    private EditText name;
    Gson gson = new Gson();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ok = findViewById(R.id.ok);
        name = findViewById(R.id.name);

        tcp = SingletonC1.getInstance();
        tcp.suscription(this);

        ok.setOnClickListener(
                (v)->{
                   String nombre =  name.getText().toString();
                   Coordenada startCord = new Coordenada(50,50, UUID.randomUUID().toString());
                   ColorFill startColor = new ColorFill(0,0,0,UUID.randomUUID().toString());
                    User userone = new User(nombre, UUID.randomUUID().toString(),startCord,startColor);
                    String sended= gson.toJson(userone);
                    tcp.sendMessage(sended);
                    Intent i = new Intent(this, control.class);
                    startActivity(i);

                }
        );
    }

    @Override
    public void readMessage(String a) {

    }
}