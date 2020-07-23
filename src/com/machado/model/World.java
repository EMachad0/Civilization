package com.machado.model;

import processing.core.PApplet;

public class World {

    private static final int SIZE = 100;

    private boolean isVisible = false;
    private boolean isPause = false;

    private final PApplet view;
    private Tile[][] mapa;

    public World(PApplet view) {
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
        if (isVisible) {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    mapa[i][j].draw();
                }
            }
        }
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public void setPause(boolean pause) {
        isPause = pause;
    }
}
