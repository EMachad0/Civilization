package com.machado.view.menus;

import com.machado.controller.MenuController;
import com.machado.view.MainLoop;
import g4p_controls.GButton;
import processing.core.PApplet;
import processing.core.PImage;
import processing.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;

public abstract class Menu {

    public static final int btnWidth = 200;
    public static final int btnHeight = 50;

    private boolean isVisible = true;
    private String menuId;
    protected final MenuController controller;

    protected MainLoop view;
    protected PImage background;
    protected List<GButton> buttons = new LinkedList<>();

    public Menu(MainLoop view, MenuController controller) {
        this.view = view;
        this.controller = controller;

        setId(initId());
        addBackground();
        addButtons();
    }

    protected abstract String initId();

    protected void addBackground() {}

    protected void addButtons() {}

    public void keyPressed(KeyEvent event) {}

    public void draw() {
        if (isVisible) {
            if (background != null) view.image(background, 0, 0);
        }
    }

    public void show() {
        isVisible = true;
        buttons.forEach(b -> b.setVisible(true));
    }

    public void hide() {
        isVisible = false;
        buttons.forEach(b -> b.setVisible(false));
    }

    public String getId() {
        return menuId;
    }

    private void setId(String s) {
        this.menuId = s;
    }

    public boolean isVisible() {
        return isVisible;
    }

    protected void changeToGame() {
        view.getWorld().setVisible(true);
        view.getWorld().setPause(false);
        controller.changeMenu("GameMenu");
    }
}
