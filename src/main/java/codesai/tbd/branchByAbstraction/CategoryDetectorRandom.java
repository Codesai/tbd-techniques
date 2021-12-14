package codesai.tbd.branchByAbstraction;

import codesai.tbd.parallelchange.Product;

import java.util.Random;

public class CategoryDetectorRandom implements CategoryDetector {

    public String detect(Product p)  {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return (new Random().nextLong() % 2 == 0) ? "technology" : "other";
    }
}
