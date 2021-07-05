
public class GraphNode {

       GraphNode link;
       private int vertex;

       public GraphNode(int v) {
              // TODO Auto-generated constructor stub
              this.link = null;
              vertex = v;
       }
       public GraphNode() {
           // TODO Auto-generated constructor stub
           this.link = null;
    }

       public int getVertex(){
              return vertex;
       }

       public void setVertex(int v){
               vertex = v;
       }
}


