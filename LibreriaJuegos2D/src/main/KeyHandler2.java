package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler2 implements KeyListener {
    public boolean upPressed, downPressed, leftPressed, rightPressed;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_I){
            upPressed = true;
        }
        if(code == KeyEvent.VK_K){
            downPressed = true;
        }
        if(code == KeyEvent.VK_J){
            leftPressed = true;
        }
        if(code == KeyEvent.VK_L){
            rightPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_I){
            upPressed = false;
        }
        if(code == KeyEvent.VK_K){
            downPressed = false;
        }
        if(code == KeyEvent.VK_J){
            leftPressed = false;
        }
        if(code == KeyEvent.VK_L){
            rightPressed = false;
        }
    }
}
