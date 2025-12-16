import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {

    JButton button;

    MyFrame(){

//        Border border = BorderFactory.createLineBorder(Color.MAGENTA, 5);

        //LayoutManager - Defines the natural layout of components within container

        //3 common managers:
        //BorderLayout - Border Layout places components in 5 areas: NORTH,SOUTH,WEST,EAST,CENTER.
        //               All extra space is placed in the center area.
        //FlowLayout   - Places components in a row, sized at their preferred size.
        //               If the horizontal space in the container is too small,
        //               the FlowLayout class uses next available row.
        //GridLayout   - Places components in a grid of cells.
        //               Each component takes all the available space within cell,
        //               and each cell is the same size.
        //

        ImageIcon image = new ImageIcon("D:\\flower_purple_scaled.png");

        //JPanel - a GUI component that functions as a container to hold other components
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.red);
        panel1.setBounds(0,0,250,250);  //sets placement (x,y) and size (width,height) of component
        panel1.setLayout(null);

        //JButton - a component that performs some action when clicked
        button = new JButton();
        button.setText("Click me!");
        button.setBounds(75,100,100,50);
        button.addActionListener(this);                 //sets where this button's action function is contained...

        //GridLayout in action!

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.blue);
        panel2.setBounds(250,0,250,250);
        panel2.setLayout(new GridLayout(3,3,10,10));

        panel2.add(new JButton("1"));
        panel2.add(new JButton("2"));
        panel2.add(new JButton("3"));
        panel2.add(new JButton("4"));
        panel2.add(new JButton("5"));
        panel2.add(new JButton("6"));
        panel2.add(new JButton("7"));
        panel2.add(new JButton("8"));
        panel2.add(new JButton("9"));

//        JButton button2 = new JButton();
//        button2.setText("No, Click me!");
//        button2.setBounds(50,100,125,50);
//        button2.addActionListener(e -> {
//            System.out.println("clicked better one");      //or contains the button's action function
//        });
//        panel2.add(button2);

        //FlowLayout in action!
        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.green);
        panel3.setBounds(0,250,500,250);
        panel3.setLayout(new FlowLayout(FlowLayout.LEADING,20,0)); //Possible options for FlowLayout class: CENTER,LEADING,TRAILING,LEFT,RIGHT

        panel3.add(new JButton("1"));
        panel3.add(new JButton("2"));
        panel3.add(new JButton("3"));
        panel3.add(new JButton("4"));
        panel3.add(new JButton("5"));
        panel3.add(new JButton("6"));
        panel3.add(new JButton("7"));
        panel3.add(new JButton("8"));
        panel3.add(new JButton("9"));
        panel3.add(new JButton("0"));


        //BorderLayout in action!
        JPanel panel4 = new JPanel();
        panel4.setLayout(new BorderLayout());
        panel4.setBounds(0,500,250,250);

        JPanel subPanel1 = new JPanel();
        JPanel subPanel2 = new JPanel();
        JPanel subPanel3 = new JPanel();
        JPanel subPanel4 = new JPanel();
        JPanel subPanel5 = new JPanel();

        subPanel1.setBackground(Color.yellow);
        subPanel2.setBackground(Color.pink);
        subPanel3.setBackground(Color.cyan);
        subPanel4.setBackground(Color.orange);
        subPanel5.setBackground(Color.magenta);

        subPanel1.setPreferredSize(new Dimension(250,50));
        subPanel2.setPreferredSize(new Dimension(250,50));
        subPanel3.setPreferredSize(new Dimension(150,150));
        subPanel4.setPreferredSize(new Dimension(50,250));
        subPanel5.setPreferredSize(new Dimension(50,250));


        //JLayeredPane - Swing container that provides
        //               third dimension for positioning components
        //               ex. depth, Z-index
        //

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(500,0,500,500);

        JLabel layeredLabel1 = new JLabel();
        layeredLabel1.setOpaque(true);
        layeredLabel1.setBackground(Color.ORANGE);
        layeredLabel1.setBounds(50,50,150,150);

        JLabel layeredLabel2 = new JLabel();
        layeredLabel2.setOpaque(true);
        layeredLabel2.setBackground(Color.YELLOW);
        layeredLabel2.setBounds(100,100,150,150);

        JLabel layeredLabel3 = new JLabel();
        layeredLabel3.setOpaque(true);
        layeredLabel3.setBackground(Color.darkGray);
        layeredLabel3.setBounds(150,150,150,150);


        //Ascending order of display priority in LayeredPane:
        // DEFAULT, PALETTE, MODAL, POPUP, DRAG
        //

        layeredPane.add(layeredLabel1,Integer.valueOf(1));
        layeredPane.add(layeredLabel2,Integer.valueOf(3));
        layeredPane.add(layeredLabel3,Integer.valueOf(2));

        //JLabel - a component used to display images and/or text
//        JLabel label1 = new JLabel();           //create label
//        label1.setIcon(image);                  //set imageicon of label
//        label1.setText("Man, I love bread");   //add text to label
//        label1.setHorizontalTextPosition(JLabel.CENTER);    //sets text position LEFT, CENTER or RIGHT of imageicon
//        label1.setVerticalTextPosition(JLabel.TOP);         //sets text position TOP, CENTER or BOTTOM of imageicon
//        label1.setHorizontalAlignment(JLabel.CENTER);       //sets horizontal position LEFT, CENTER or RIGHT of imageicon+text within label
//        label1.setVerticalAlignment(JLabel.CENTER);         //sets vertical position TOP, CENTER or BOTTOM of imageicon+text within label
//        label1.setForeground(Color.MAGENTA);    //changes font color of label
//        label1.setFont(new Font("MV Boli",Font.PLAIN,20));  //changes font of label (font name, font style, font size)
//        label1.setIconTextGap(25);
//        label1.setBackground(Color.BLACK);
//        label1.setOpaque(true);
//        label1.setBorder(border);

        JLabel paneLabel = new JLabel();
        paneLabel.setText("Hi");
        paneLabel.setIcon(image);
        paneLabel.setVerticalAlignment(JLabel.TOP);





        this.setTitle("Learning");      //sets title
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //operation on closing the app
        this.setSize(1100,900);     //changes x-dimension and y-dimension of frame
        this.setLayout(null);                   //sets JFrame layout
        //this.setResizable(false);              //sets if frame is resizable by user
        this.setVisible(true);                 //changes visibility of the frame


        panel3.add(paneLabel);
        panel1.add(button);


        panel4.add(subPanel1, BorderLayout.NORTH);
        panel4.add(subPanel2, BorderLayout.SOUTH);
        panel4.add(subPanel3, BorderLayout.CENTER);
        panel4.add(subPanel4, BorderLayout.WEST);
        panel4.add(subPanel5, BorderLayout.EAST);

        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        this.add(panel4);
        this.add(layeredPane);
        ImageIcon icon = new ImageIcon("D:\\flower_purple_scaled.png");
        this.setIconImage(icon.getImage());      //sets frame's icon
        //this.getContentPane().setBackground(Color.BLACK);   //changes background color
    }

    //function that contains button action
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==button){
            System.out.println("clicked");
        }
    }
}
