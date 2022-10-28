package fr.lernejo.umlgrapher;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;


@Command(name = "launcher", mixinStandardHelpOptions = true, version = "UMLGraph 1.0", description = "UMLGraph")
public class Launcher implements Callable<Integer> {

        @Option(names = {"-c", "--classes"}, required = true, description = "Fill in the classes from which to base the analysis")
        private Class[] classes= {};
        @Option(names = {"-g", "--graph-type"},description = "Select the type of graph you want to output")
        private final GraphType grType= GraphType.Mermaid;

        @Override
        public Integer call() throws Exception {
            UmlGraph graph = new UmlGraph(classes);
            String output = graph.as(grType);
            System.out.println(output);
            return 0;
        }
        // this example implements Callable, so parsing, error handling and handling user
        // requests for usage help or version help can be done with one line of code.
        public static void main(String... args) {
            int exitCode = new CommandLine(new Launcher()).execute(args);
            System.exit(exitCode);
        }
}

