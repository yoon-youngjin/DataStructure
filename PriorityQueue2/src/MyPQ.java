import java.util.ArrayList;
import java.awt.Point;
import java.util.Comparator;

public class MyPQ {
	private ArrayList list;
	private Comparator cpt;
	
	
	MyPQ(PointComparator comp) {
		this.list = new ArrayList();
		this.cpt = comp;
	}
	MyPQ(PointComparator2 comp) {
		this.list = new ArrayList();
		this.cpt = comp;
	}
	
	MyPQ(int initialCapacity, Comparator comp) {
		this.list = new ArrayList(initialCapacity);
		this.cpt = comp;
	}
	
	public int size() {
		return list.size();
	}
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public MyEntry insert(Object k,Object v) 
	{
		double distance = 0;
		if(cpt instanceof PointComparator2) {
			
			distance = ((PointComparator2)cpt).distance((Point)v);
			
		}
		if(cpt instanceof PointComparator) {
			
			distance = ((PointComparator)cpt).distance((Point)v);
			
		}
		
		
		MyEntry newEntry = new MyEntry(k,v);
		int j = 0;
		int size = list.size();

		if(cpt instanceof PointComparator) {
			
			for(int i=0;i<size;i++) {
				MyEntry temp = (MyEntry)list.get(i);
				int a = (int)distance;
				int b = (int)((PointComparator)cpt).distance((Point)temp.getValue());
				if(this.cpt.compare(a, b)>0) {
					j++;
				}
			}
		}
		if(cpt instanceof PointComparator2) {
			
			for(int i=0;i<size;i++) {
				MyEntry temp = (MyEntry)list.get(i);
				int a = (int)distance;
				int b = (int)((PointComparator2)cpt).distance((Point)temp.getValue());
				if(this.cpt.compare(a, b)<0) {
					j++;
				}
			}
		}
	
		list.add(j,newEntry);
		return newEntry;
	}
	public void removeAll() {
		int size = list.size();
		for(int i=0;i<size;i++) {
			System.out.println(removeMin());
		}
	}

	public MyEntry removeMin() {
		return (MyEntry)list.remove(0);
	}
	public MyEntry min() {
		return (MyEntry)list.get(0);
	}
}

	
	

	
	
	


