package Tree;

public class data {
	String title;
	int size;
	public data(String t) {
		this.title = t;
		this.size = 0;
		
	}
	public data(String t,int s) {
		this.title = t;
		this.size = s;
	}
	public int getSize() {
		return this.size;
	}
	public String getTitle() {
		return this.title;
	}
	public void setSize(int s) {
		this.size = s;
	}

}
