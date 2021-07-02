import Gui.Components;

import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main implements KeyListener{


    Components Components = Gui.Components.getInstance();
    JFrame mainFrame;
    static int frameWidth = 2100, frameHeight = 1050;
    JLabel player;
    static int playerX=0, playerY=850;
    static boolean playerGrounded = true;
    static boolean playerMoving = false;

    Main() {
        // -------------------------------------------------- Main Frame
        mainFrame =  Components.createJFrame("Game", -10, 0, frameWidth, frameHeight);
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainFrame.setIconImage(Components.ImageComponent("src/Resources/controller.png"));
        mainFrame.addKeyListener(this);

        // -------------------------------------------------- Player Setup
        Image playerImg = Components.resizeImage(Components.ImageComponent("src/Resources/PlayerStanding.png"), 64, 64);

        player = Components.testPlayer(playerImg, playerX, playerY, 64, 64);
        mainFrame.add(player);
    }

    public static void main(String[] args) {

        Main main = new Main();
        GravityThread gravThread = new GravityThread();
        gravThread.start();

        // -------------------------------------------------- Run Time
        while (true) {

            main.player.setBounds(playerX, playerY ,64 ,64);
        }
    }

    static class GravityThread extends Thread {
        @Override
        public void run() {
            while (true) {
                if (playerY < 850) {
                    playerY += 4;
                } else {
                    playerGrounded = true;
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ignored) {}
            }
        }
    }

    // -------------------------------------------------- Key Listeners
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_D) { // Right
            playerMoving = true;
            playerX += 20;
        }
        if (key == KeyEvent.VK_A) { // Left
            playerMoving = true;
            playerX -= 20;
        }
        if (key == KeyEvent.VK_W && playerGrounded) { // Jump
            playerY -= 20;
            playerGrounded = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_D) { // Right
            playerMoving = false;
        }
        if (key == KeyEvent.VK_A) { // Left
            playerMoving = false;
        }
    }
}
