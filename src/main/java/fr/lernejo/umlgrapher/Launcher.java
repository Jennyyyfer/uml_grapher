package fr.lernejo.umlgrapher;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;


@Command(name = "launcher", mixinStandardHelpOptions = true, version = "UMLGraph 1.0", description = "UMLGraph")
    public class Launcher implements Callable<Integer> {

        @Option(names = {"-c", "--classes"}, required = true, description = "Fill in the classes from which to base the analysis")
        private Class<?>[] classes;
        @Option(names = {"-g", "--graph-type"}, defaultValue = "Mermaid", description = "Select the type of graph you want to output")
        private String grType;

        @Override
        public Integer call() throws Exception {
            UmlGraph graph = new UmlGraph(classes);
            System.out.println(graph.as(GraphType.valueOf(grType)));
            return null;
        }
        // this example implements Callable, so parsing, error handling and handling user
        // requests for usage help or version help can be done with one line of code.
        public static void main(String... args) {
            int exitCode = new CommandLine(new Launcher()).execute(args);
            System.exit(exitCode);
        }
}

