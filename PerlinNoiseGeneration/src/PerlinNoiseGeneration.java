public class PerlinNoiseGeneration {
    public static float[][] generateNoiseMap(
            int width, int height, float scale
    ){
        float[][] noiseMap = new float[width][height];
        if(scale<0)
            scale=0.00001f;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                float sampleX = x / scale;
                float sampleY = y / scale;

                float perlinValue = generateNoise(sampleX, sampleY);
                noiseMap[x][y] = perlinValue;
            }
        }
        
        return noiseMap;
    }
    public float generateNoise(float x, float y){
        float noise;

        return noise;
    }
}
