import java.util.ArrayList;

public class MyDictionary {
	
	private ArrayList myArray;
	private int size = 0;
	
	
	MyDictionary(int initialCapacity) {
		this.myArray = new ArrayList(initialCapacity);
		this.size =initialCapacity;
		
		
	}
	
	private boolean isEmpty() {
		if(myArray.isEmpty()) return true;
		return false;
	}
	
	public int size() {
		return myArray.size();
	}
	
	private boolean isFull() {
		if(this.myArray.size()==size) return true;
		return false;
	}
	
	
	
	
	public MyEntry find(int k) {
		for(int i=0;i<this.myArray.size();i++) {
			MyEntry temp = (MyEntry)myArray.get(i);
			int key = temp.getKey();
			if(k==key) {
				return temp;
			}
		}
		return null;
	}
	
	public MyEntry bineary_Search(int k) {
		int left = 0;
		int right = this.myArray.size()-1;
		int mid;
		
		MyEntry temp = null ;
		
		while(left<=right) {
			
			mid = (left+right)/2;
			temp = (MyEntry)myArray.get(mid);
			int key = temp.getKey();
			
			if(k==key) {
				System.out.println("Find!");
				break;
			}
			if(k < key) {
				right = mid-1;
			}
			else {
				left = mid+1;
			}
			
		}
		return temp;
		
		
	}
	
	
	
	public ArrayList findAll(int k) {
		ArrayList temp2 = new ArrayList();
		for(int i=0;i<this.myArray.size();i++) {
			MyEntry temp = (MyEntry)myArray.get(i);
			int key = temp.getKey();
			if(k==key) {
				temp2.add(temp);
			}
		}
		
		return temp2;
		
	}
	
	public MyEntry remove(int k) {
		for(int i=0;i<this.myArray.size();i++) {
			MyEntry temp = (MyEntry)myArray.get(i);
			int key = temp.getKey();
			if(k==key) {
				
				this.myArray.remove(i);
				return temp;
			}
		}
		return null;
	}
	
	public MyEntry insert(int k,Object v) {
		
		
		MyEntry temp = new MyEntry(k,v);
		
		if(myArray.size()==0) {
			myArray.add(temp);
		}
		
		else {
			for(int i=0;i<myArray.size();i++) {
				
				MyEntry temp2 = (MyEntry)myArray.get(i);
				int key = temp2.getKey();
				if(k<=key) {
					myArray.add(i,temp);
					return temp;
				}
			}
			myArray.add(myArray.size(),temp);
		}
		
		return temp;
	}
	
	public ArrayList entries() {
		
		
		return this.myArray;
	}
	
	
	
	

}
