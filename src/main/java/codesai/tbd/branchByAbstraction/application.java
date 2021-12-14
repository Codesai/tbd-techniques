package codesai.tbd.branchByAbstraction;

import codesai.tbd.parallelchange.Product;
import com.github.rawls238.scientist4j.Experiment;
import com.github.rawls238.scientist4j.ExperimentBuilder;
import com.github.rawls238.scientist4j.metrics.DropwizardMetricsProvider;
import io.dropwizard.metrics5.ConsoleReporter;

import java.util.concurrent.TimeUnit;

public class application {
    final static Product tv = new Product("tv", 1);
    private static DropwizardMetricsProvider provider = new DropwizardMetricsProvider();

    public static void main(String[] args) throws Exception {
        Experiment<String> experiment = new ExperimentBuilder<String>()
                .withName("CategoryDetector")
                .withMetricsProvider(provider)
                .withComparator((control, candidate) -> {
                    if (!control.equals(candidate)) System.out.println("mismatch => control: " + control + " candidate: " + candidate);
                    return control.equals(candidate);
                })
                .build();

        for (int i = 0; i < 100; i++) {
            final CategoryDetector control = new CategoryDetectorClassic();
            final CategoryDetector candidate = new CategoryDetectorRandom();
            String category = experiment.run(
                    () -> control.detect(tv),
                    () -> candidate.detect(tv));

            System.out.println("detected category: " + category);
        }

        reportExperimentResults();
    }

    private static void reportExperimentResults() {
        ConsoleReporter.forRegistry(provider.getRegistry())
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build()
                .report();
    }
}
