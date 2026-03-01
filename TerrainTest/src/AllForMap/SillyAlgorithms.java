package AllForMap;

import java.util.Random;

/**
 * A 2D Perlin noise implementation with proper seeding for random/reproducible results.
 * Now generates different noise patterns based on the seed.
 */
public class SillyAlgorithms {
    private final long seed;        // Stored as long for better Random seeding
    private static final int[] p = new int[512];  // Permutation table (doubled for wrap-around)

    /**
     * Constructor with explicit seed for reproducible noise.
     */
    public SillyAlgorithms(long seed) {
        this.seed = seed;
        initPermutation(seed);
    }
    /**
     * Initializes and shuffles the permutation table using the given seed.
     */
    private void initPermutation(long seedValue) {
        Random rnd = new Random(seedValue);

        // Base permutation values (0 to 255)
        int[] permutation = new int[256];
        for (int i = 0; i < 256; i++) {
            permutation[i] = i;
        }

        // Shuffle using Fisher-Yates algorithm
        for (int i = 255; i > 0; i--) {
            int j = rnd.nextInt(i + 1);
            int temp = permutation[i];
            permutation[i] = permutation[j];
            permutation[j] = temp;
        }

        // Double the array for efficient wrap-around indexing
        for (int i = 0; i < 256; i++) {
            p[i] = p[i + 256] = permutation[i];
        }
    }

    private static double fade(double t) {
        return t * t * t * (t * (t * 6 - 15) + 10);
    }

    private static double lerp(double t, double a, double b) {
        return a + t * (b - a);
    }

    private static double grad(int hash, double x, double y) {
        int h = hash & 15;
        double u = h < 8 ? x : y;              // Main direction
        double v = h < 4 ? y : ((h == 12 || h == 14) ? x : 0);  // Secondary (0 for some to keep 12 unique dirs)
        return ((h & 1) == 0 ? u : -u) + ((h & 2) == 0 ? v : -v);
    }

    /**
     * Returns Perlin noise value at (x, y). Range ≈ -1 to 1.
     */
    public static double noise(double x, double y) {
        int X = (int) Math.floor(x) & 255;
        int Y = (int) Math.floor(y) & 255;

        x -= Math.floor(x);
        y -= Math.floor(y);

        double u = fade(x);
        double v = fade(y);

        int A = p[X] + Y;
        int AA = p[A];
        int AB = p[A + 1];
        int B = p[X + 1] + Y;
        int BA = p[B];
        int BB = p[B + 1];

        return lerp(v,
                lerp(u, grad(p[AA], x, y), grad(p[BA], x - 1, y)),
                lerp(u, grad(p[AB], x, y - 1), grad(p[BB], x - 1, y - 1)));
    }

    // Optional: getter for seed (useful for debugging or saving)
    public long getSeed() {
        return seed;
    }
}