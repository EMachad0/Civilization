package com.machado.model;

import com.machado.controller.Camera;
import processing.core.PApplet;
import processing.event.KeyEvent;

public class World {

    private boolean isVisible = false;
    private boolean isPause = false;

    private final PApplet view;

    private Camera camera;
    private Mapa mapa;

    public World(PApplet view) {
        this.view = view;

        initObj();
    }

    private void initObj() {
        camera = new Camera(view);
        mapa = new Mapa(view);
    }

    public void draw() {
        if (isVisible) {
            camera.translate();
            mapa.draw();
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

    public void keyPressed(KeyEvent event) {
        if (isVisible && !isPause) {
            camera.keyPressed(event);
        }
    }
}
