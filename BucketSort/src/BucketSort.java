
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BucketSort {
    public static void main(String[] args){

//        // 전체 크기는 30으로 제한
//        int[] arr = new int[30];
//        for(int i=0; i < arr.length; i++){
//            // 값의 범위는 0 ~ 1 까지의 소수점 2자리까지로 제한
//            arr[i] = (int)((Math.random()*10000)%10);
//        }
    	 
    	int[] arr = {1,3,9,5,8,6,6,7,10};
        bucketSort(arr);
        // 출력
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
//        // 1) n 크기의 빈 Bucket을 생성한다.
//        LinkedList<Integer>[] bucket = new LinkedList[n];
//
//        for(int i=0; i < n; i++){
//            bucket[i] = new LinkedList<>();
//        }

        // 2) 기존 데이터 값에 n을 곱해 bucket에 넣는다.
        for(int i=0; i < n; i++){
        	LinkedList temp = ((LinkedList)bucket.get(hash(arr[i],n)));
        	temp.add(arr[i]);
        	
        }

        // 3) 각 Bucket을 정렬한다. 여기선 간단하게 기존 Library 사용
        for(int i=0; i < n; i++){
            Collections.sort((LinkedList) bucket.get(i));
        }

        // 4) bucket에 저장한 값을 빼서 기존 배열에 다시 삽입
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