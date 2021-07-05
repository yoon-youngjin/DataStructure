import java.awt.Point;

public class Main {

	public static void main(String[] args) {
		IntComparator ic = new IntComparator();
		MyPQ pq = new MyPQ(ic);
		MyPQ pq2 = new MyPQ(5,ic);
		System.out.println(pq2.list.size());
		
		pq.insert(new Integer(30), null);
		pq.insert(new Integer(10), null);
		pq.insert(new Integer(20), null);
		
		System.out.println(pq.list.size());
		
		System.out.println((Integer)pq.removeMin().getKey());
		System.out.println((Integer)pq.removeMin().getKey());
		System.out.println((Integer)pq.removeMin().getKey());
		
		
		
		
		
	}

}
