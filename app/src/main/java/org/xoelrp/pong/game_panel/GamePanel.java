package org.xoelrp.pong.game_panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
    static Integer HEIGHT = 720;
    static Integer WIDTH =  1280;

    final private Integer objetiveFPS = 60;
    Thread gameThread;
    private volatile boolean isRunning = false;

    PlayManager playManager;
    MainMenu mainMenu;

    public static Sound music = new Sound();
    public static Sound soundEffect = new Sound();

    public GamePanel() {

        //GamePanel settings
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.BLACK);
        this.setLayout(null);

        playManager = new PlayManager();
        mainMenu = new MainMenu(WIDTH, HEIGHT);
        
        this.addKeyListener(new KeyHandler());
        this.setFocusable(true);
    }


    public void launchGame() {
        isRunning = true;
        gameThread = new Thread(this);
        gameThread.start(); // Ejecuta run() del GamePanel
        music.play(4, true);
        music.loop();
    }

    @Override
    public void run() {
        // GameLoop
        double drawInterval = 1000000000 / objetiveFPS; // En milisegundos
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (isRunning) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint(); // Llama al metodo paintComponent()
                delta--;
            }
        }
    }

    public void update() {
        if (mainMenu.selected) {
            playManager.update();
        }
        else {
            mainMenu.update();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if (mainMenu.selected) {
            playManager.draw(g2);
        }
        else {
            mainMenu.draw(g2);
        }
    }
}
