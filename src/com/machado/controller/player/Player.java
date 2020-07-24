package com.machado.controller.player;

import com.machado.controller.Civilization;

public abstract class Player {

    protected final int id;
    protected final Civilization civ;

    public Player(int id, Civilization civ) {
        this.id = id;
        this.civ = civ;
    }

    public abstract void play();
}
