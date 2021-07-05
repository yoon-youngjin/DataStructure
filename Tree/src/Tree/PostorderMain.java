package Tree;

public class PostorderMain {
public static void main(String[] args) {
		
		
		
		
		MyTree hw2tree = new MyTree(new data("cs16/"));
		MyNode root2 = hw2tree.addRoot(new data("cs16/"));
		
		MyNode hw = hw2tree.addNode(new data("homeworks/"));
		MyNode h1c = hw2tree.addChild(hw, new data("h1c.doc(3K)",3));
		MyNode h1nc = hw2tree.addChild(hw, new data("h1nc.doc(2K)",2));
			

		MyNode pm = hw2tree.addNode(new data("programs/"));
		MyNode ddr = hw2tree.addChild(pm, new data("DDR.java(10K)",10));
		MyNode stock = hw2tree.addChild(pm, new data("Stocks.java(25K)",25));
		MyNode robot = hw2tree.addChild(pm, new data("Robot.java(20K)",20));
		
		MyNode todo = hw2tree.addNode(new data("todo.txt(1K)",1));
		
		hw2tree.Postorder(root2);
		
	}

}
