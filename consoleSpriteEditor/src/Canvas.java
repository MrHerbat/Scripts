import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Canvas
{
    public static boolean loop = true;
    int[][] canvas;
    public static Color[] colors = {
            new Color(0,0,0),
            new Color(255,0,0),
            new Color(0,255,0),
            new Color(0,0,255),
            new Color(255,255,0),
            new Color(0,255,255),
            new Color(255,0,255),
            new Color(255,255,255)
    };
    public static String[][] consoleColors = {
            {"\u001B[30m","\u001B[40m"},
            {"\u001B[31m","\u001B[41m"},
            {"\u001B[32m","\u001B[42m"},
            {"\u001B[34m","\u001B[44m"},
            {"\u001B[33m","\u001B[43m"},
            {"\u001B[36m","\u001B[46m"},
            {"\u001B[35m","\u001B[45m"},
            {"\u001B[37m","\u001B[47m"},
            {"\u001B[0m","\u001B[0m"}
    };
    public static Scanner scanner = new Scanner(System.in);

    public Canvas() {
    }
    public void displayCanvas(int selectedX,int selectedY){
        System.out.flush();
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (i==selectedY && j == selectedX){
                    System.out.print(">"+consoleColors[canvas[i][j]][0]+consoleColors[canvas[i][j]][1]+" "+canvas[i][j]+" "+consoleColors[8][0]+"<");
                }else{
                    System.out.print("["+consoleColors[canvas[i][j]][0]+consoleColors[canvas[i][j]][1]+" "+canvas[i][j]+" "+consoleColors[8][0]+"]");
                }

            }
            System.out.println();
        }
        for (int i = 0; i < canvas[0].length; i++) {
            System.out.print("=====");
        }
        System.out.println();
        System.out.println(consoleColors[8][0]+"a/w/s/d = left/up/down/right | + - increment color | - - decrement color");
        System.out.println(consoleColors[8][0]+"x - leave without saving | f - save as .png file | o - open .png file");
    }
    public void createCanvas(){
        int choice;
        loop = true;
        while(loop){
            System.out.println("1 - create new sprite \n 2 - open .png file \n 3 - exit \n it's recommended to create smaller sprites");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    int x,y;
                    System.out.print("Set X size:  ");
                    x = scanner.nextInt();
                    System.out.print("Set Y size:  ");
                    y = scanner.nextInt();
                    if(x>0 || y>0){
                        canvas = new int[y][x];
                        editCanvas();
                        loop=false;
                    }else{
                        System.out.println("Wrong size");
                    }
                    break;
                case 2:
                    pngToCanvas();
                    editCanvas();
                    break;
                case 3:
                    loop=false;
                    break;
                default:
                    break;
            }
        }
    }
    public void editCanvas(){
        char c;
        int selX = 0, selY = 0;
        loop = true;
        do{
            displayCanvas(selX,selY);
            c = scanner.next().charAt(0);
            switch (c){
                case 'x':
                    loop = false;
                    break;
                case 'a':
                    if(selX<=0){
                        selX=(canvas[0].length-1);
                    }else{
                        selX--;
                    }
                    break;
                case 'd':
                    if(selX>=canvas[0].length-1){
                        selX=0;
                    }else{
                        selX++;
                    }
                    break;
                case 's':
                    if(selY>=canvas.length-1){
                        selY=0;
                    }else{
                        selY++;
                    }
                    break;
                case 'w':
                    if(selY<=0){
                        selY=canvas.length-1;
                    }else{
                        selY--;
                    }
                    break;
                case '+':
                    if(canvas[selY][selX]==7){
                        canvas[selY][selX]=0;
                    }else{
                        canvas[selY][selX]++;
                    }
                    break;
                case '-':
                    if(canvas[selY][selX]==0){
                        canvas[selY][selX]=7;
                    }else{
                        canvas[selY][selX]--;
                    }
                    break;
                case 'f':
                    canvasToPng(canvas);
                    break;
                case 'o':
                    pngToCanvas();
                    loop = true;
                    break;
                default:
                    break;
            }
        }while(loop);
    }

    public void canvasToPng(int[][] tab){
        System.out.print("File name: ");
        String fileName = scanner.next();
        String path = "D:\\"+fileName+".png";
        BufferedImage image = new BufferedImage(tab.length,tab[0].length, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < tab.length; y++) {
            for (int x = 0; x < tab[y].length; x++) {
                image.setRGB(x,y,colors[tab[y][x]].getRGB());
            }
        }
        File ImageFile = new File(path);
        try {
            ImageIO.write(image, "png", ImageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void pngToCanvas(){
        System.out.print("File name: ");
        String fileName = scanner.next();
        String path = "D:\\"+fileName+".png";
        File ImageFile = new File(path);
        if(ImageFile.isFile()){
            loop = false;
            try{
                var tempImage = ImageIO.read(ImageFile);
                if(canvas == null || (canvas.length< tempImage.getHeight() && canvas[0].length<tempImage.getWidth())){
                    canvas = new int[tempImage.getHeight()][tempImage.getWidth()];
                }
                for (int i = 0; i < tempImage.getHeight(); i++) {
                    for (int j = 0; j < tempImage.getWidth(); j++) {
                        int cId = 0;
                        for (Color c : colors){
                            if(c.getRGB()==tempImage.getRGB(i,j)){
                                canvas[j][i]=cId;
                                break;
                            }
                            cId++;
                        }
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            System.out.println("File doesn't exist or couldn't be found in D:/ directory");
        }
    }
}