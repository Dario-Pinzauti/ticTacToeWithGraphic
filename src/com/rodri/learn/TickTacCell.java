package com.rodri.learn;

import javax.swing.*;
import java.awt.*;

public class TickTacCell extends JButton {

   private Player player;

    public TickTacCell() {
        initCell();
    }

    private void initCell() {
        player = new Player("",0);
    }

    @Override
    public void paint(Graphics g) {
        setText(player.getName());
        setBackground(player.getColor());
        super.paint(g);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
        repaint();
    }
}
