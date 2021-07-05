
public class AdjList {

       public GraphNode[] headList;
       private int headListSize;

       public AdjList() {
              // TODO Auto-generated constructor stub
              headList = new GraphNode[10];
              headListSize = 0;
       }

       public void insertVertex(int i){
              headListSize++;
       }

       public void insertEdge(int v1, int v2){
              if(v1 >=headListSize || v2 >= headListSize){
                     System.out.println("vertex 값이 올바르지 않습니다.");
              }else{
                     GraphNode gn = new GraphNode(v2);
                     gn.link=headList[v1];
                     headList[v1]= gn;

                     GraphNode temp = headList[v1];
                     int tempValue;
                     //오름차준 정렬
                     while(temp.link != null){
                           if(temp.getVertex() > temp.link.getVertex()){
                                  tempValue = temp.link.getVertex();
                                  temp.link.setVertex(temp.getVertex());
                                  temp.setVertex(tempValue);
                           }
                           temp = temp.link;
                     }
              }

       }
       public void printAdjList(){
              for(int i =0; i <headListSize; i++){
                     GraphNode temp = headList[i];
                     System.out.printf("정점 %c 의 인접리스트 -> ",(i+65));
                     while(temp.link != null){
                           System.out.printf("%c -> ", temp.getVertex()+65);
                           temp = temp.link;
                     }
                     System.out.printf("%c\n",(temp.getVertex()+65));
              }
       }
       
       public void DES(int v){
           if(headListSize ==0){
                  System.out.println("graph is empty");
           }else{
                  GraphNode visitedNode = new GraphNode();
                  LinkedStack st = new LinkedStack();
                  boolean visited[] = new boolean[10];
                  visited[v] = true;
                  st.push(v);
                  System.out.printf(" %c ", v+65);

                  while(!st.isEmpty()){
                        visitedNode = headList[st.pop()];
                        while(visitedNode != null){
                               if(visited[visitedNode.getVertex()]==false){
                                      visited[visitedNode.getVertex()] = true;
                                      st.push(visitedNode.getVertex());
                                      System.out.printf(" %c ", visitedNode.getVertex()+65);
                                      visitedNode = headList[visitedNode.getVertex()];
                               }else{
                                      visitedNode = visitedNode.link;
                               }
                        }
                  }
           }

    }
       public void BES(int v){
           if(headListSize ==0){
                  System.out.println("graph is empty");
           }else{
                  GraphNode visitedNode = new GraphNode();
                  LinkedQueue lq = new LinkedQueue();
                  boolean visited[] = new boolean[10];
                  visited[v] = true;
                  lq.enQueue(v);
                  System.out.printf(" %c " , v+65 );

                  for(int i =0; i<headListSize ; i++){

                        visitedNode = headList[lq.deQueue()];

                        while(visitedNode != null){
                               if(visited[visitedNode.getVertex()]==false){
                                      lq.enQueue(visitedNode.getVertex());
                                      visited[visitedNode.getVertex()] = true;
                                      System.out.printf(" %c " , visitedNode.getVertex()+65 );
                                      visitedNode = visitedNode.link;
                               }else{
                                      visitedNode = visitedNode.link;
                               }
                        }
                  }
           }
    }





}
