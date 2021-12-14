package codesai.tbd.branchByAbstraction;

import codesai.tbd.parallelchange.Product;

import java.util.Random;

public class CategoryDetectorRandom {

    public static String detect(Product p) throws InterruptedException {
        Thread.sleep(100);
        return (new Random().nextLong() % 2 == 0) ? "technology" : "other";
    }
}
