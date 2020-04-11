import java.util.ArrayList;
import java.util.Stack;

public class StronglyConnectedComponents {
    private ArrayList<SCC> stronglyConnectedComponents;
    //index := 0
    static int index = 0;
    // S := empty stack
    static Stack<Vertex> stack = new Stack<Vertex>();

    public StronglyConnectedComponents(ArrayList<SCC> stronglyConnectedComponents) {
        this.stronglyConnectedComponents = stronglyConnectedComponents;
    }

    public void findStronglyConnectedComponents(DirectedGraph directedGraph) {
        // for each v in V do
        for (Vertex v : directedGraph.getVertexList()) {
            //if v.index is undefined then
            if (v.getIndex() == -1) {
                strongconnect(v);
            }
        }
    }

    //v-sourceVertex w-TargetVertex
    private void strongconnect(Vertex v) {
        /*Устанавливаю индекс глубины для v на наименьший неиспользуемый индекс*/
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
        /*Перебираем наследников v*/
        //for each (v, w) in E do
        for (Edge e : v.getEdges()) {
            //if w.index is undefined then
            if (e.getTargetVertex().getIndex() == -1) {
                /*w еще не был посещен; рекурсия на нем*/
                //strongconnect(w)
                strongconnect(e.getTargetVertex());
                //v.lowlink := min(v.lowlink, w.lowlink)
                e.getSourceVertex().setLowlink(Math.min
                        (e.getSourceVertex().getLowlink(), e.getTargetVertex().getLowlink()));

            }
            //else if w.onStack then
            else if (e.getTargetVertex().isOnStack()) {
                /*w находится в стеке и следовательно в текущем СКС*/
                /*Если w не находится в стеке,тогда (v, w) - это ребро,
                 *указывающее на уже найденный ССК, и его следует игнорировать*/
                //v.lowlink := min(v.lowlink, w.index)
                e.getSourceVertex().setLowlink(Math.min
                        (e.getSourceVertex().getLowlink(), e.getTargetVertex().getIndex()));
            }//end if
        }//end for
        //if v.lowlink = v.index then start a new strongly connected component
        if (v.getLowlink() == v.getIndex()) {
            ArrayList<Vertex> emptyVertexList = new ArrayList<Vertex>(0);
            Vertex w = v;
            SCC stronglyConnectedComponent = new SCC(emptyVertexList);
            do {
                //w := S.pop()
                w = stack.pop();
                //w.onStack := false
                w.setOnStack(false);
                /*добавить w в текущй ССК*/
                stronglyConnectedComponent.addVertexToSCC(w);
            } while (w != v);
            /*вывод текущего ССК*/
            stronglyConnectedComponents.add(stronglyConnectedComponent);
        }// end if
    }//end function

    public ArrayList<SCC> getStronglyConnectedComponents() {
        return stronglyConnectedComponents;
    }

    public void setStronglyConnectedComponents(ArrayList<SCC> stronglyConnectedComponents) {
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
