
import java.awt.Point;
import java.util.Comparator;

public class PointComparator implements Comparator{
	
	public double distance(Point a) {
		return Math.sqrt(Math.pow(a.getX(),2)+Math.pow(a.getY(), 2));
	}

	public int compare(Object o1 , Object o2) {
		return (int)o1-(int)o2;
	}
	

}
