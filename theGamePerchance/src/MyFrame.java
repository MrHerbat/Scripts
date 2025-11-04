import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MyFrame extends JFrame {
    MyFrame(){

        Border border = BorderFactory.createLineBorder(Color.MAGENTA, 5);

        ImageIcon image = new ImageIcon("D:\\flower_purple_scaled.png");

        JLabel label1 = new JLabel();           //create label
        label1.setIcon(image);                  //set imageicon of label
        label1.setText("Man, I love bread.");   //add text to label
        label1.setHorizontalTextPosition(JLabel.CENTER);    //sets text position LEFT, CENTER or RIGHT of imageicon
        label1.setVerticalTextPosition(JLabel.TOP);         //sets text position TOP, CENTER or BOTTOM of imageicon
        label1.setHorizontalAlignment(JLabel.CENTER);       //sets horizontal position LEFT, CENTER or RIGHT of imageicon+text within label
        label1.setVerticalAlignment(JLabel.CENTER);         //sets vertical position TOP, CENTER or BOTTOM of imageicon+text within label
        label1.setForeground(Color.MAGENTA);    //changes font color of label
        label1.setFont(new Font("MV Boli",Font.PLAIN,20));  //changes font of label (font name, font style, font size)
        label1.setIconTextGap(25);
        label1.setBackground(Color.BLACK);
        label1.setOpaque(true);
        label1.setBorder(border);

        this.setTitle("D&D PC");      //sets title
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //operation on closing the app
        this.setSize(630,630);     //changes x-dimension and y-dimension of frame
        //this.setResizable(false);              //sets if frame is resizable by user
        this.setVisible(true);                 //changes visibility of the frame

        this.add(label1);
        ImageIcon icon = new ImageIcon("D:\\flower_purple_scaled.png");
        this.setIconImage(icon.getImage());      //sets frame's icon
        //this.getContentPane().setBackground(Color.BLACK);   //changes background color
    }
}
