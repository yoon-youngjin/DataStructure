import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class MyMergeSort {
	
	private ArrayList L1;
	private ArrayList L2;
	private Comparator comp;
	private int step;
	
	MyMergeSort(Comparator c) {
		L1 = new ArrayList();
		L2 = new ArrayList();
		this.comp = c;
	}
	
	public void sort(ArrayList l) {
        step = 1;
        L1 = l;
        for(int i = 0; i < L1.size(); i++)
            L2.add(null);

        int size = l.size();
        while(step <= l.size() ) {

            for(int i = 0; i < size; i += this.step*2) {

                int leftStart = i;
                int leftLast = (leftStart + this.step)-1;
                

                int rightStart = i + this.step;
                
                
                int rightLast = (rightStart + this.step)-1;
                
                if(rightLast >= size) {
                	rightLast = size-1;
                }
                int idx = i;

                while(true) {
                   
                	 if(rightStart>rightLast) {
                		 for(int j = idx;j<=rightLast;j++) {
                			 L2.set(j, L1.get(leftStart));
                			 leftStart++;
                		 }
                		 break;
                	 }
                	 if(leftStart>leftLast) {
                		 for(int j = idx;j<=rightLast;j++) {
                			 L2.set(j, L1.get(rightStart));
                			 rightStart++;
                		 }
                		 break;
                	 }
                   Object a = L1.get(leftStart);
                   Object b = L1.get(rightStart);
    
                   if(comp.compare(a, b)<0) {
                	   L2.set(idx, L1.get(leftStart));
                	   idx++;
                	   leftStart++;
                   }
                   else {
                	   L2.set(idx, L1.get(rightStart));
                	   idx++;
                	   rightStart++;
                   }
                	
                }              
            }

            for(int i = 0; i < L1.size(); i++) {
                L1.set(i, L2.get(i));
        }
            System.out.println("============================");
            for(int j = 0; j < L1.size(); j++) {
                System.out.print(L1.get(j) + " ");
            }
            System.out.println("\n============================");

            step *= 2;
        }   

		
	}
	public Comparator setComparator(Comparator c) {
		this.comp = c;
		return this.comp;
		
		
	}
	

}
