package entity;

import main.KeyHandler;
import main.Panel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{

    Panel gp;
    KeyHandler keyH;

    public Player(Panel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage(){
        try {
            up1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/jugador1.png"));
            down1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/jugador1.png"));
            left1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/jugador1.png"));
            right1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/jugador1.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void update(){
        if(keyH.upPressed){
            direction = "up";
            y -= speed;
        }
        else if(keyH.downPressed){
            direction = "down";
            y += speed;
        }
        else if (keyH.leftPressed){
            direction = "left";
            x -= speed;
        }
        else if(keyH.rightPressed){
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
