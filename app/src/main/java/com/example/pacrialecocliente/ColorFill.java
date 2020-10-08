package com.example.pacrialecocliente;

public class ColorFill {
    int r, g, b;
    String id, type;


    public ColorFill(int r, int g, int b,  String id) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.id = id;
        type = "color";
    }
    public ColorFill(){

    }



    public String getId() {
        return id;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}

