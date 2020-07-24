package com.machado.controller;

import com.machado.view.MainLoop;
import com.machado.view.menus.*;
import processing.event.KeyEvent;

import java.util.Map;
import java.util.TreeMap;

public class MenuController {

    private String idCurr;

    private final MainLoop view;
    private final Map<String, Menu> menus = new TreeMap<>();

    public MenuController(MainLoop view) {
        this.view = view;

        initMenus();
        this.idCurr = "MainMenu";
        menus.get(idCurr).show();
    }

    private void initMenus() {
        addMenu(new MainMenu(view, this));
        addMenu(new GameMenu(view, this));
        addMenu(new OptionsMenu(view, this));
        addMenu(new PauseMenu(view, this));
    }

    private void addMenu(Menu menu) {
        menu.hide();
        menus.put(menu.getId(), menu);
    }

    public void changeMenu(String newMenu) {
        try {
            menus.get(idCurr).hide();
            menus.get(newMenu).show();
            idCurr = newMenu;
        } catch (NullPointerException e) {
            System.out.println("ERRO: No menu " + newMenu);
        }
    }

    public void draw() {
        menus.get(idCurr).draw();
    }

    public void postCamDraw() {
        menus.get(idCurr).postCamDraw();
    }

    public void keyPressed(KeyEvent event) {
        menus.get(idCurr).keyPressed(event);
    }

    public void goInGame() {
        view.getWorld().setVisible(true);
        view.getWorld().setPause(false);
        changeMenu("GameMenu");
    }

    public void goOutGame(String newMenu) {
        view.getWorld().setVisible(false);
        view.getWorld().setPause(true);
        changeMenu(newMenu);
    }
}
