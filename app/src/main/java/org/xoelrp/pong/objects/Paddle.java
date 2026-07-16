package org.xoelrp.pong.objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import org.xoelrp.pong.game_panel.PlayManager;

public class Paddle extends Rectangle {
    public int x, y;
    public int HEIGHT = 150;
    public int WIDTH = 15;
    public int side;
    public Color color = Color.WHITE;

    public Paddle(int x, int side) {
        this.x = x;
        this.y = PlayManager.HEIGHT / 2 - HEIGHT / 2;
        this.side = side;
    }

    public void draw(Graphics2D g2) {
        g2.setColor(color);
        g2.fillRect(x - (WIDTH / 2 + (WIDTH / 2) * side), y, WIDTH, HEIGHT);
    }
}
