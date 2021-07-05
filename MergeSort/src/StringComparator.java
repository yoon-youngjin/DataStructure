import java.util.Comparator;

public class StringComparator implements Comparator{

	@Override
	public int compare(Object s0, Object s1) {
		String a = (String)s0;
		String b = (String)s1;
		
		if(a.compareTo(b)>0) {
			return 1;
		}
		else return -1;
		
		
		
//		if(a.compareTo(b)<0) {
//			System.out.println(a.compareTo(b));
//			return 1;
//		}
//		else return -1;
//	
	}

}
