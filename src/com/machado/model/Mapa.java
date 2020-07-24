package com.machado.model;

import processing.core.PApplet;

public class Mapa {

    private static final int SIZE = 100;

    private final PApplet view;
    private Tile[][] mapa;

    public Mapa(PApplet view) {
        this.view = view;
        initMapa();
    }

    private void initMapa() {
        mapa = new Tile[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                mapa[i][j] = new Tile(view, i * Tile.SIZE, j * Tile.SIZE);
            }
        }
    }

    public void draw() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                mapa[i][j].draw();
            }
        }
    }
}
