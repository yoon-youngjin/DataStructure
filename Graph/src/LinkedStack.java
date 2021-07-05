
public class LinkedStack {

       StackNode top;

       public LinkedStack(){
              this.top = null;
       }

       public boolean isEmpty(){
              return (top==null);
       }

       public void push(int item){
              StackNode sn = new StackNode();
              sn.data = item;
              sn.link = top;
              top = sn;
       }

       public int pop(){

              if(isEmpty()){
                     System.out.println("stack is empty");
                     return 0;
              }else{
                     int data = top.data;
                     top = top.link;
                     return data;
              }
       }
}


