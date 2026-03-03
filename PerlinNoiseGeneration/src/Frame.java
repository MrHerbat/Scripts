import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public Frame(){
        JPanel noisePanel = new JPanel();
        noisePanel.setBackground(new Color(100,100,100));
        noisePanel.setBounds(0,0,600,600);

        JPanel noisePropertiesPanel = new JPanel();
        noisePropertiesPanel.setBackground(new Color(150,150,150));
        noisePropertiesPanel.setBounds(600,0,300,600);

        JPanel generateNoisePanel = new JPanel();
        generateNoisePanel.setBackground(new Color(200,200,200));
        generateNoisePanel.setBounds(0,600,900,100);


        this.setTitle("Perlin noisePanel");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900,700);
        this.setLayout(null);
        this.setVisible(true);

        this.add(noisePanel);
        this.add(noisePropertiesPanel);
        this.add(generateNoisePanel);
    }
}
