package org.xoelrp.pong.objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import org.xoelrp.pong.game_panel.PlayManager;

public class Ball {
    public int x, y;
    public int d = (PlayManager.HEIGHT / 40);
    public int side;
    public Color color = Color.WHITE;

    public Ball(int x) {
        this.x = x;
        this.y = PlayManager.HEIGHT / 2;
    }
    
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void updateXY(int xSpeed, int ySpeed) {
        this.x += xSpeed;
        this.y += ySpeed;
    }

    public void draw(Graphics2D g2) {
        g2.setColor(color);
        g2.fill(new Ellipse2D.Double(x - d/2, y - d/2, d, d));
    }
}
