
public class Node {
	
	private int[] values = new int[3]; //Store data
	 private Node[] children = new Node[4]; //Store child node reference
	 private int size; //The current number of valid data
	 private Node parent; //The parent node of the current node
	 
	Node() {}
	Node(Integer i) {
		values[0] = i;
		size = 1;
	}
 
	 int insert(Integer value) { //Insert data into an ordered array
		assert size < values.length;
		int pos = size;
		while(pos > 0 && values[pos - 1] > value) {
			values[pos] = values[pos - 1];
			pos--;
		}
		values[pos] = value;
		size ++;
		return pos;
	}
 
	Node getChildByValue(Integer value) { // Find the appropriate child node based on the keyword of the given data
		for(int i=0; i<size; i++) {
			if(values[i] > value) return children[i];
		}
		return children[size];
	}
	
	 /// According to the index value of the given sub-node, get the corresponding child node
	Node getChildByIndex(int index) { return children[index]; }
	
	int find(int value) {
		for(int i=0; i<size; i++) {
			if(values[i]== value) return i; 
		}
		return -1;
	}
 
	 Integer removeMax() { return values[--size]; } //Delete the largest data in the current node and return it
	
	 // According to the index value of the given sub-node, delete the parent-child relationship between its corresponding node
	Node removeChild(int index) {	
		Node result = children[index];
		if(result != null)
			result.parent = null;
		children[index] = null;
		return result;
	}
	
	 /// In the current node, insert the corresponding child node after the specified index value, after the original child nodes all backwards
	void insertChild(int index, Node child) {
		for(int i=size; i>index + 1; i--) children[i] = children[i-1];
		children[index+1] = child;
		if(child != null)child.parent = this;
	}
	
	 /// In the current node, the corresponding child node is placed at the position of the specified index value
	void setChild(int index, Node child) {
		children[index] = child;
		if(child != null) child.parent = this;
	}
 
	int size() { return size; }
	
	boolean isFull() { return size ==  values.length; }
 
	boolean isLeaf() { return children[0] == null; }
 
	Node getParent() { return parent; }
 
	Integer getValue(int index) { return values[index]; }
 
}
