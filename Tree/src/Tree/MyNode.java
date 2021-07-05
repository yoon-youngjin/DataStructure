package Tree;

import java.util.ArrayList;

public class MyNode {
	private Object element;
	private MyNode parent;
	private ArrayList children;
	private int level;
	
	MyNode(){
		element = null;
		parent = null;
		children = new ArrayList();
		level = -1;
	}
	MyNode(Object e, int l){
		element = e;
		parent = null;
		children = new ArrayList();
		level = l;
	}
	
	public Object element() {
		return element;
	}
	
	public MyNode parent() {
		return parent;
	}
	
	public ArrayList children() {
		return children;
	}
	
	public int level() {
		return level;
	}
	
	public int degree() {
		if(children == null)
			return 0;
		return children.size();
	}
	
	public void setElement(Object e) {
		this.element = e;
	}
	
	public void setParent(MyNode p) {
		this.parent = p;
	}
	
	public void setChildren(ArrayList c) {
		this.children = c;
	}
	public boolean hasChildren() {
		return (this.degree()!=0);
	}
}
