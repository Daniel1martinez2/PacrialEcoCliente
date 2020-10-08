package com.example.pacrialecocliente;


public class User {
    String name, id,type;
    Coordenada cord;
    ColorFill col;
    public User(String name, String id,  Coordenada cord, ColorFill col) {
        this.id = id;
        this.name = name;
        type = "user";
        this.col = col;
        this.cord = cord;


    }
    public User(){

    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public Coordenada getCord() {
        return cord;
    }
    public void setCord(Coordenada cord) {
        this.cord = cord;
    }
    public ColorFill getCol() {
        return col;
    }
    public void setCol(ColorFill col) {
        this.col = col;
    }


}
