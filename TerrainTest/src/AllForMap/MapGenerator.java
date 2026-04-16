package AllForMap;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MapGenerator
{
    public enum DrawMode {NoiseMap, ColorMap};
    public DrawMode drawMode;

    public int mapWidth = 400;
    public int mapHeight = 400;
    public long seed = -71380125;
    public float noiseScale = 20.3f;

    public int octaves = 4;
    public float persistance = 0.5f;
    public float lacunarity = 2f;
    public int offsetX = 0, offsetY = 0;

    public TerrainType[] regions = {
            new TerrainType("DeppWater",0.3f,Color.BLUE),
            new TerrainType("ShallowWater",0.4f,Color.CYAN),
            new TerrainType("Sand", 0.475f, Color.yellow),
            new TerrainType("Grass", 0.65f, Color.GREEN),
            new TerrainType("Rock", 0.7f, Color.GRAY),
            new TerrainType("Rock2", 0.85f, Color.DARK_GRAY),
            new TerrainType("Snow",1,Color.WHITE),
    };

    public int posX = 0;
    public int posY = 0;

    public BufferedImage mapImage;

    public void GenerateMap(){
        float[][] noiseMap = Noise.generateNoiseMap(mapWidth,mapHeight,seed,noiseScale,octaves,persistance,lacunarity,offsetX,offsetY);

        Color[] colorMap = new Color[mapWidth*mapHeight];
        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {
                float currentHeight = noiseMap[x][y];
                for (int i = 0; i < regions.length; i++) {
                    if (currentHeight<=regions[i].height){
                        colorMap[y * mapWidth + x] = regions[i].color;
                        break;
                    }
                }
            }
        }

        if(drawMode == DrawMode.NoiseMap) {
            setMapImage(TextureGenerator.textureFromHeighMap(noiseMap));
        }else if (drawMode == DrawMode.ColorMap){
            setMapImage(TextureGenerator.textureFromColorMap(colorMap,mapWidth,mapHeight));
        }


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

    public int getOffsetX() {
        return offsetX;
    }

    public void setOffsetX(int offsetX) {
        this.offsetX = offsetX;
    }

    public int getOffsetY() {
        return offsetY;
    }

    public void setOffsetY(int offsetY) {
        this.offsetY = offsetY;
    }

    public BufferedImage getMapImage() {
        return mapImage;
    }

    public void setMapImage(BufferedImage mapImage) {
        this.mapImage = mapImage;
    }
}
