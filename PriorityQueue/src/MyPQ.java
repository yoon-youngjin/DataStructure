import java.util.ArrayList;
import java.awt.Point;
import java.util.Comparator;

public class MyPQ {
	public ArrayList list;
	private Comparator icpt;
	MyPQ(Comparator comp) {
		this.list = new ArrayList();
		this.icpt = comp;
	}
	
	MyPQ(int initialCapacity, Comparator comp) {
		this.list = new ArrayList(initialCapacity);
		this.icpt = comp;
	}
	
	public int size() {
		return list.size();
	}
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public MyEntry insert(Object k,Object v) 
	{
		
		MyEntry newEntry = new MyEntry(k,v);
		int j=0;
		int size = list.size();

		for(int i=0;i<size;i++) {
			MyEntry temp = (MyEntry)list.get(i);
			if(this.icpt.compare(k, temp.getKey())>0) {
				j++;
			}
		}
		
		list.add(j,newEntry);
		return newEntry;
	}

	public MyEntry removeMin() {
		return (MyEntry)list.remove(0);
	}
	public MyEntry min() {
		return (MyEntry)list.get(0);
	}
}

	
	

	
	
	


