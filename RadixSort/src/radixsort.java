import java.util.ArrayList;
import java.util.Arrays;

public class radixsort {
	 public static void Radix_Sort(int[] data)
	    {
	        int maxsize = getMaxlength(data);
	        ArrayList<Linear_Queue> bucket = new ArrayList();
	        int powed=1;
	        int index = 0;
	 
	        for(int i=0;i<10;i++)        //버킷 생성
	        {
	            bucket.add(new Linear_Queue(10));
	        }
	        
	        for(int i=1;i<=maxsize;i++)        //자리수가 가장 큰 수만큼 전체 반복문을 반복합니다.
	        {
	            for(int j=0;j<data.length;j++)    
	            {    
	                bucket.get((data[j]/powed)%10).EnQueue(data[j]);    //각 자리수의 맞는 index의 bucket에 넣습니다.
	            }
	            for(int k=0;k<10;k++)        //버킷에서 데이터를 가지고옵니다.
	            {
	                int bucket_num = bucket.get(k).rear;
	 
	                for(int n=0;n<=bucket_num;n++)
	                {
	                    data[index] = bucket.get(k).DeQueue();
	                    index++;
	                }
	            }
	            index =0;
	            powed *=10;
	        }
	    }
	    public static int getMaxlength(int[] data)
	    {
	        int maxsize = 0;
	        for(int i=0;i<data.length;i++)
	        {
	            int length = (int)Math.log10((double)data[i])+1;
	            if(maxsize <length)
	            {
	                maxsize = length;
	            }
	        }
	        return maxsize;            //가장 큰 자리수를 반환합니다.
	    }
	   
	    
	    public static void main(String[] args) {
	    	int[] arr = {123,432,353,4,2,34,14,234,1,0,1243};
	    	System.out.println(getMaxlength(arr));
	    	
	    	Radix_Sort(arr);
	        // 출력
	        for(int i=0; i < arr.length; i++){
	            System.out.print(arr[i] + ", ");
	        }
	    }
	}






