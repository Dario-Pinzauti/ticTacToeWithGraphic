package com.rodri.learn;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;

public class BoardGame extends JPanel {

    Player winner = null;
    Player player1;
    Player player2;

    TickTacCell[][] matrixGame = new TickTacCell[3][3];

    Player turn;

    public BoardGame() {
        initGame();
    }

    private void initGame() {
        GridLayout gridLayout = new GridLayout(3, 3);
        setLayout(gridLayout);
        player1 = new Player("player1", 2);
        player2 = new Player("player2", 3);

        turn = player1;
        //init
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                TickTacCell cell = new TickTacCell();
                cell.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseReleased(MouseEvent e) {
                        if (cell.getPlayer().getValue() == 0 && winner == null) {
                            cell.setPlayer(turn);
                            Integer valid = validateGrid();
                            if (valid != 0) {
                                endGame(valid);
                            }
                            turn = turn.equals(player1) ? player2 : player1;
                        }
                    }
                });
                matrixGame[i][j] = cell;
                add(cell);

            }

        }

    }

    private void endGame(Integer validate) {
        winner = player1.getValue() == validate ? player1:player2;
        repaint();

    }

    private Integer validateGrid() {

        ArrayList<Integer> winnerList = new ArrayList<>();
        winnerList.add(27);
        winnerList.add(8);

        int d1 = matrixGame[0][0].getPlayer().getValue();
        int d2 = matrixGame[0][2].getPlayer().getValue();
        for (int i = 0; i < 3; i++) {
            if(i>0) {
                d1*=matrixGame[i][i].getPlayer().getValue();
                d2*=matrixGame[i][2-i].getPlayer().getValue();
            }
            int x = matrixGame[i][0].getPlayer().getValue();
            int y = matrixGame[0][i].getPlayer().getValue();
            for (int j = 1; j < 3; j++) {
                x *= matrixGame[i][j].getPlayer().getValue();
                y *= matrixGame[j][i].getPlayer().getValue();

            }
            if(winnerList.contains(x)||winnerList.contains(y)){
                double v ;
                if(x>0){
                    v  = Math.pow(x, (double) 1 / 3);
                    for (int j = 0; j < 3; j++) {
                        matrixGame[i][j].getPlayer().setColor(new Color(108, 148, 114));
                    }
                }else{
                    v= Math.pow(y, (double) 1 / 3);
                    for (int j = 0; j < 3; j++) {
                        matrixGame[j][i].getPlayer().setColor(new Color(108, 148, 114));

                    }
                }
                return (int)v;
            }
        }
        if(winnerList.contains(d1)||winnerList.contains(d2)){
            double v;
            if(d1>0) {
                v= Math.pow(d1, (double) 1 / 3);
                for (int i = 0; i < 3; i++) {
                    matrixGame[i][i].getPlayer().setColor(new Color(108, 148, 114));
                }
            }else{
                v= Math.pow(d2, (double) 1 / 3);
                for (int i = 0; i < 3; i++) {
                    matrixGame[i][2-i].getPlayer().setColor(new Color(108, 148, 114));
                }
            }
            return (int)v;
        }
        return 0;
    }


}
