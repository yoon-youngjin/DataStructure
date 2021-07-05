import java.util.ArrayList;
import java.util.Arrays;

public class radixsort {
	 public static void Radix_Sort(int[] data)
	    {
	        int maxsize = getMaxlength(data);
	        ArrayList<Linear_Queue> bucket = new ArrayList();
	        int powed=1;
	        int index = 0;
	 
	        for(int i=0;i<10;i++)        //��Ŷ ����
	        {
	            bucket.add(new Linear_Queue(10));
	        }
	        
	        for(int i=1;i<=maxsize;i++)        //�ڸ����� ���� ū ����ŭ ��ü �ݺ����� �ݺ��մϴ�.
	        {
	            for(int j=0;j<data.length;j++)    
	            {    
	                bucket.get((data[j]/powed)%10).EnQueue(data[j]);    //�� �ڸ����� �´� index�� bucket�� �ֽ��ϴ�.
	            }
	            for(int k=0;k<10;k++)        //��Ŷ���� �����͸� ������ɴϴ�.
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
	        return maxsize;            //���� ū �ڸ����� ��ȯ�մϴ�.
	    }
	   
	    
	    public static void main(String[] args) {
	    	int[] arr = {123,432,353,4,2,34,14,234,1,0,1243};
	    	System.out.println(getMaxlength(arr));
	    	
	    	Radix_Sort(arr);
	        // ���
	        for(int i=0; i < arr.length; i++){
	            System.out.print(arr[i] + ", ");
	        }
	    }
	}






