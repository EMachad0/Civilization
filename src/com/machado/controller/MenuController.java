package com.machado.controller;

import com.machado.view.menus.*;
import processing.core.PApplet;
import processing.event.KeyEvent;

import java.util.Map;
import java.util.TreeMap;

public class MenuController {

    private String idCurr;

    private final PApplet view;
    private final Map<String, Menu> menus = new TreeMap<>();

    public MenuController(PApplet view) {
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

    public void keyPressed(KeyEvent event) {
        menus.get(idCurr).keyPressed(event);
    }
}
