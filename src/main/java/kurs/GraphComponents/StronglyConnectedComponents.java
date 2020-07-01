package kurs.GraphComponents;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Data
@AllArgsConstructor
@Component
public class StronglyConnectedComponents {
    public static final int UNDEFINED_INDEX = -1;

    private List<SCC> sccList;

    private static int index = 0;
    private static Stack<Vertex> stack = new Stack<>();

    @Autowired
    private void initStronglyConnectedComponents(DirectedGraph directedGraph) {
        for (Vertex v : directedGraph.getVertexList()) {
            if (v.getIndex() == UNDEFINED_INDEX) {
                strongConnect(v);
            }
        }
    }

    private void strongConnect(Vertex v) {
        v.setIndex(index);
        v.setLowLink(index);
        ++index;
        stack.push(v);
        v.setOnStack(true);

        for (Edge e : v.getIncidentEdges()) {

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

    /**
     * @return - string representation of strongly connected components
     */
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
