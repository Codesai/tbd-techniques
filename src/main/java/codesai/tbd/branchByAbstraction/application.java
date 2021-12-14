package codesai.tbd.branchByAbstraction;

import codesai.tbd.parallelchange.Product;
import com.github.rawls238.scientist4j.Experiment;
import com.github.rawls238.scientist4j.ExperimentBuilder;
import com.github.rawls238.scientist4j.metrics.DropwizardMetricsProvider;
import io.dropwizard.metrics5.ConsoleReporter;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class application {

    public static void main(String[] args) throws Exception {
        final DropwizardMetricsProvider provider = new DropwizardMetricsProvider();
        Experiment<String> experiment = new ExperimentBuilder<String>()
                .withName("CategoryDetector")
                .withMetricsProvider(provider)
                .withComparator((control, candidate) -> {
                    if (!control.equals(candidate)) System.out.println("mismatch => control: " + control + " candidate: " + candidate);
                    return control.equals(candidate);
                })
                .build();

        for (int i = 0; i < 100; i++) {
            final Product tv = new Product("tv", 1);
            final Callable<String> control = () -> CategoryDetector.detect(tv);
            final Callable<String> candidate = () -> CategoryDetectorRandom.detect(tv);
            String category = experiment.run(control,candidate);

            System.out.println("detected category: " + category);
        }

        reportExperimentResults(provider);
    }

    private static void reportExperimentResults(DropwizardMetricsProvider provider) {
        ConsoleReporter reporter = ConsoleReporter.forRegistry(provider.getRegistry())
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build();
        reporter.report();
    }
}
