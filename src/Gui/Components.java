package Gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Components {

    // -------------------------------------------------- Self instance
    private static final Components COMPONENTSINSTANCE = new Components();
    private Components() {}

    public static Components getInstance() {
        return COMPONENTSINSTANCE;
    }


    // -------------------------------------------------- Components methods
    public JFrame createJFrame(String title, int x, int y, int width, int height) {
        JFrame frame = new JFrame(title);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setBounds(x, y, width, height);

        return frame;
    }

    public Image ImageComponent(String path) {
        return new ImageIcon(path).getImage();
    }

    public Image resizeImage(Image img, int x, int y) {
        return img.getScaledInstance(x, y, 4);
    }

    public JLabel testPlayer(Image img,int x, int y, int width, int height) {
        JLabel player = new JLabel(new ImageIcon(img));
        player.setBounds(x, y, width, height);

        return player;
    }
}
