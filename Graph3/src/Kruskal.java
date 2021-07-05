import java.io.*;
import java.util.*;

public class Kruskal {
	
    // ������ �θ� ��带 ������ �迭
	public static int parents[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input1[] = br.readLine().split(" ");
		int V = Integer.parseInt(input1[0]); // ������ ����
		int E = Integer.parseInt(input1[1]); // ������ ����
		// ������ ���� 2�� + �̵��� ����ġ ������ �Է��� ����.
		int edges[][] = new int[E][3]; 
		// 1������ �ε����� ����ϱ� ���ؼ� V + 1
		parents = new int[V + 1];
		
		// ������ ������ ����ġ �Է� �ޱ�
		for(int i = 0; i < E; i++) {
			String input2[] = br.readLine().split(" ");
			edges[i][0] = Integer.parseInt(input2[0]); // ����1
			edges[i][1] = Integer.parseInt(input2[1]); // ����2
			edges[i][2] = Integer.parseInt(input2[2]); // ����ġ
		}
		
		// ����ġ ������������ ����
		Arrays.sort(edges, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// 2��° �ε����� ����ġ�� �����Ƿ� ����ġ�� �������� �������� ����
				return Integer.compare(o1[2], o2[2]);
			}
		});
		
		// parents�� -1�� �ʱ�ȭ
		Arrays.fill(parents, -1);
		
		// ��µ� ����ġ�� ��
		int result = 0;
		int cnt = 0;
		// ������ ����ŭ loop ����
		for(int i = 0; i < edges.length; i++) {
			// ������ ������ ����� �� �ִ��� Ȯ��
			if(union(edges[i][0], edges[i][1])) {
				result += edges[i][2]; // ����ġ ����
				cnt++;
			}
			// cnt�� ���� - 1���� �ȴٴ� ���� ��� ������ �� �����ߴٴ� �ǹ��̹Ƿ� ����
			if(cnt == V - 1) break;
		}
		System.out.println(result);
	}
	
	public static int find(int x) {
		if(parents[x] < 0) return x;
		return parents[x] = find(parents[x]);
	}
	
	public static boolean union(int x, int y) {
		int xRoot = find(x); // x�� root�� ã�Ƽ� ��� ����
		int yRoot = find(y); // y�� root�� ã�Ƽ� ��� ����
		
		// �� ���� ������ root�� ���� �ʴٸ� ���� ���տ� ������ ���� ��
		if(xRoot != yRoot) { 
			parents[yRoot] = xRoot; // ���� y�� root�� x�� root�� ����
			return true; // ����Ǿ����Ƿ� true return
		}
		// ������ ���� ���� ����̹Ƿ� false return
		return false;
	}
}