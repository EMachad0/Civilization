package com.machado.controller;

import processing.core.PApplet;
import processing.event.KeyEvent;

public class Camera {

    private final PApplet view;

    private int x = 0;
    private int y = 0;

    public Camera(PApplet view) {
        this.view = view;
    }

    public Camera(PApplet view, int x, int y) {
        this.view = view;
        this.x = x;
        this.y = y;
    }

    public void translate() {
        view.translate(x, y);
    }

    public void keyPressed(KeyEvent event) {
        System.out.println(event.getKey());
        if (event.getKey() == 'w') y -= 10;
        if (event.getKey() == 's') y += 10;
        if (event.getKey() == 'a') x -= 10;
        if (event.getKey() == 'd') x += 10;
    }
}
