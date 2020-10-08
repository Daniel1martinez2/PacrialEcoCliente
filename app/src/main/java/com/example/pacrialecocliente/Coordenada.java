package com.example.pacrialecocliente;

public class Coordenada {

    int x,y;
    String id, type;
    public Coordenada() {
        // TODO Auto-generated constructor stub
    }
    public Coordenada(int x, int y, String id) {
        this.x = x;
        this.y = y;
        this.id = id = "coord";
        type = "coordenada";

    }



    public String getId() {
        return id;
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }



}

