import java.util.ArrayList;

class DfsGraph {
    private int nV;    // ������ ����
    private ArrayList<ArrayList<Integer>> dfsGraph;    // �׷���
    private boolean[] visitArr;    // ���� �湮 ���� Ȯ�� �迭
 
    // �׷��� �ʱ�ȭ ������
    public DfsGraph(int nV) {
        this.nV = nV;    // ���� ���� �ʱ�ȭ
        this.dfsGraph = new ArrayList<ArrayList<Integer>>(); // �׷��� ����
        
        // �׷��� �ʱ�ȭ
        // put(int x, int y) ���� �ԷµǴ� ������ ���� 0 �̻��� �����̳�
        // ArrayList�� index�� 0 ���� �����̹Ƿ� 
        // ArrayIndexOutOfBoundsException ������ ���� 
        // ������ ��� ��������Ʈ�� size�� 1�� ���Ͽ� �ʱ�ȭ����
        // ��, �Է¹��� ������ ������ +1�� ����
 
        // ex) initSize = 3
        // graph[0]
        // graph[1] -> 2 -> 3
        // graph[2] -> 1 -> 3 -> 4
        // graph[3] -> 1 -> 2 -> 4 -> 5
        for(int i=0; i<this.nV+1; i++) {
            this.dfsGraph.add(new ArrayList<Integer>());
        }
        
        // ���� �湮 ���� Ȯ�� �迭 �ʱ�ȭ
        // �׷����� ���������� ������ ������ +1�Ͽ� �ʱ�ȭ
        this.visitArr = new boolean[this.nV+1];
    }
 
    // �׷��� return
    public ArrayList<ArrayList<Integer>> getGraph() {
        return this.dfsGraph;
    }
 
    // �׷����� Ư�� ��� return
    public ArrayList<Integer> getNode(int i) {
        return this.dfsGraph.get(i);
    }
 
    // �׷��� �߰� (�����)
    public void put(int x, int y) {
        this.dfsGraph.get(x).add(y);
        this.dfsGraph.get(y).add(x);
    }
 
    // �׷��� �߰� (�ܹ���)
    public void putSingle(int x, int y) {
        this.dfsGraph.get(x).add(y);
    }
    
    // �׷��� ��� (��������Ʈ)
    public void printGraphToAdjList() {
        for(int i=1; i<this.dfsGraph.size(); i++) {
            System.out.print("���� " + i + "�� ��������Ʈ");
            
            for(int j=0; j<this.dfsGraph.get(i).size(); j++) {
                System.out.print(" -> " + this.dfsGraph.get(i).get(j));
            }
            System.out.println();
        }
    }
    
    // ���� �湮 ���� Ȯ�� �迭 �ʱ�ȭ
    public void clearVisitArr() {
        for(int i=0; i<this.visitArr.length; i++) {
            this.visitArr[i] = false;
        }
    }
    
    // �׷��� Ž�� (���ȣ��)
    public void dfs(int vIdx) {
        // dfs()�� �Ķ���ͷ� �Ѿ�� vIdx�� �湮�� ���̹Ƿ�
        // �湮�迭�� �ش� index���� true�� �ٲ��ְ� ���� �����.
        this.visitArr[vIdx] = true;
        System.out.print(vIdx + " "); 
        
        // ��������Ʈ�� ������ �׷�������
        // �ش� index�� �´� ����Ʈ�� �����ͼ� �ݺ�
        for(int i : this.dfsGraph.get(vIdx)) {
            
            // �ش� ����(i)�� ���� �湮 ���� Ȯ�� �迭����
            // �湮���� ���� ����(false)�� ���
            if(this.visitArr[i] == false) {
                dfs(i);    // dfs() ���ȣ��
            }
        }
    }
 
}
    


