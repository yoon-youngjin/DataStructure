import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Prim {

	public static class Vertex implements Comparable<Vertex>{
		int v, dist;

		Vertex(int v, int dist){
			this.v = v;
			this.dist = dist;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.dist, o.dist);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input1[] = br.readLine().split(" ");
		int V = Integer.parseInt(input1[0]);
		int E = Integer.parseInt(input1[1]);

		int result = 0;

		List<Vertex> list[] = new ArrayList[V];

		for(int i = 0; i < V; i++) list[i] = new ArrayList<Vertex>();

		// ������ ������ ����ġ �Է� �ޱ�
		for(int i = 0; i < E; i++) {
			String input2[] = br.readLine().split(" ");
			int a = Integer.parseInt(input2[0]) - 1;
			int b = Integer.parseInt(input2[1]) - 1;
			int c = Integer.parseInt(input2[2]);
			// ���� ����Ʈ ����
			list[a].add(new Vertex(b, c));  
			list[b].add(new Vertex(a, c));  
		}

		// ���õǾ����� �ƴ��� �Ǵ��ϱ� ���� boolean �迭
		boolean visited[] = new boolean[V];
		// ���� ���õ� ������κ��� ������ �� �ִ� �ּ� �Ÿ� ���� �迭
		int distance[] = new int[V];

		// ��� �ִ� ������ key�� ����
		Arrays.fill(distance, Integer.MAX_VALUE);

		distance[0] = 0; // ó�� ������ ������ �Ÿ� 0
		int cnt = 0;

		PriorityQueue<Vertex> q = new PriorityQueue<Vertex>();
		q.offer(new Vertex(0, distance[0]));

		while(true) {
			Vertex cur = q.poll();

			if(visited[cur.v]) continue; 
			visited[cur.v] = true;
			result += cur.dist;
			cnt++;

			if(cnt == V) break;

			for(Vertex v : list[cur.v]) {
				if(!visited[v.v] && distance[v.v] > v.dist) {
					distance[v.v] = v.dist;
					q.offer(new Vertex(v.v, distance[v.v]));
				}
			}
		}
		System.out.println(result);
	}
}