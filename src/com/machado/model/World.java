package com.machado.model;

import com.machado.controller.Camera;
import com.machado.controller.Civilization;
import com.machado.controller.player.Bot;
import com.machado.controller.player.Human;
import com.machado.controller.player.Player;
import processing.core.PApplet;
import processing.event.KeyEvent;

import java.util.ArrayList;
import java.util.List;

public class World {

    private boolean isVisible = false;
    private boolean isPause = false;

    private final PApplet view;

    private Camera camera;
    private Mapa mapa;

    private final List<Player> players = new ArrayList<>();

    public World(PApplet view) {
        this.view = view;

        initObj();
    }

    private void initObj() {
        camera = new Camera(view);
        mapa = new Mapa(view);

        initPlayers();
    }

    private void initPlayers() {
        players.add(new Human(0, new Civilization(0)));
        players.add(new Bot(1, new Civilization(1)));
        players.add(new Bot(2, new Civilization(2)));
        players.add(new Bot(3, new Civilization(3)));
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
