package org.xoelrp.pong.game_panel;

import java.awt.Graphics2D;

import org.xoelrp.pong.objects.Paddle;

public class PlayManager {
    // Main Play Area
    public static int HEIGHT = 720;
    public static int WIDTH = 1280;
    public static int left_x;
    public static int right_x;
    public static int top_y;
    public static int bottom_y;

    public Paddle leftPaddle;
    public Paddle rightPaddle;

    public PlayManager() {
        left_x = 0;
        right_x = left_x + WIDTH;
        top_y = 0;
        bottom_y = top_y + HEIGHT;

        // Left paddle
        leftPaddle = new Paddle(50, -1);

        // Right paddle
        rightPaddle = new Paddle(right_x - 50, 1);
    }

    public void update() {
    } 
    

    public void draw(Graphics2D g2) {
        // Draw paddles
        if (leftPaddle != null) {
            leftPaddle.draw(g2);
        }
        if (rightPaddle != null) {
            rightPaddle.draw(g2);
        }
    }
}
