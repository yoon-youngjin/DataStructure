import java.util.ArrayList;

public class MyHashTable {
	
	private ArrayList bucketArray;
	private int bucketCapacity;
	private float size =0;
	private float loadFactor ;
	private float standard ;
	
	
	MyHashTable(int initialCapacity) {
		this.bucketArray = new ArrayList(initialCapacity);
		for(int i=0;i<initialCapacity;i++) {
			bucketArray.add(new ArrayList());
		}
		this.bucketCapacity = initialCapacity;
		this.standard=10;
	}
	
	
	MyHashTable(int initialCapacity,float loadFactor) {
		this.bucketArray = new ArrayList(initialCapacity);
		for(int i=0;i<initialCapacity;i++) {
			bucketArray.add(new ArrayList());
		}
		this.bucketCapacity = initialCapacity;
		this.standard = loadFactor;
	}
	
	
	private int hashFunc(String k) {
		int hash_code = 0;
		for(int i=0;i<k.length();i++) {
			char temp = k.charAt(i);
			int num = Character.getNumericValue(temp);
			hash_code += num;
		}
		hash_code  = hash_code% this.bucketCapacity;
		return hash_code;
		
	}
	
	public int size() {
		return this.bucketCapacity;
	}
	
	public String get(String k) {
		int hashcode = hashFunc(k);
		Object result = bucketArray.get(hashcode);
	
		for(int i=0;i<((ArrayList)result).size();i++) {
			if(k.equals(((StudentInfo)(((ArrayList)result).get(i))).getStudentID())) {
				return ((StudentInfo)(((ArrayList)result).get(i))).getStudentName();
			}
		}
		return null;
		
	}
	public String put(String k,String v) {
		//System.out.println(size/this.bucketArray.size());
		
		if(getLoadFactor()>this.standard) {
			System.out.println("rehashplz");
			rehash(2 *this.bucketArray.size());
		}
		
		StudentInfo student = new StudentInfo();
		student.setStudentID(k);
		student.setStudentName(v);
		
		
		int hashcode = hashFunc(k);
		if(((ArrayList)(bucketArray.get(hashcode)))==null) {
			ArrayList a = new ArrayList();
			a.add(student);
			size++;
			this.loadFactor = this.size/size();
			return student.getStudentName();
		}
		else {
			((ArrayList)(bucketArray.get(hashcode))).add(student);
			size++;
			this.loadFactor = this.size/size();
			return student.getStudentName();
		}

	}
	public String remove(String k) {
		int hashcode = hashFunc(k);
		Object temp = bucketArray.get(hashcode);
		
		for(int i=0;i<((ArrayList)temp).size();i++) {
			
			if(k.equals(((StudentInfo)(((ArrayList)temp).get(i))).getStudentID())) {
				size--;
				this.loadFactor = size/this.bucketCapacity;
				return ((StudentInfo)(((ArrayList)temp).remove(i))).getStudentName();
			}
		}
		
		return null;
		
	}
	
	public float getLoadFactor() {
		return size/this.bucketCapacity;
	}
	
	public void rehash(int capacity) {
		ArrayList rearray = new ArrayList(capacity);
		
		for(int i=0;i<capacity;i++) {
			
			rearray.add(new ArrayList());
			
		}
		
		
		for(int i=0;i<capacity/2;i++) {
			rearray.set(i,this.bucketArray.get(i));
		}
		this.bucketCapacity = this.bucketCapacity*2;
		this.bucketArray = rearray;
		
		
	}
	
}
