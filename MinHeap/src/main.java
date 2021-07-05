
public class main {

	public static void main(String[] args) {
		MinHeap hp = new MinHeap();
		int[] a = {5,4,2,5,7,8};
		int[] b = {0,0,0,0,0,0};
		
		for(int i=0;i<a.length;i++) {
			hp.insert(a[i]);
			
	
		}
//		for(int i=0;i<a.length;i++) {
//			b[i] = hp.delete();
//			System.out.println(b[i]);
//	
//		}
		System.out.println(hp.getMin());
		
		

	}

}
