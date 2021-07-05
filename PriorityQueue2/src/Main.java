import java.awt.Point;

public class Main {

	public static void main(String[] args) {
		
		Point a = new Point(5,4);
		Point b = new Point(2,7);
		Point c = new Point(9,5);
		Point d = new Point(3,1);
		Point e = new Point(7,2);
		Point f = new Point(9,7);
		Point g = new Point(1,4);
		Point h = new Point(4,3);
		Point i = new Point(8,2);
		Point j = new Point(4,8);
		
		PointComparator pc = new PointComparator();
		MyPQ pq2 = new MyPQ(pc);
		pq2.insert('a', a);
		pq2.insert('b', b);
		pq2.insert('c', c);
		pq2.insert('d', d);
		pq2.insert('e', e);
		pq2.insert('f', f);
		pq2.insert('g', g);
		pq2.insert('h', h);
		pq2.insert('i', i);
		pq2.insert('j', j);
		
		System.out.println("[가까운 순서]");
		pq2.removeAll();

		System.out.println("----------------------------------");

		PointComparator2 pc2 = new PointComparator2();
		MyPQ pq3 = new MyPQ(pc2);
		pq3.insert('a', a);
		pq3.insert('b', b);
		pq3.insert('c', c);
		pq3.insert('d', d);
		pq3.insert('e', e);
		pq3.insert('f', f);
		pq3.insert('g', g);
		pq3.insert('h', h);
		pq3.insert('i', i);
		pq3.insert('j', j);
		
		System.out.println("[멀리 있는 순서]");	
		pq3.removeAll();

		
		
		
	}

}
