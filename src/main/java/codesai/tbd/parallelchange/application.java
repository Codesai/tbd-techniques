package codesai.tbd.parallelchange;

public class application {

    public static void main(String[] args) {
        ProductSearchApi.search(100, 5000).forEach(System.out::println);
    }
}
