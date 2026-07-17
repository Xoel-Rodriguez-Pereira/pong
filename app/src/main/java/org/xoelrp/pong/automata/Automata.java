package org.xoelrp.pong.automata;


import org.xoelrp.pong.game_panel.KeyHandler;
import org.xoelrp.pong.objects.Ball;
import org.xoelrp.pong.objects.Paddle;

public class Automata {
    private final int REACTION_TIME = 3; //Frames between movements
    int actualFrame = 0;
    private Ball ball;
    private Paddle paddle;

    public Automata(Ball ball, Paddle paddle) {
        this.ball = ball;
        this.paddle = paddle;
    }

    public void move() {
        if (actualFrame == REACTION_TIME) {
            if (ball.y < paddle.y - 10) {
                KeyHandler.upKeyPress = true;
            } else if (ball.y > paddle.y + paddle.HEIGHT + 10) {
                KeyHandler.downKeyPress = true;
            }
            actualFrame = 0;
        } else {
            actualFrame++;
        }
    }
}
