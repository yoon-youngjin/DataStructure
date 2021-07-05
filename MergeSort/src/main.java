import java.util.ArrayList;
import java.util.Random;

public class main {

	public static void main(String[] args) {
		
		// 과제 2-1
		IntComparator ic = new IntComparator();
		MyMergeSort ms = new MyMergeSort(ic);
		ArrayList l = new ArrayList();
		 
		
		
		
		Random random = new Random(); //랜덤 객체 생성(디폴트 시드값 : 현재시간)
        random.setSeed(System.currentTimeMillis()); //시드값 설정을 따로 할수도 있음
        for(int i=0;i<20;i++) {
        	l.add(random.nextInt(100));
        }
        ms.sort(l);
        
       // 과제 2-2 
        StringComparator sc = new StringComparator();
        MyMergeSort ms2 = new MyMergeSort(sc);
        ArrayList l2 = new ArrayList();
        
        String a = "In Computer science, a data"
        		+ " structure is a data organization, management, and storage format that enables efficient access and modification. "
        		+ "More precisely, a data structure is a collection of data values, the relationships among them, and the functions or operations that can be applied to the data";
        
        String[] b = a.split(" ");
        
        for(int i=0;i<b.length;i++) {
        	if(b[i].contains(".") || b[i].contains(",")) {
        		b[i] = b[i].substring(0, b[i].length()-1);
        	}
        	b[i] = b[i].toLowerCase();
        	System.out.print(b[i]+" ");
        	
        }
        System.out.println();
		
        for(int i=0;i<b.length;i++) {
        	l2.add(b[i]);
        }
        
        ms2.sort(l2);
        
       




	}

}
