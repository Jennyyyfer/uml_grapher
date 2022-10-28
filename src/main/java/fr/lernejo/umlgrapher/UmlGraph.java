package fr.lernejo.umlgrapher;

import java.lang.reflect.Modifier;

public class UmlGraph {
    private final Class<?>[] classes;
    public UmlGraph(Class... classes) {this.classes = classes;}
    public String as(GraphType type) {
        String output = "classDiagram\n";

        for(Class entity : classes){
            if(type == GraphType.Mermaid){
                output += "class " + entity.getSimpleName() + " {\n";
                if(entity.isInterface()){
                    output += "    <<interface>>\n";
                }
            }
            output += "}\n";
        }

        return output;
    }




    /*public String as(GraphType grType) {
        if (grType == GraphType.Mermaid) {
            String graph = "classDiagram";

            for(Class<?> theClass : classes){
                boolean isInterface = Modifier.isInterface(theClass.getModifiers());
                graph += "\nclass %s %s".formatted(
                    theClass.getSimpleName(),
                    isInterface ? "{\n    <<interface>>\n}\n" : "\n"
                );
            }

            return graph;
        }
        return "";
    }*/

}
