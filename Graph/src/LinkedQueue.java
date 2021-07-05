
public class LinkedQueue {

       QueueNode front;
       QueueNode rear;

       public LinkedQueue() {
              // TODO Auto-generated constructor stub
              this.front = null;
              this.rear = null;
       }

       public boolean isEmpty(){
              return (front == null);
       }

       public void enQueue(int item){
              QueueNode qn = new QueueNode();
              qn.data = item;
              if(isEmpty()){
                     front= qn;
                     rear = qn;
              }else{
                     rear.link = qn;
                     rear = qn;
              }
       }

       public int deQueue(){

              int item = front.data;
              front = front.link;
              if(front == null){
                     rear =null;
              }
              return item;
       }
}



