
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BucketSort {
    public static void main(String[] args){

//        // ��ü ũ��� 30���� ����
//        int[] arr = new int[30];
//        for(int i=0; i < arr.length; i++){
//            // ���� ������ 0 ~ 1 ������ �Ҽ��� 2�ڸ������� ����
//            arr[i] = (int)((Math.random()*10000)%10);
//        }
    	 
    	int[] arr = {1,3,9,5,8,6,6,7,10};
        bucketSort(arr);
        // ���
        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i] + ", ");
        }
    }

    public static void bucketSort(int[] arr){
        int n = arr.length;
        if(n <= 0) return;
        
        ArrayList bucket = new ArrayList(n);
        
        for(int i=0; i<n;i++) {
        	
        	bucket.add(i, new LinkedList());
        }
        
//
//        // 1) n ũ���� �� Bucket�� �����Ѵ�.
//        LinkedList<Integer>[] bucket = new LinkedList[n];
//
//        for(int i=0; i < n; i++){
//            bucket[i] = new LinkedList<>();
//        }

        // 2) ���� ������ ���� n�� ���� bucket�� �ִ´�.
        for(int i=0; i < n; i++){
        	LinkedList temp = ((LinkedList)bucket.get(hash(arr[i],n)));
        	temp.add(arr[i]);
        	
        }

        // 3) �� Bucket�� �����Ѵ�. ���⼱ �����ϰ� ���� Library ���
        for(int i=0; i < n; i++){
            Collections.sort((LinkedList) bucket.get(i));
        }

        // 4) bucket�� ������ ���� ���� ���� �迭�� �ٽ� ����
        int index = 0;
        for(int i=0; i < n; i++){
            for(int j=0; j < ((LinkedList) bucket.get(i)).size(); j++){
            	int temp = ((int)((LinkedList)bucket.get(i)).get(j));
                arr[index++] = temp;
            }
        }
    }

	private static int hash(int i, int n) {
		
		return i/n;
	}
}