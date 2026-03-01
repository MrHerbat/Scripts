package AllForMap;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MapGenerator
{
    public int mapWidth = 400;
    public int mapHeight = 400;
    public int seed = 7131;
    public float noiseScale = 30.3f;

    public int octaves = 4;
    public float persistance = 0.5f;
    public float lacunarity = 2f;

    public BufferedImage mapImage;

    public void GenerateMap(){
        float[][] noiseMap = Noise.generateNoiseMap(mapWidth,mapHeight,seed,noiseScale,octaves,persistance,lacunarity);

        mapImage = MapDisplay.DrawNoiseMap(noiseMap);

    }
}
