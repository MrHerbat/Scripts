import AllForMap.MapGenerator;

import javax.swing.*;
import javax.swing.text.html.ImageView;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DisplayFrame extends JFrame {

    DisplayFrame(){

        MapGenerator mapGen = new MapGenerator();
        mapGen.drawMode = MapGenerator.DrawMode.ColorMap;
        mapGen.GenerateMap();


        JLabel noise = new JLabel();
        noise.setSize(700,700);
        ImageIcon image = new ImageIcon();
        image.setImage(mapGen.getMapImage());
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

        JTextField widthTextField = new JTextField(Integer.toString(mapGen.getMapWidth()));
        JTextField heightTextField = new JTextField(Integer.toString(mapGen.getMapHeight()));
        JTextField seedTextField = new JTextField(Long.toString(mapGen.getSeed()));
        JTextField noiseScaleTextField = new JTextField(Float.toString(mapGen.getNoiseScale()));
        JTextField octavesTextField = new JTextField(Integer.toString(mapGen.getOctaves()));
        JTextField persistanceTextField = new JTextField(Float.toString(mapGen.getPersistance()));
        JTextField lacunarityTextField = new JTextField(Float.toString(mapGen.getLacunarity()));
        JTextField offsetxTextField = new JTextField(Integer.toString(mapGen.getOffsetX()));
        JTextField offsetyTextField = new JTextField(Integer.toString(mapGen.getOffsetY()));

        JButton randomizeSeed = new JButton("Random seed");
        randomizeSeed.addActionListener(e -> {
            Random rand = new Random();
            mapGen.setSeed(rand.nextLong());
            seedTextField.setText(Long.toString(mapGen.getSeed()));
        });
        JButton generateNoise = new JButton("Generate noise map");
        generateNoise.addActionListener(e -> {
            mapGen.setMapWidth(Integer.parseInt(widthTextField.getText()));
            mapGen.setMapHeight(Integer.parseInt(heightTextField.getText()));
            mapGen.setSeed(Long.parseLong(seedTextField.getText()));
            mapGen.setNoiseScale(Float.parseFloat(noiseScaleTextField.getText()));
            mapGen.setOctaves(Integer.parseInt(octavesTextField.getText()));
            mapGen.setPersistance(Float.parseFloat(persistanceTextField.getText()));
            mapGen.setLacunarity(Float.parseFloat(lacunarityTextField.getText()));
            mapGen.setOffsetX(Integer.parseInt(offsetxTextField.getText()));
            mapGen.setOffsetY(Integer.parseInt(offsetyTextField.getText()));
            mapGen.GenerateMap();
            image.setImage(mapGen.getMapImage());
            noise.setIcon(image);
            panelMap.repaint();
        });

        JCheckBox autoUpdate = new JCheckBox("Auto update map");

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
        gc.gridy = 4;
        gc.gridwidth = 1;
        gc.fill = GridBagConstraints.HORIZONTAL;
        panelControls.add(octavesLabel,gc);
        gc.gridx = 1;
        gc.gridy = 4;
        gc.gridwidth = 3;
        gc.fill = GridBagConstraints.HORIZONTAL;
        panelControls.add(octavesTextField,gc);

        gc.gridx = 0;
        gc.gridy = 5;
        gc.gridwidth = 1;
        gc.fill = GridBagConstraints.HORIZONTAL;
        panelControls.add(persistanceLabel,gc);
        gc.gridx = 1;
        gc.gridy = 5;
        gc.gridwidth = 3;
        gc.fill = GridBagConstraints.HORIZONTAL;
        panelControls.add(persistanceTextField,gc);

        gc.gridx = 0;
        gc.gridy = 6;
        gc.gridwidth = 1;
        gc.fill = GridBagConstraints.HORIZONTAL;
        panelControls.add(lacunarityLabel,gc);
        gc.gridx = 1;
        gc.gridy = 6;
        gc.gridwidth = 3;
        gc.fill = GridBagConstraints.HORIZONTAL;
        panelControls.add(lacunarityTextField,gc);

        gc.gridx=0;
        gc.gridy=7;
        gc.gridwidth=2;
        gc.fill = GridBagConstraints.HORIZONTAL;
        panelControls.add(offsetxTextField,gc);

        gc.gridx=2;
        gc.gridy=7;
        gc.gridwidth=2;
        gc.fill = GridBagConstraints.HORIZONTAL;
        panelControls.add(offsetyTextField,gc);

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

        gc.gridx = 0;
        gc.gridy = 9;
        gc.gridwidth = 2;
        panelControls.add(autoUpdate,gc);



        this.setTitle("TerrainTest");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(900,600);
        this.setLayout(new GridBagLayout());
        this.setVisible(true);

        gc.weighty = 2;
        gc.weightx = 1;
        gc.gridx = 0;
        gc.fill = GridBagConstraints.BOTH;
        this.add(panelMap,gc);
        gc.weighty = 1;
        gc.gridx = 3;
        this.add(panelControls,gc);
    }
}
