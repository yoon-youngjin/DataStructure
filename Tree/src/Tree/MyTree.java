package Tree;

import java.util.ArrayList;

public class MyTree {
	private MyNode root;
	private int size;
	private int sum=0;
	private int depth =0;
	private int height = 0;
	public MyTree() {
		this.root = null;
	}
	
	public MyTree(Object e) {
		this.root = new MyNode(e,0);
		this.root.setChildren(new ArrayList());
	}	
	public void Preorder(MyNode v) { 
		MyNode m;
		if(v.hasChildren()) {
			if(v.level()==0) {
				System.out.println(v.element());
			}
			for(int i=0;i<v.children().size();i++) {
				m = (MyNode) v.children().get(i);
				if(m.level()==1) System.out.print(" ");
				if(m.level()==2) System.out.print("  ");
				System.out.println(m.element());
				Preorder(m);
			}
		}
	}	
	
	public void Postorder(MyNode v) {
		MyNode m;
		if(v.hasChildren()) {
			for(int i=0;i<v.children().size();i++) {
				m =(MyNode) v.children().get(i);
				Postorder(m);
				if(m.level()==1 || !m.hasChildren()) {
					int k = ((data) m.element()).getSize();
					sum += k;
				}
				
				
			}
			((data) v.element()).setSize(sum);
			sum =0;
			System.out.print(((data) v.element()).getTitle()+"=");
			System.out.println(((data) v.element()).getSize()+"KB");
		}
	}
	public int depth(MyNode p) {
		
		if(p == this.root) 
			return 0;
		else {
			depth = 1+ depth(p.parent());
			return depth;
		}
		
	}
	
	public int height (MyNode p) {
		if(!p.hasChildren())
			return 0;
		else {
			height = 1 + height((MyNode) p.children().get(0));
			return height;
		}
		
	}
	
	public int size() {
		return this.size;
	}
	
	public MyNode root() {
		return this.root;
	}
	
	public ArrayList children(MyNode v) {
		return v.children();
	}
	
	public boolean isExternal(MyNode v) {
		return (v.degree()==0);
	}
	
	public MyNode addRoot(Object e) {
		
		this.root = new MyNode(e,0);
		this.size =1;
		return this.root; 
		 
	}
	
	
	
	public MyNode addNode(Object e) {
		MyNode newNode = new MyNode(e,root.level() + 1);
		newNode.setParent(this.root);
		this.root.children().add(newNode);
		this.size ++;
		return newNode;
	}
	
	public MyNode addChild(MyNode v,Object e) {
		MyNode newNode = new MyNode(e,v.level() + 1);
		newNode.setParent(v);
		v.children().add(newNode);
		this.size++;
		return newNode;
	}
	public MyNode addChild(MyNode v,int i,Object e) {
		MyNode newNode = new MyNode(e,v.level() + 1);
		newNode.setParent(v);
		v.children().add(i,newNode);
		this.size++;
		return newNode;	
	}
	public MyNode setChild(MyNode v,int i,Object e) {
		MyNode newNode = new MyNode(e,v.level() + 1);
		newNode.setParent(v);
		v.children().set(i,newNode);
		return newNode;	
	}
	public MyNode removeChild(MyNode v,int i) {
		this.size--;
		return (MyNode)v.children().remove(i);
	}
	
}
