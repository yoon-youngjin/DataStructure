import java.util.ArrayList;
import java.util.Stack;

public class MyGraph {
	
	private ArrayList vertex_list;
	private ArrayList edge_list;
	
	public MyGraph() {
		this.vertex_list = new ArrayList();
		this.edge_list = new ArrayList();
	}
	
	public MyVertex insertVertex(Object element) {
		MyVertex newVertex = new MyVertex(element);
		this.vertex_list.add(newVertex);
		return newVertex;
	}
	
	public MyEdge insertEdge(Object element, MyVertex pre, MyVertex next) {
		MyEdge newEdge = new MyEdge(element, pre, next);
		pre.addEdgetoIncidenceList(newEdge);
		next.addEdgetoIncidenceList(newEdge);
		this.edge_list.add(newEdge);
		return newEdge;
	}
	public ArrayList getEdge() {
		
		return this.edge_list;
	}
	
	public ArrayList incidentEdges(MyVertex v) {
		return v.getIncidenceList();
	}
	
	public MyVertex opposite(MyVertex v, MyEdge e) {
		if(v.getIncidenceList().contains(e)) {
			if(e.getNext() == v) {
				return e.getPrev();
			}
			else
				return e.getNext();
		}
		else
			return null;
	}
	
	//��ü vertex��
	public int getVertexCnt() {
		return vertex_list.size();
	}
	
	//��ü edge�� ��
	public int getEdgeCnt() {
		return edge_list.size();
	}
	
	//degree�� ����
	public void degree_order() {
		ArrayList degreelist = new ArrayList();
		ArrayList newvertex = (ArrayList)vertex_list.clone();
		for(int i = 0 ; i < vertex_list.size(); i++) {
			degreelist.add(((MyVertex)vertex_list.get(i)).getIncidenceList().size());
		}
		
		for(int i = 0 ; i < degreelist.size() - 1; i++) {
			for(int j = 1; j < degreelist.size() - i ; j++) {
				if((int)degreelist.get(i) <= (int)degreelist.get(i + j)) {
					int tmp = (int)degreelist.get(i);
					degreelist.set(i, degreelist.get(i + j));
					degreelist.set(i+j, tmp);
				
					MyVertex tmpver = (MyVertex)newvertex.get(i);
					newvertex.set(i, newvertex.get(i + j));
					newvertex.set(i+j,tmpver);
				}
			}
		}
		
		System.out.print("Degree ���� : ");
		for(int i = 0 ; i < newvertex.size(); i++) {
			System.out.print(((MyVertex)newvertex.get(i)).getVertexElement()+",");
			
		}
	}
	
	
	public void Spanning_Tree(int v) {
		
		for(int i =0 ; i < vertex_list.size(); i++) {
			if((int)((MyVertex)vertex_list.get(i)).getVertexElement() == v) {
				BFS((MyVertex)vertex_list.get(i));
			}
		}
	}
	
	//spanning_tree�� preorder �湮������ ��� BFS 
	public void BFS(MyVertex v) {
		allvertexUnexplorde();
		ArrayList<ArrayList> blist  = new ArrayList<ArrayList>();
		v.setLabel("visited");
		System.out.print(v.getVertexElement()+",");
		blist.add(0, new ArrayList<MyVertex>());
		blist.get(0).add(v);
		int i = 0;
		while(!(blist.get(i).isEmpty())) {
			
			blist.add(i + 1, new ArrayList<MyVertex>());
			for(int j = 0 ; j < blist.get(i).size(); j++) {
				//j �� �� level�� node������ŭ
				
				for(int k = 0 ; k < incidentEdges((MyVertex)blist.get(i).get(j)).size(); k++) {
					//k = incidentedges�� ������ŭ ����
					
					 if(((MyEdge)incidentEdges((MyVertex)blist.get(i).get(j)).get(k)).getLabel() == "unexplored") {
						 //edge�� ���� unexplored �ϋ�
						 MyVertex w = opposite((MyVertex)blist.get(i).get(j),((MyEdge)incidentEdges((MyVertex)blist.get(i).get(j)).get(k)));
						 if(w.getLabel() == "unexplored") {
							 //���� vertex�� unexplored�ϋ�
							 ((MyEdge)incidentEdges((MyVertex)blist.get(i).get(j)).get(k)).setLabel("discovery");
							 w.setLabel("visited");
							 System.out.print(w.getVertexElement()+",");
							 blist.get(i+1).add(w);
						 }
						 else {
							 //unexplored�� �ƴҶ�
							 ((MyEdge)incidentEdges((MyVertex)blist.get(i).get(j)).get(k)).setLabel("cross");
						 }
					 }
				}
			}
			i += 1;
		}
		
		
	}
	// DFS����
	
	private void allvertexUnexplorde() {
		for(int i = 0 ; i < vertex_list.size(); i++) {
			((MyVertex)vertex_list.get(i)).setLabel("unexplored");
		}
		for(int i = 0 ; i < edge_list.size(); i++) {
			((MyEdge)edge_list.get(i)).setLabel("unexplored");
		}
		
	}
	
	
	
	
}
