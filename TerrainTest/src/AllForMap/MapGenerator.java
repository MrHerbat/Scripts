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
            new TerrainType("DeppWater1",0.3f,new Color(20,20,170)),
            new TerrainType("DeepWater2",0.375f,new Color(20,125,190)),
            new TerrainType("ShallowWater",0.425f,new Color(80, 150, 240)),
            new TerrainType("Sand1", 0.475f, new Color(220, 185, 35)),
            new TerrainType("Sand2", 0.5f, new Color(240, 200, 55)),
            new TerrainType("Grass1", 0.6f, new Color(15, 160, 10)),
            new TerrainType("Grass3", 0.65f, new Color(35, 180, 35)),
            new TerrainType("Grass2", 0.7f, new Color(55, 200, 50)),
            new TerrainType("Rock1", 0.75f, new Color(85, 70, 60)),
            new TerrainType("Rock2", 0.85f,new Color(70, 50, 50)),
            new TerrainType("Rock3", 0.95f, new Color(55, 30, 40)),
            new TerrainType("Rock3", 0.975f, new Color(199, 254, 255)),
            new TerrainType("Snow",1,new Color(227, 254, 255))
    };

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
