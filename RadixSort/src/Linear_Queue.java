
public class Linear_Queue {
	        
	        int rear = -1;
	        int front = 0;
	        int maxsize = 0;
	        int[] Linear_Queue;
	        
	        public Linear_Queue(int maxsize)
	        {
	            this.maxsize = maxsize;
	            Linear_Queue = new int[maxsize];
	        }
	        
	        public void EnQueue(int num)
	        {
	            if(rear != maxsize-1)
	            {
	                Linear_Queue[++rear] = num;
	            }
	            else
	            {
	                System.out.println("데이터 다참");
	            }
	        }
	        
	        public int DeQueue()
	        {
	            if(rear!=front || (rear==0 && front==0))
	            {
	                int tmp =Linear_Queue[front];
	                for(int i=1;i<=rear;i++)
	                {
	                    Linear_Queue[i-1] = Linear_Queue[i];
	                }
	                rear--;
	                return tmp;
	            }
	            else
	            {
	                return -1;
	            }    
	        }
	    }