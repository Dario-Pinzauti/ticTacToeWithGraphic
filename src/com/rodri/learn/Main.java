package com.rodri.learn;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {


        JFrame jFrame = new JFrame();
        BoardGame boardGame = new BoardGame();
        jFrame.setContentPane(boardGame);
        jFrame.setSize(500,500);
        jFrame.setVisible(true);

    }
}
