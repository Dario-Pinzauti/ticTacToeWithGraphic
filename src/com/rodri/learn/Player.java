package com.rodri.learn;

import java.awt.*;

public class Player {
     private String name;
    private int value;
    private Color color ;

    public Player(String name, int value) {
        this.name = name;
        this.value = value;
        color = new Color(255,255,255);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
