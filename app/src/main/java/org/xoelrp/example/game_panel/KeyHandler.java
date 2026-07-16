package org.xoelrp.example.game_panel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public static boolean upKeyPress, downKeyPress, leftKeyPress, rightKeyPress, paused, retry, mute;

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upKeyPress = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}  
}