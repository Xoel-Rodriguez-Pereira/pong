package org.xoelrp.pong.game_panel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import org.xoelrp.pong.objects.Ball;
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

    public static boolean LPTopColision, LPBottomColision, RPTopColision, RPBottomColision;

    public int movement;
    public Ball ball;

    public int ballSpeed;
    public int verticalDir;
    public int horizonalDir;

    private int leftScore;
    private int rightScore;

    public PlayManager() {
        left_x = 0;
        right_x = left_x + WIDTH;
        top_y = 0;
        bottom_y = top_y + HEIGHT;

        movement = HEIGHT / 20;

        // Left paddle
        leftPaddle = new Paddle(50, -1);

        // Right paddle
        rightPaddle = new Paddle(right_x - 50, 1);

        // Ball
        ball = new Ball(right_x / 2);
        ballSpeed = 3;
        verticalDir = 1;
        horizonalDir = -1;

        // Score
        leftScore = 0;
        rightScore = 0;
    }

    public void update() {
        checkColision();

        if (KeyHandler.wKeyPress & !LPTopColision) {
            leftPaddle.updateY(-movement);
            KeyHandler.wKeyPress = false;
        } else {KeyHandler.wKeyPress = false;}
        if (KeyHandler.sKeyPress & !LPBottomColision) {
            leftPaddle.updateY(movement);
            KeyHandler.sKeyPress = false;
        } else {KeyHandler.sKeyPress = false;}
        if (KeyHandler.upKeyPress & !RPTopColision) {
            rightPaddle.updateY(-movement);
            KeyHandler.upKeyPress = false;
        } else {KeyHandler.upKeyPress = false;}
        if (KeyHandler.downKeyPress & !RPBottomColision) {
            rightPaddle.updateY(movement);
            KeyHandler.downKeyPress = false;
        } else {KeyHandler.downKeyPress = false;}

        ball.updateXY(ballSpeed * horizonalDir, ballSpeed * verticalDir);
    } 
    
    public void checkColision() {
        // Left Paddle
        if (leftPaddle.y - movement < top_y) {
            LPTopColision = true;
        } else if (leftPaddle.y + leftPaddle.HEIGHT + movement > bottom_y) {
            LPBottomColision = true;
            LPTopColision = false;
        } else { 
            LPTopColision = false;
            LPBottomColision = false;
        }

        // Right Paddle
        if (rightPaddle.y - movement < top_y) {
            RPTopColision = true;
        } else if (rightPaddle.y + rightPaddle.HEIGHT + movement > bottom_y) {
            RPBottomColision = true;
            RPTopColision = false;
        } else { 
            RPTopColision = false;
            RPBottomColision = false;
        }

        // Ball
        // Vertical
        if (ball.y - ball.d/2 - ballSpeed < top_y) {
            verticalDir = 1;
        } else if (ball.y + ball.d/2 + ballSpeed > bottom_y) {
            verticalDir = -1;
        }
        // Horizontal
            // Against paddle
        if (ball.x + ball.d + ballSpeed > rightPaddle.x 
                    & ball.y >= rightPaddle.y 
                    & ball.y <= rightPaddle.y + rightPaddle.HEIGHT) {
            horizonalDir = -1;
            ballSpeed += 1;
        } else if (ball.x - ball.d/2 - ballSpeed < leftPaddle.x + leftPaddle.WIDTH
                    & ball.y >= leftPaddle.y 
                    & ball.y <= leftPaddle.y + leftPaddle.HEIGHT) {
            horizonalDir = 1;
            ballSpeed += 1;
        }
            // Against border
        if (ball.x + ball.d + ballSpeed > right_x) {
            horizonalDir = -1;
            ballSpeed = 3;
            leftScore += 1;
            ball.setXY(right_x / 2, PlayManager.HEIGHT / 2);
        } else if (ball.x - ball.d/2 - ballSpeed < left_x) {
            horizonalDir = 1;
            ballSpeed = 3;
            rightScore += 1;
            ball.setXY(right_x / 2, PlayManager.HEIGHT / 2);
        }
    }

    public void draw(Graphics2D g2) {
        // Draw middle line
        g2.setColor(Color.WHITE);
        float[] dashed = {HEIGHT / 20, HEIGHT / 20};
        g2.setStroke(new BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1f, dashed,0));
        g2.drawLine(right_x / 2 - 1, top_y - HEIGHT / 40, right_x / 2 - 1, bottom_y);

        // Draw paddles
        if (leftPaddle != null) {
            leftPaddle.draw(g2);
        }
        if (rightPaddle != null) {
            rightPaddle.draw(g2);
        }

        // Draw ball
        if (ball != null) {
            ball.draw(g2);
        }

        // Draw scores
        g2.drawString("%d".formatted(leftScore), right_x / 4, bottom_y / 40);
        g2.drawString("%d".formatted(rightScore), right_x / 4 * 3, bottom_y / 40);
    }
}
