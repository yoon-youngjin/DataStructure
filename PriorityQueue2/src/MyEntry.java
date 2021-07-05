import java.awt.Point;

public class MyEntry implements Entry{
	private Object key;
	private Object value;
	
	public MyEntry(Object k,Object v) {
		this.key = k;
		this.value=v;
	}
	public void setKey(Object k) {
		this.key = k;
	}
	public void setValue(Object v) {
		this.value = v;
	}
	
	@Override
	public Object getKey() {
		
		return this.key;
	}

	@Override
	public Object getValue() {
		return this.value;
	}
	public String toString() {
		return key+"("+((Point)value).x+","+((Point)value).y+")";
	}
	
}
