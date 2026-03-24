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
    public long seed = 71380125;
    public float noiseScale = 20.3f;

    public int octaves = 4;
    public float persistance = 0.5f;
    public float lacunarity = 2f;

    public int posX = 0;
    public int posY = 0;

    public BufferedImage mapImage;

    public void GenerateMap(){
        float[][] noiseMap = Noise.generateNoiseMap(mapWidth,mapHeight,seed,noiseScale,octaves,persistance,lacunarity);

        mapImage = MapDisplay.DrawNoiseMap(noiseMap);

    }

    public int getMapWidth() {
        return mapWidth;
    }

    public void setMapWidth(int mapWidth) {
        this.mapWidth = mapWidth;
    }

    public int getMapHeight() {
        return mapHeight;
    }

    public void setMapHeight(int mapHeight) {
        this.mapHeight = mapHeight;
    }

    public long getSeed() {
        return seed;
    }

    public void setSeed(long seed) {
        this.seed = seed;
    }

    public float getNoiseScale() {
        return noiseScale;
    }

    public void setNoiseScale(float noiseScale) {
        this.noiseScale = noiseScale;
    }

    public int getOctaves() {
        return octaves;
    }

    public void setOctaves(int octaves) {
        this.octaves = octaves;
    }

    public float getPersistance() {
        return persistance;
    }

    public void setPersistance(float persistance) {
        this.persistance = persistance;
    }

    public float getLacunarity() {
        return lacunarity;
    }

    public void setLacunarity(float lacunarity) {
        this.lacunarity = lacunarity;
    }
}
