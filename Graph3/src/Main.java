import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyGraph mg = new MyGraph();
		MyVertex v1 = mg.insertVertex(1);
		MyVertex v2 = mg.insertVertex(2);
		MyVertex v3 = mg.insertVertex(3);
		MyVertex v4 = mg.insertVertex(4);
		MyVertex v5 = mg.insertVertex(5);
		MyVertex v6 = mg.insertVertex(6);
		MyVertex v7 = mg.insertVertex(7);
		MyVertex v8 = mg.insertVertex(8);
		
		mg.insertEdge(3, v1 , v2);
		mg.insertEdge(4, v1 , v3);
		mg.insertEdge(null, v1 , v4);
		mg.insertEdge(null, v2 , v3);
		mg.insertEdge(null, v2 , v5);
		mg.insertEdge(null, v2 , v8);
		mg.insertEdge(null, v3 , v4);
		mg.insertEdge(null, v3 , v6);
		mg.insertEdge(null, v3 , v8);
		mg.insertEdge(null, v4 , v7);
		mg.insertEdge(null, v5 , v8);
		mg.insertEdge(null, v6 , v8);
		mg.insertEdge(null, v7 , v8);
		
		
		System.out.println("전체 vertex의 수 : " + mg.getVertexCnt());
		System.out.println("전체 edge의 수 : " + mg.getEdgeCnt());
		mg.degree_order();
		System.out.println();
		
		mg.BFS(v1);
		System.out.println();
		System.out.println(mg.getEdge().getClass());
		System.out.println(((MyEdge)((ArrayList)mg.getEdge()).get(0)).getEdgeElement());
		System.out.println();
		
		Scanner scan = new Scanner(System.in);
		System.out.print("\nRoot vertex 입력 : ");
		int input = scan.nextInt();
		mg.Spanning_Tree(input);
		System.out.print("\nRoot vertex 입력 : ");
		input = scan.nextInt();
		mg.Spanning_Tree(input);
		System.out.print("\nRoot vertex 입력 : ");
		input = scan.nextInt();
		mg.Spanning_Tree(input);
		
		
		
	}

}
