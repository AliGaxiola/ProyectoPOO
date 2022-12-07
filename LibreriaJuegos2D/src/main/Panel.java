package main;

import entity.Player;
import entity.Player2;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel implements Runnable{

    private Graphics2D g2 = null;

    final int originalTileSize = 16;
    final int scale = 3;

    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    //FPS
    int FPS = 60;

    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    KeyHandler2 keyH2 = new KeyHandler2();
    Thread gameThread;
    Player player = new Player(this,keyH);
    Player2 player2 = new Player2(this,keyH2);

    private boolean isTile = false;
    private boolean isPlayer = false;
    private boolean isPlayer2 = false;

    public Panel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.addKeyListener(keyH2);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run(){
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null){

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1){
                update();
                repaint();
                delta--;
                drawCount++;
            }
            if(timer>=1000000000){
                System.out.println("FPS: "+ drawCount) ;
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update(){
        player.update();
        player2.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g2 = (Graphics2D)g;

        settings();

        g2.dispose();
    }

    public void agregarFondo(boolean fondo) {
        isTile = fondo;
    }

    public void agregarPlayer1(boolean player) {
        isPlayer = player;

    }

    public void agregarPlayer2(boolean player2) {
        isPlayer2 = player2;
    }

    private void settings() {
        if(isTile)
            tileM.draw(g2);
        if(isPlayer)
            player.draw(g2);
        if(isPlayer2)
            player2.draw(g2);
    }
}
