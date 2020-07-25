package kurs.GraphComponents;

import lombok.Getter;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Getter
@Component
@Log
public final class StronglyConnectedComponents {
    public static final int UNDEFINED_INDEX = -1;

    private static int index = 0;
    private static final Stack<Vertex> stack = new Stack<>();

    private final List<SCC> sccList = new  ArrayList<>();
    private final DirectedGraph directedGraph;

    @Autowired
    public StronglyConnectedComponents(DirectedGraph directedGraph) {
        this.directedGraph = directedGraph;
    }

    @PostConstruct
    private void initStronglyConnectedComponents() {
        for (Vertex v : directedGraph.getVertexList()) {
            if (v.getIndex() == UNDEFINED_INDEX) {
                strongConnect(v);
            }
        }
        log.info(toString());
    }

    private void strongConnect(Vertex v) {
        v.setIndex(index);
        v.setLowLink(index);
        ++index;
        stack.push(v);
        v.setOnStack(true);

        for (Edge<Integer> e : v.getIncidentEdges()) {

            if (e.getTargetVertex().getIndex() == UNDEFINED_INDEX) {
                strongConnect(e.getTargetVertex());
                e.getSourceVertex().setLowLink(
                        Math.min(e.getSourceVertex().getLowLink(), e.getTargetVertex().getLowLink()));
            } else if (e.getTargetVertex().isOnStack()) {
                e.getSourceVertex().setLowLink(
                        Math.min(e.getSourceVertex().getLowLink(), e.getTargetVertex().getIndex()));
            }
        }

        if (v.getLowLink() == v.getIndex()) {
            Vertex w;
            SCC scc = new SCC(new ArrayList<>(0));
            do {
                w = stack.pop();
                w.setOnStack(false);
                scc.addVertexToSCC(w);
            } while (w != v);
            sccList.add(scc);
        }
    }

    @Override
    public String toString() {
        int numberOfSCC = 0;
        StringBuilder strSCCs = new StringBuilder("StronglyConnectedComponents \n");
        for (SCC scc : sccList) {
            ++numberOfSCC;
            strSCCs.append(numberOfSCC).append(" ").append(scc.toString()).append("\n");
        }
        return strSCCs.toString();
    }
}
