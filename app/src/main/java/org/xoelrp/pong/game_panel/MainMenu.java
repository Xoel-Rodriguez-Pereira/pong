package org.xoelrp.pong.game_panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class MainMenu {
    int right_x, bottom_y;
    public boolean selected;
    static public boolean siglePlayer;
    int currentOption = 0;

    public MainMenu(int x, int y) {
        this.right_x = x;
        this.bottom_y = y;
    }

    public void update() {
        if ((KeyHandler.wKeyPress 
                || KeyHandler.sKeyPress
                || KeyHandler.upKeyPress
                || KeyHandler.downKeyPress) & currentOption == 0) {
            currentOption = 1;
            KeyHandler.wKeyPress=false;
            KeyHandler.sKeyPress=false;
            KeyHandler.upKeyPress=false;
            KeyHandler.downKeyPress=false;
        } else if ((KeyHandler.wKeyPress 
                || KeyHandler.sKeyPress
                || KeyHandler.upKeyPress
                || KeyHandler.downKeyPress) & currentOption == 1) {
            currentOption = 0;
            KeyHandler.wKeyPress=false;
            KeyHandler.sKeyPress=false;
            KeyHandler.upKeyPress=false;
            KeyHandler.downKeyPress=false;
        }
        selectedOption();
    }

    void selectedOption() {
        if (KeyHandler.enter & currentOption == 0) {
            siglePlayer = true;
            selected = true;
        } else if (KeyHandler.enter & currentOption == 1) {
            siglePlayer = false;
            selected = true;
        }
    }

    public void draw(Graphics2D g2) {
        // Title
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Arial", Font.ITALIC, 100));
        g2.drawString("PONG", right_x / 2 - 140, bottom_y / 4);

        // Options
        g2.setFont(new Font("Arial", Font.PLAIN, 50));
        g2.drawString("1 Player", right_x / 2 - 90, (bottom_y / 8) * 4);
        g2.drawString("2 Players", right_x / 2 - 90, (bottom_y / 8) * 5);

        // Selected
        if (currentOption == 0) {
            g2.drawRect(right_x / 2 - 90, (bottom_y / 8) * 4 - 40, 200, 50);
        } else if (currentOption == 1) {
            g2.drawRect(right_x / 2 - 90, (bottom_y / 8) * 5 - 40, 220, 50);
        }
    }
}
