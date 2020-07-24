package com.machado.controller;

import com.machado.controller.player.Player;

import java.util.List;

public class TurnSystem {

    private int turn = 0;
    private Player isPlaying;

    private void nextTurn(List<Player> players) {
        for (Player p : players) {
            isPlaying = p;
            p.play();
        }
        turn++;
    }

    public int getTurn() {
        return turn;
    }
}
