package AllForMap;


import java.util.Random;

public class Noise {
    public static float[][] generateNoiseMap(int mapWidth,int mapHeight, long seed, float scale, int octaves, float persistence, float lacunarity){
        float[][] noiseMap = new float[mapWidth][mapHeight];
        SillyAlgorithms sa = new SillyAlgorithms(seed);

        Random rand = new Random(seed);
        float[][] octaveOffsets = new float[octaves][2];
        for (int i = 0; i < octaves; i++) {
            float offsetX = rand.nextInt(-100000,100000);
            float offsetY = rand.nextInt(-100000,100000);
            octaveOffsets[i][0] = offsetX;
            octaveOffsets[i][1] = offsetY;
        }

        float halfWidth = mapWidth/2f;
        float halfHeight = mapHeight/2f;

        float maxNoise = Float.MIN_VALUE;
        float minNoise = Float.MAX_VALUE;

        for (int y = 0; y < mapWidth; y++) {
            for (int x = 0; x < mapHeight; x++) {
                float amplitude = 1.0f;
                float frequency = 1.0f;
                float noiseValue = 0.0f;

                for (int o = 0; o < octaves; o++) {
                    float sampleX = (x-halfWidth) / scale * frequency + octaveOffsets[o][0];
                    float sampleY = (y-halfHeight) / scale * frequency + octaveOffsets[o][1];

                    double perlin = sa.noise(sampleX, sampleY);  // returns ~[-1, 1]
                    noiseValue += perlin * amplitude;

                    amplitude *= persistence;
                    frequency *= lacunarity;
                }

                noiseMap[y][x] = noiseValue;

                    maxNoise = Math.max(maxNoise, noiseValue);
                    minNoise = Math.min(minNoise, noiseValue);
            }
        }

        // Normalize to 0-1 if requested
        if (maxNoise > minNoise) {
            float range = maxNoise - minNoise;
            for (int y = 0; y < mapWidth; y++) {
                for (int x = 0; x < mapHeight; x++) {
                    noiseMap[y][x] = (noiseMap[y][x] - minNoise) / range;
                }
            }
        }

        return noiseMap;
    }
}
