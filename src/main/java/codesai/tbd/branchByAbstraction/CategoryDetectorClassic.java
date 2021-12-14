package codesai.tbd.branchByAbstraction;

import codesai.tbd.parallelchange.Product;

public class CategoryDetectorClassic implements CategoryDetector {

    public String detect(Product p) {
        if(p.name.equals("tv")) return "technology";
        return "other";
    }
}
