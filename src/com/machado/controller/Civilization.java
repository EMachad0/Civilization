package com.machado.controller;

public class Civilization {

    private int id;
    private int color;

    public Civilization(int id, int color) {
        this.id = id;
        this.color = color;
    }

    public Civilization(int id) {
        this.id = id;
        this.color = (int) (Math.random() * 0xffffff);
    }
}
