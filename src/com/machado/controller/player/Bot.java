package com.machado.controller.player;

import com.machado.controller.Civilization;

public class Bot extends Player {

    public Bot(int id, Civilization civ) {
        super(id, civ);
    }

    @Override
    public void play() {
        System.out.println("Bot " + id + "jogou");
    }
}
