package org.xoelrp.pong.game_panel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public static boolean upKeyPress, downKeyPress, wKeyPress, sKeyPress, paused, retry, mute, debug, step;

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            wKeyPress = true;
        }
        if (code == KeyEvent.VK_S) {
            sKeyPress = true;
        }
        if (code == KeyEvent.VK_UP) {
            upKeyPress = true;
        }
        if (code == KeyEvent.VK_DOWN) {
            downKeyPress = true;
        }

        if (code == KeyEvent.VK_1 & !debug) {
            debug = true;
        } else if (code == KeyEvent.VK_1 & debug) {
            debug = false;
        }
        if (code == KeyEvent.VK_L) {
            step = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}  
}