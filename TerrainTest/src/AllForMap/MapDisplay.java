package AllForMap;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MapDisplay {

    public static BufferedImage DrawNoiseMap(float[][] noiseMap){
        int width = noiseMap.length;
        int height = noiseMap[0].length;

        BufferedImage bmNoiseMap = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Color[] colorMap = new Color[width*height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                colorMap[y*width+x] = lerpColor(Color.BLACK, Color.WHITE,noiseMap[x][y]);
                bmNoiseMap.setRGB(x,y,colorMap[y*width+x].getRGB());
            }
        }
        return bmNoiseMap;
    }
    public static Color lerpColor(Color c1, Color c2, float blending) {


        float inverse_blending = 1 - blending;

        int r =   (int)(c1.getRed()   * inverse_blending   +   c2.getRed()   * blending);
        int g = (int)(c1.getGreen() * inverse_blending   +   c2.getGreen() * blending);
        int b =  (int)(c1.getBlue()  * inverse_blending   +   c2.getBlue()  * blending);

        return new Color(r,g,b);
    }


}
