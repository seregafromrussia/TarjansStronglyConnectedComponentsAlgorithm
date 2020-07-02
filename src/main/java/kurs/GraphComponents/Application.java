package kurs.GraphComponents;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Application {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext
                        ("applicationContext.xml");

        DirectedGraph directedGraph = context.getBean
                        ("directedGraph", DirectedGraph.class);

        StronglyConnectedComponents stronglyConnectedComponents = context.getBean
                        ("stronglyConnectedComponents",
                                StronglyConnectedComponents.class);

        AdjMatrix adjMatrix = context.getBean("adjMatrix", AdjMatrix.class);

        System.out.println(adjMatrix.toString());
        System.out.println(directedGraph.printAdjList());
        System.out.println(stronglyConnectedComponents.toString());
    }
}

