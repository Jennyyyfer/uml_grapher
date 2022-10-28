package fr.lernejo.umlgrapher;

import java.lang.reflect.Modifier;

public class UmlGraph {
    private final Class<?>[] classes;
    public UmlGraph(Class<?> ...classes){
        this.classes = classes;
    }

    public String as(GraphType grType){

        if (grType == GraphType.Mermaid){
            StringBuilder graph = new StringBuilder("classDiagram");
            for(Class<?> theClass : classes){
                boolean isInterface = Modifier.isInterface(theClass.getModifiers());
                graph.append("\nclass %s %s".formatted(
                    theClass.getSimpleName(),
                    isInterface ? "{\n <<interface>>\n}\n" : "\n"
                ));

                /*
                return """
                classDiagram
                class"+ classeDiagram.getSimpleName() +" {
                    <<interface>>
                }
                """;*/
            }
            return graph.toString();
        }
        return "";
    }
}

