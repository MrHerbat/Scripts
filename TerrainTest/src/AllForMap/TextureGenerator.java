package AllForMap;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TextureGenerator {
    public static BufferedImage textureFromColorMap(Color[] colorMap, int width, int height){
        BufferedImage bmColorMap = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                bmColorMap.setRGB(x,y,colorMap[y*width+x].getRGB());
            }
        }
        return bmColorMap;
    }

    public static BufferedImage textureFromHeighMap(float[][] heightMap){
        int width = heightMap.length;
        int height = heightMap[0].length;

        Color[] colorMap = new Color[width*height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                colorMap[y*width+x] = lerpColor(Color.BLACK, Color.WHITE,heightMap[x][y]);
            }
        }
        return textureFromColorMap(colorMap,width,height);
    }
    public static Color lerpColor(Color c1, Color c2, float blending) {


        float inverse_blending = 1 - blending;

        int r =   (int)(c1.getRed()   * inverse_blending   +   c2.getRed()   * blending);
        int g = (int)(c1.getGreen() * inverse_blending   +   c2.getGreen() * blending);
        int b =  (int)(c1.getBlue()  * inverse_blending   +   c2.getBlue()  * blending);

        return new Color(r,g,b);
    }
}
