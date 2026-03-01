import AllForMap.MapGenerator;

import javax.swing.*;
import javax.swing.text.html.ImageView;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DisplayFrame extends JFrame {

    DisplayFrame(){

        MapGenerator mapGen = new MapGenerator();
        mapGen.GenerateMap();
        BufferedImage background = mapGen.mapImage;

        JLabel label = new JLabel();
        label.setSize(1100,900);
        BufferedImage resized = resize(background,1100,900);
        ImageIcon image = new ImageIcon(resized);
        label.setIcon(image);

        this.setTitle("TerrainTest");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1100,900);
        this.setLayout(null);
        this.setVisible(true);

        this.add(label);
    }
    public static BufferedImage resize(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }
}
