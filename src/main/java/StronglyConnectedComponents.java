import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StronglyConnectedComponents {
    public static final int UNDEFINED = -1;
    private List<SCC> stronglyConnectedComponents;
    //index := 0
    static int index = 0;
    // S := empty stack
    static Stack<Vertex> stack = new Stack<Vertex>();

    public StronglyConnectedComponents(List<SCC> stronglyConnectedComponents) {
        this.stronglyConnectedComponents = stronglyConnectedComponents;
    }

    public void findStronglyConnectedComponents(DirectedGraph directedGraph) {
        // for each v in V do
        for (Vertex v : directedGraph.getVertexList()) {
            //if v.index is undefined then
            if (v.getIndex() == UNDEFINED) {
                strongconnect(v);
            }
        }
    }

    //v-sourceVertex w-TargetVertex
    private void strongconnect(Vertex v) {
        /*������������ ������ ������� ��� v �� ���������� �������������� ������*/
        //v.index := index
        v.setIndex(index);
        //v.lowlink := index
        v.setLowlink(index);
        //index := index + 1
        ++index;
        //S.push(v)
        stack.push(v);
        //v.onStack := true
        v.setOnStack(true);
        /*���������� ����������� v*/
        //for each (v, w) in E do
        for (Edge e : v.getEdges()) {
            //if w.index is undefined then
            if (e.getTargetVertex().getIndex() == UNDEFINED) {
                /*w ��� �� ��� �������; �������� �� ���*/
                //strongconnect(w)
                strongconnect(e.getTargetVertex());
                //v.lowlink := min(v.lowlink, w.lowlink)
                e.getSourceVertex().setLowlink(Math.min
                        (e.getSourceVertex().getLowlink(), e.getTargetVertex().getLowlink()));

            }
            //else if w.onStack then
            else if (e.getTargetVertex().isOnStack()) {
                /*w ��������� � ����� � ������������� � ������� ���*/
                /*���� w �� ��������� � �����,����� (v, w) - ��� �����,
                 *����������� �� ��� ��������� ���, � ��� ������� ������������*/
                //v.lowlink := min(v.lowlink, w.index)
                e.getSourceVertex().setLowlink(Math.min
                        (e.getSourceVertex().getLowlink(), e.getTargetVertex().getIndex()));
            }//end if
        }//end for
        //if v.lowlink = v.index then start a new strongly connected component
        if (v.getLowlink() == v.getIndex()) {
            List<Vertex> emptyVertexList = new ArrayList<Vertex>(0);
            Vertex w = v;
            SCC stronglyConnectedComponent = new SCC(emptyVertexList);
            do {
                //w := S.pop()
                w = stack.pop();
                //w.onStack := false
                w.setOnStack(false);
                /*�������� w � ������ ���*/
                stronglyConnectedComponent.addVertexToSCC(w);
            } while (w != v);
            /*����� �������� ���*/
            stronglyConnectedComponents.add(stronglyConnectedComponent);
        }// end if
    }//end function

    public List<SCC> getStronglyConnectedComponents() {
        return stronglyConnectedComponents;
    }

    public void setStronglyConnectedComponents(List<SCC> stronglyConnectedComponents) {
        this.stronglyConnectedComponents = stronglyConnectedComponents;
    }

    @Override
    public String toString() {
        int numberOfSCC = 0;
        String strSCCs = "StronglyConnectedComponents \n";
        for (SCC scc : stronglyConnectedComponents) {
            ++numberOfSCC;
            strSCCs += String.valueOf(numberOfSCC) + " " + scc.toString() + "\n";
        }
        return strSCCs;
    }
}
