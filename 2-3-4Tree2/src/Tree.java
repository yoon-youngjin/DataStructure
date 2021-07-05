

class Tree {
	private Node root = new Node(); //root node
	 public void insert(Integer value) { //Insert data into the tree
		 Node current = root; //Search for the appropriate leaf node from the root down
		while(!current.isLeaf()) {
			 if(current.isFull()) 
				 current = split(current); //If the downstream process encounters a full node, split
			current = current.getChildByValue(value);	
		}
	
		 if(current.isFull()) { //If the leaf node finally found is full, split first
			current = split(current);	
			current = current.getChildByValue(value);	
		}
		 current.insert(value); // insert data in the leaf node
	}
 
	public boolean contains(Integer value) {
		Node current  = root;
		while(!current.isLeaf()) {
			if(current.find(value) != -1) return true;
			current = current.getChildByValue(value);
		}
		return current.find(value) != -1;
	}
 
	 public void ordinal() { //Amp order all the data in the input tree
		ordinal(root);
	}
 
	private void ordinal(Node current) {
		for(int i=0; i<current.size(); i++) {
			if(!current.isLeaf()) ordinal(current.getChildByIndex(i));
			System.out.println(current.getValue(i));
		}
		if(!current.isLeaf()) ordinal(current.getChildByIndex(current.size()));
	}
 
	 private Node split(Node current) { // splitting algorithm
		 Node parent = current.getParent(); //Find the parent of the current node
		if(parent == null) parent = new Node();
		 // Split the current node into the left node, the right node, the middle of the data, the right node is a new node
		Node nodeLeft = current;
		Node nodeRight = new Node(current.removeMax());
		Integer middle = current.removeMax();
		 // Disconnect the 2, 3 child nodes in the current node, and join the right byte
		Node child1 = nodeLeft.removeChild(2);
		Node child2 = nodeLeft.removeChild(3);
		nodeRight.setChild(0,child1);
		nodeRight.setChild(1,child2);
 
		 int index = parent.insert(middle); //Add the intermediate data to its parent and get the inserted location
		
		 if(current == root) { //If the current node is the root node, add the left and right nodes in the new parent node
			parent.setChild(0,nodeLeft);
			parent.setChild(1,nodeRight);
			 root = parent; //reset the root node
		 } 
		 else parent.insertChild(index,nodeRight); //Otherwise, insert the right node after specifying the position in the parent node
 
		 return parent; //return the parent node
	}
 
	public static void main(String[] args) {
		Tree t = new Tree();
		t.insert(5);
		t.insert(6);
		t.insert(7);
		t.insert(8);
		t.insert(9);
		t.insert(10);
		t.insert(30);
		t.insert(50);
		t.insert(11);
		t.insert(17);
		t.insert(19);
		t.insert(54);
		t.insert(66);
		t.insert(72);
		t.insert(89);
		t.insert(92);
		t.insert(40);
		t.insert(28);
		t.insert(13);
		t.insert(14);
		t.insert(16);
		t.ordinal();
	}
}
