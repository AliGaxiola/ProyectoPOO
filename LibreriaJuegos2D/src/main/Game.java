package main;

import javax.swing.*;

public class Game {
    private JFrame window = new JFrame();
    private Panel panel = new Panel();



    public void setGameName(String name){
        if(window != null && name != null)
            window.setTitle(name);
    }

    public void setFondo(boolean mostrar){
        panel.agregarFondo(mostrar);
    }

    public void setPlayer(boolean agregar){
        panel.agregarPlayer1(agregar);
    }

    public void setPlayer2(boolean agregar){
        panel.agregarPlayer2(agregar);
    }

    public void startGame(){
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.add(panel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        panel.startGameThread();
    }

    public void instrucciones(){
        System.out.println("La funcion \"setGameName\" agrega un nombre en la parte superior del Panel.");
        System.out.println("La funcion \"setFondo\" agrega un fondo predeterminado al Panel.");
        System.out.println("La funcion \"setPlayer\" agrega un jugador al Panel. Sus teclas de movimiento son \"W A S D\"");
        System.out.println("La funcion \"setPlayer\" agrega un segundo jugador al Panel. Sus teclas de movimiento son \"I J K L\"");
        System.out.println("La funcion \"starGame\" muestra el Panel y empieza a correr el bucle del juego. Sin esta funcion no se puede ejecutar el programa.");
    }
}