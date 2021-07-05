import java.util.ArrayList;

public class MyVertex {
	
	private Object vertex_element;
	private ArrayList incidence_list;
	private String label;
	
	public MyVertex(Object v) {
		this.vertex_element = v;
		this.incidence_list = new ArrayList();
		this.label = "unexplored";
	}
	
	public Object getVertexElement() {
		return this.vertex_element;
	}
	
	public void setVertexElement(String v) {
		this.vertex_element = v;
	}
	
	public ArrayList getIncidenceList() {
		return this.incidence_list;
	}
	
	public void setIncidenceList(ArrayList i) {
		this.incidence_list = i;
	}
	
	public void addEdgetoIncidenceList(MyEdge e){		
		this.incidence_list.add(e);
	}
	
	public String getLabel() {
		return this.label;
	}
	
	public void setLabel(String s) {
		this.label = s;
	}
	

}