
public class main {
       public static void main(String[] args) {
              
              AdjList l = new AdjList();
              
              for(int i =0; i<6 ;i++){
                     l.insertVertex(i);
              }
              l.insertEdge(0, 3);
              l.insertEdge(0, 1);
              l.insertEdge(1, 3);
              l.insertEdge(1, 2);
              l.insertEdge(1, 0);
              l.insertEdge(2, 3);
              l.insertEdge(2, 1);
              l.insertEdge(3, 2);
              l.insertEdge(3, 1);
              l.insertEdge(3, 0);
              l.insertEdge(4, 2);
              l.insertEdge(2, 4);
              l.insertEdge(5, 3);
              l.insertEdge(3, 5);
              l.insertEdge(1, 4);
              l.insertEdge(4, 1);
              

              System.out.println("\n�׷��� G�� ��������Ʈ : ");
              l.printAdjList();
              System.out.println();
              
              System.out.println("\n\n ���̿켱Ž�� >>");
              l.DES(0);
              
              System.out.println("\n\n �ʺ�켱Ž�� >>");
              l.BES(0);





       }
}
