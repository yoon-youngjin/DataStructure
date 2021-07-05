import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		MyDictionary md = new MyDictionary(5);
		
		
		md.insert(5, "A");
		md.insert(3, "B");
		md.insert(2, "C");
		md.insert(1, "D");
		md.insert(7, "E");
		md.insert(9, "F");
		md.insert(8, "Q");
		
		System.out.println(md.findAll(5));
		
		ArrayList dd = md.entries();
		for(int i=0;i<dd.size();i++) {
			MyEntry aa =(MyEntry)dd.get(i);
			System.out.println(aa.getKey());
		}
		
		System.out.println(md.remove(3));
		
		System.out.println(md.bineary_Search(5));
		
		
		MyEntry a =md.bineary_Search(5);
		System.out.println(a.getValue());
		
//		ArrayList ma = md.entries();
//		for()
//		System.out.println(md.findAll(5));
//		
//		MyEntry result = md.remove(3);
//		
//		System.out.println(result.getValue());
//		
//		MyEntry temp = md.find(5);
//		
//		System.out.println(temp.getValue());
//		
//		
//		
//		for(int i=0;i<md.myArray.size();i++) {
//			MyEntry a = (MyEntry)d.get(i);
//			System.out.println(a.getKey());
//		}
		
		

	}

}
