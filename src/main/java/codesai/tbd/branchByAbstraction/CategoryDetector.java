package codesai.tbd.branchByAbstraction;

import codesai.tbd.parallelchange.Product;

public class CategoryDetector {

    public static String detect(Product p) {
        if(p.name.equals("tv")) return "technology";
        return "other";
    }
}
