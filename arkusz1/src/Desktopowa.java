import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

public class Desktopowa extends JFrame implements ChangeListener, ActionListener {
    JPanel rectangle = new JPanel();
    JPanel smallRectangle = new JPanel();
    JLabel colorValues = new JLabel();

    JLabel rValue = new JLabel(),gValue = new JLabel(),bValue = new JLabel();
    JSlider sliderR = new JSlider(SwingConstants.HORIZONTAL,0,255,255);
    JSlider sliderG = new JSlider(SwingConstants.HORIZONTAL,0,255,255);
    JSlider sliderB = new JSlider(SwingConstants.HORIZONTAL,0,255,255);


    public Desktopowa(){
        this.setSize(900,600);
        this.setTitle("Wzornik kolorów RGB. Wykonał 111111111");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255,248,220));
        panel.setSize(900,600);
        panel.setLayout(null);

        rectangle.setBackground(new Color(255,255,255));
        rectangle.setBounds(40,40,800,120);
        rectangle.setVisible(true);

        JLabel label1 = new JLabel();
        label1.setBounds(40, 200,400,30);
        label1.setText("Dobierz kolor suwakami i zapisz przyciskiem:");

        JLabel r = new JLabel(),g = new JLabel(),b = new JLabel();
        r.setText("R");
        g.setText("G");
        b.setText("B");
        r.setBounds(40,260,30,30);
        g.setBounds(40,320,30,30);
        b.setBounds(40,380,30,30);

        sliderR.setBounds(70,265,720,20);
        sliderR.setBackground(null);
        sliderR.addChangeListener(this);
        sliderG.setBounds(70,325,720,20);
        sliderG.setBackground(null);
        sliderG.addChangeListener(this);
        sliderB.setBounds(70,385,720,20);
        sliderB.setBackground(null);
        sliderB.addChangeListener(this);

        rValue.setText(""+sliderR.getValue());
        gValue.setText(""+sliderR.getValue());
        bValue.setText(""+sliderR.getValue());
        rValue.setBounds(820,245,50,50);
        gValue.setBounds(820,305,50,50);
        bValue.setBounds(820,365,50,50);

        JButton button = new JButton();
        button.setBackground(new Color(205,133,77));
        button.setText("Pobierz");
        button.setVerticalTextPosition(SwingConstants.CENTER);
        button.setBounds(300,420,300,40);
        button.addActionListener(this);

        smallRectangle.setBackground(new Color(sliderR.getValue(),sliderG.getValue(),sliderB.getValue()));
        smallRectangle.setBounds(300,490,300,50);
        smallRectangle.setLayout(null);

        colorValues.setText(sliderR.getValue()+", "+sliderG.getValue()+", "+sliderB.getValue());
        colorValues.setBounds(20,0,250,50);

        smallRectangle.add(colorValues);


        panel.add(rectangle);
        panel.add(label1);
        panel.add(r);
        panel.add(g);
        panel.add(b);
        panel.add(sliderR);
        panel.add(sliderG);
        panel.add(sliderB);
        panel.add(rValue);
        panel.add(gValue);
        panel.add(bValue);
        panel.add(button);
        panel.add(smallRectangle);

        this.add(panel);

    }
    @Override
    public void stateChanged(ChangeEvent e) {
        rValue.setText(""+sliderR.getValue());
        gValue.setText(""+sliderG.getValue());
        bValue.setText(""+sliderB.getValue());
        rectangle.setBackground(new Color(sliderR.getValue(),sliderG.getValue(),sliderB.getValue()));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        smallRectangle.setBackground(new Color(sliderR.getValue(),sliderG.getValue(),sliderB.getValue()));
        colorValues.setText(sliderR.getValue()+", "+sliderG.getValue()+", "+sliderB.getValue());
    }

    public static void main(String[] args) {
        Desktopowa desk = new Desktopowa();
    }



}
