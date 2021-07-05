import java.awt.Point;

public class MyEntry implements Entry{
	private int key;
	private Object value;
	
	MyEntry() {
		this.key =0;
		this.value = null;
	}
	
	public MyEntry(int k,Object v) {
		this.key = k;
		this.value=v;
	}
	public void setKey(int k) {
		this.key = k;
	}
	public void setValue(Object v) {
		this.value = v;
	}
	
	@Override
	public int getKey() {
		
		return this.key;
	}

	@Override
	public Object getValue() {
		return this.value;
	}
	
	
}
