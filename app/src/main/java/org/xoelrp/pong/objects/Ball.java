package org.xoelrp.pong.objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import org.xoelrp.pong.game_panel.PlayManager;

public class Ball {
    public int x, y;
    public int r = (PlayManager.HEIGHT / 40);
    public int side;
    public Color color = Color.WHITE;

    public Ball(int x) {
        this.x = x;
        this.y = PlayManager.HEIGHT / 2;
    }

    public void updateXY(int xSpeed, int ySpeed) {
        this.x += xSpeed;
        this.y += ySpeed;
    }

    public void draw(Graphics2D g2) {
        g2.setColor(color);
        g2.fill(new Ellipse2D.Double(x - r/2, y - r/2, r, r));
        g2.setColor(Color.RED);
        g2.draw(new Line2D.Double(x-1,y-1,x+1,y+1));
    }
}
