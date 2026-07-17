package org.xoelrp.pong.game_panel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public static boolean upKeyPress, downKeyPress, wKeyPress, sKeyPress, enter, paused;

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
        if (code == KeyEvent.VK_ENTER) {
            enter = true;
        }
        if (code == KeyEvent.VK_ESCAPE & !paused) {
            paused = true;
        } else if (code == KeyEvent.VK_ESCAPE & paused) {
            paused = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}  
}