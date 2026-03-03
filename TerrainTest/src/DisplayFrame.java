import AllForMap.MapGenerator;

import javax.swing.*;
import javax.swing.text.html.ImageView;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DisplayFrame extends JFrame {

    DisplayFrame(){

        MapGenerator mapGen = new MapGenerator();
        mapGen.GenerateMap();
        BufferedImage perlinNoise = mapGen.mapImage;

        JLabel noise = new JLabel();
        noise.setSize(700,700);
        ImageIcon image = new ImageIcon(perlinNoise);
        noise.setIcon(image);

        JPanel panelMap = new JPanel();
        panelMap.setBounds(0,0,600,600);
        panelMap.setBackground(Color.GRAY);
        panelMap.add(noise);

        JPanel panelControls = new JPanel(new GridBagLayout());
        panelControls.setBounds(600,0,300,600);
        panelControls.setBackground(Color.white);

        GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.WEST;

        Label widthLabel = new Label("Map width:");
        Label heightLabel = new Label("Map height:");
        Label seedLabel = new Label("Noise seed:");
        Label noiseScaleLabel = new Label("Noise scale:");
        Label octavesLabel = new Label("Noise octave:");
        Label persistanceLabel = new Label("Noise persistance:");
        Label lacunarityLabel = new Label("Noise lacunarity:");

        JTextField widthTextField = new JTextField();
        JTextField heightTextField = new JTextField();
        JTextField seedTextField = new JTextField();
        JTextField noiseScaleTextField = new JTextField();
        JTextField octavesTextField = new JTextField();
        JTextField persistanceTextField = new JTextField();
        JTextField lacunarityTextField = new JTextField();

        JButton randomizeSeed = new JButton("Random seed");
        JButton generateNoise = new JButton("Generate noise map");

        gc.gridx = 0;
        gc.gridy = 0;
        gc.gridwidth=1;
        gc.fill = GridBagConstraints.BOTH;
        panelControls.add(widthLabel,gc);
        gc.gridx = 1;
        gc.gridy = 0;
        gc.gridwidth=3;
        gc.fill = GridBagConstraints.HORIZONTAL;
        panelControls.add(widthTextField,gc);

        gc.gridx = 0;
        gc.gridy = 1;
        gc.gridwidth=1;
        gc.fill = GridBagConstraints.BOTH;
        panelControls.add(heightLabel,gc);
        gc.gridx = 1;
        gc.gridy = 1;
        gc.gridwidth=3;
        gc.fill = GridBagConstraints.HORIZONTAL;
        panelControls.add(heightTextField,gc);

        gc.gridx = 0;
        gc.gridy = 2;
        gc.gridwidth=1;
        gc.fill = GridBagConstraints.BOTH;
        panelControls.add(seedLabel,gc);
        gc.gridx = 1;
        gc.gridy = 2;
        gc.gridwidth=3;
        gc.fill = GridBagConstraints.HORIZONTAL;
        panelControls.add(seedTextField,gc);

        gc.gridx = 0;
        gc.gridy = 3;
        gc.gridwidth=1;
        gc.fill = GridBagConstraints.BOTH;
        panelControls.add(noiseScaleLabel,gc);
        gc.gridx = 1;
        gc.gridy = 3;
        gc.gridwidth=3;
        gc.fill = GridBagConstraints.HORIZONTAL;
        panelControls.add(noiseScaleTextField,gc);

        gc.gridx = 0;
        gc.gridy = 8;
        gc.gridwidth = 2;
        gc.fill = GridBagConstraints.HORIZONTAL;
        panelControls.add(randomizeSeed,gc);
        gc.gridx = 2;
        gc.gridy = 8;
        gc.gridwidth = 2;
        gc.fill = GridBagConstraints.HORIZONTAL;
        panelControls.add(generateNoise,gc);

        this.setTitle("TerrainTest");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(900,600);
        this.setLayout(null);
        this.setVisible(true);


        this.add(panelMap);
        this.add(panelControls);
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
