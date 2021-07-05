import java.util.Scanner;

public class DFSAdjList {
    public static void main(String[] args) {
        // int v = 0;    // ���� (�����Է¿� ���Ǵ� ����)
        // int e = 0;    // ���� (�����Է¿� ���Ǵ� ����)
        int nV = 0;    // ������ ����
        int nE = 0;    // ������ ����
        
        Scanner sc = new Scanner(System.in);
        nV = sc.nextInt();    // ����
        nE = sc.nextInt();    // ����
        
        // �Է¹��� ������ ������ �׷��� �ʱ�ȭ
        DfsGraph dfsGraph = new DfsGraph(nV);
        
        // �׷����� ������ ���� �Է�
        // �Է¹��� ������ ������ŭ �ݺ�
        // ex) ���� 8, ���� 10
        dfsGraph.put(1, 2);
        dfsGraph.put(1, 3);
        dfsGraph.put(2, 4);
        dfsGraph.put(2, 5);
        dfsGraph.put(3, 6);
        dfsGraph.put(3, 7);
        dfsGraph.put(4, 8);
        dfsGraph.put(5, 8);
        dfsGraph.put(6, 8);
        dfsGraph.put(7, 8);
        dfsGraph.printGraphToAdjList();
        
        // ������ ���� ���� �Է�
        /*for(int i=0; i<nE; i++) {
            v = sc.nextInt();
            e = sc.nextInt();
            dfsGraph.put(v, e);
        }*/
        
        sc.close();
        
        // �Է��� ������ �������� ������ ��������Ʈ ���
        dfsGraph.printGraphToAdjList();
        
        // ���� ������� �׷��� Ž��
        System.out.println();
        System.out.print("���� 1���� Ž�� : ");
        dfsGraph.dfs(1);
        
        System.out.println();
        System.out.print("���� 2���� Ž�� : ");
        dfsGraph.clearVisitArr();
        dfsGraph.dfs(2);
        
        System.out.println();
        System.out.print("���� 3���� Ž�� : ");
        dfsGraph.clearVisitArr();
        dfsGraph.dfs(3);
        
        System.out.println();
        System.out.print("���� 4���� Ž�� : ");
        dfsGraph.clearVisitArr();
        dfsGraph.dfs(4);
        
        System.out.println();
        System.out.print("���� 5���� Ž�� : ");
        dfsGraph.clearVisitArr();
        dfsGraph.dfs(5);
        
        System.out.println();
        System.out.print("���� 6���� Ž�� : ");
        dfsGraph.clearVisitArr();
        dfsGraph.dfs(6);
        
        System.out.println();
        System.out.print("���� 7���� Ž�� : ");
        dfsGraph.clearVisitArr();
        dfsGraph.dfs(7);
        
        System.out.println();
        System.out.print("���� 8���� Ž�� : ");
        dfsGraph.clearVisitArr();
        dfsGraph.dfs(8);
    }
}