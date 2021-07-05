import java.util.Comparator;

public class IntComparator implements Comparator{
	// compare(a,b) -> a<=b : i<0,a=b : i=0,a>=b :i>0
	@Override
	public int compare(Object o1, Object o2) {
		return (int)o1 - (int)o2;
	}
	
}
