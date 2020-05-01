import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        //createGUI();
        InitGraph initGraph = new InitGraph();
        DirectedGraph directedGraph = initGraph.initDirectedGraphWithAdjMatrix(Matrix.declareMatrix());
        List<SCC> emptySCCList = new ArrayList<SCC>(0);
        StronglyConnectedComponents stronglyConnectedComponents =
                new StronglyConnectedComponents(emptySCCList);
        stronglyConnectedComponents.findStronglyConnectedComponents(directedGraph);
        System.out.println(directedGraph.printAdjList());
        System.out.println(stronglyConnectedComponents.toString());
    }

//    public static void createGUI()
//    {
//        int heightOfWindow = 600;
//        int widthOfWindow = 800;
//        JFrame jFrame = new JFrame() {
//        };
//        jFrame.setVisible(true);
//        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        Toolkit toolkit = Toolkit.getDefaultToolkit();
//        Dimension dimension = toolkit.getScreenSize();
//        jFrame.setBounds((dimension.width - widthOfWindow) / 2, (dimension.height - heightOfWindow) / 2, widthOfWindow, heightOfWindow);
//        jFrame.setTitle("this is my app");
//        JPanel jPanel = new JPanel();
//        // jPanel.setLayout(null);
//        jFrame.add(jPanel);
//        JButton jButton = new JButton("getSCC");
//        //JTextField jTextField=new JTextField("0",3);
//        // jTextField.setBounds(100,100,10,10);
//        JTextField[] jTextField = new JTextField[10];
//        // TODO:Implement agjmatrix on window
//        for (int i = 0; i < jTextField.length; ++i) {
//            jTextField[i]=new JTextField("0",1);
//            jPanel.add(jTextField[i]);
//        }
//
//        jButton.setBounds(5, 300, 85, 30);
//        jPanel.add(jButton);
//        jPanel.revalidate();
//        jButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                //todo
//            }
//        });
//    }

}
//TODO:clear smell code
