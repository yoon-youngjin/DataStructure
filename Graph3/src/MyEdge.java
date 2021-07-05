
public class MyEdge {
	
	private MyVertex prev;
	private MyVertex next;
	private Object edge_element;
	private String label;
	
	public MyEdge(Object e) {
		this.prev = null;
		this.next = null;
		this.edge_element = e;
		this.label = "unexplored";
	}
	
	public MyEdge(Object e, MyVertex p, MyVertex n) {
		this.prev = p;
		this.next = n;		
		this.edge_element = e;
	}
	
	public MyVertex getPrev() {
		return this.prev;
	}
	
	public MyVertex getNext() {
		return this.next;
	}
	
	public Object getEdgeElement() {
		return this.edge_element;
	}
	
	public void setPrev(MyVertex p) {
		this.prev = p;
	}
	
	public void setNext(MyVertex n) {
		this.next = n;
	}		
	
	public void setEdgeElement(Object e) {
		this.edge_element = e;
	}
	
	public String getLabel() {
		return this.label;
	}
	
	public void setLabel(String s) {
		this.label = s;
	}
	
}
