package entity;

import main.KeyHandler2;
import main.Panel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player2 extends Entity{
    Panel gp;
    KeyHandler2 keyH2;

    public Player2(Panel gp, KeyHandler2 keyH2){
        this.gp = gp;
        this.keyH2 = keyH2;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        x = 200;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage(){
        try {
            up1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/jugador2.png"));
            down1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/jugador2.png"));
            left1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/jugador2.png"));
            right1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/jugador2.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void update(){
        if(keyH2.upPressed){
            direction = "up";
            y -= speed;
        }
        else if(keyH2.downPressed){
            direction = "down";
            y += speed;
        }
        else if (keyH2.leftPressed){
            direction = "left";
            x -= speed;
        }
        else if(keyH2.rightPressed){
            direction = "right";
            x += speed;
        }
    }

    public void draw(Graphics2D g2){

        BufferedImage image = null;

        switch (direction){
            case "up":
                image = up1;
                break;
            case "down":
                image = down1;
                break;
            case "left":
                image = left1;
                break;
            case "right":
                image = right1;
                break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
