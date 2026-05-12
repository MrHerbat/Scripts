import AllForMap.MapGenerator;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DisplayFrame extends JFrame {
    boolean allowDynamicChange = false;
    DisplayFrame(){

        MapGenerator mapGen = new MapGenerator();
        mapGen.drawMode = MapGenerator.DrawMode.ColorMap;
        mapGen.GenerateMap();


        JPanel panelMap = new JPanel();
        panelMap.setBounds(0,0,600,600);
        panelMap.setBackground(Color.GRAY);

        JLabel noise = new JLabel();
        noise.setSize(panelMap.getWidth(),panelMap.getHeight());
        ImageIcon image = new ImageIcon();
        image.setImage(mapGen.getMapImage().getScaledInstance(600,600,Image.SCALE_DEFAULT));
        noise.setIcon(image);

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
        JTextField offsetxTextField = new JTextField(Float.toString(mapGen.getOffsetX()));
        JTextField offsetyTextField = new JTextField(Float.toString(mapGen.getOffsetY()));

        JButton randomizeSeed = new JButton("Random seed");
        randomizeSeed.addActionListener(e -> {
            Random rand = new Random();
            mapGen.setSeed(rand.nextLong());
            seedTextField.setText(Long.toString(mapGen.getSeed()));
        });
        JButton generateNoise = new JButton("Generate noise map");
        generateNoise.addActionListener(e -> {
            updateMap(mapGen, image, noise,
                    Integer.parseInt(widthTextField.getText()),
                    Integer.parseInt(heightTextField.getText()),
                    Long.parseLong(seedTextField.getText()),
                    Float.parseFloat(noiseScaleTextField.getText()),
                    Integer.parseInt(octavesTextField.getText()),
                    Float.parseFloat(persistanceTextField.getText()),
                    Float.parseFloat(lacunarityTextField.getText()),
                    Float.parseFloat(offsetxTextField.getText()),
                    Float.parseFloat(offsetyTextField.getText()));
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
    private void updateMap(MapGenerator mapGen,
                           ImageIcon image, JLabel noise,
                           int mapWidth, int mapHeight,long seed, float noiseScale,
                           int octaves, float persistance, float lacunarity,
                           float offsetX, float offsetY){
        mapGen.setMapWidth(mapWidth);
        mapGen.setMapHeight(mapHeight);
        mapGen.setSeed(seed);
        mapGen.setNoiseScale(noiseScale);
        mapGen.setOctaves(octaves);
        mapGen.setPersistance(persistance);
        mapGen.setLacunarity(lacunarity);
        mapGen.setOffsetX(offsetX);
        mapGen.setOffsetY(offsetY);
        mapGen.GenerateMap();
        image.setImage(mapGen.getMapImage().getScaledInstance(600,600,Image.SCALE_DEFAULT));
        noise.setIcon(image);
    }
}
