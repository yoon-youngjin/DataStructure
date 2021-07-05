package Tree;

public class PreorderMain {

	public static void main(String[] args) {
		MyTree hwtree = new MyTree("Make Money Fast!");
		MyNode root = hwtree.addRoot("Make Money Fast!");
		
		MyNode motivation = hwtree.addNode("1.Motivation");
		MyNode methods = hwtree.addNode("2. Methods");
		MyNode references = hwtree.addNode("3. References");
		
		MyNode greed = hwtree.addChild(motivation,"1.1 Greed");
		MyNode avidity = hwtree.addChild(motivation,"1.2 Avidity");
		
		MyNode fraud = hwtree.addChild(methods,"2.1 Stock Fraud");
		MyNode scheme = hwtree.addChild(methods,"2.2 Ponzi Scheme");
		MyNode robbery = hwtree.addChild(methods,"2.3 Bank Robbery");		
		hwtree.Preorder(root);
		System.out.println(hwtree.depth(fraud));
		System.out.println(hwtree.height(greed));
		
	}

}
