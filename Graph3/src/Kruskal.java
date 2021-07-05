import java.io.*;
import java.util.*;

public class Kruskal {
	
    // 정점의 부모 노드를 저장할 배열
	public static int parents[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input1[] = br.readLine().split(" ");
		int V = Integer.parseInt(input1[0]); // 정점의 개수
		int E = Integer.parseInt(input1[1]); // 간선의 개수
		// 정점의 정보 2개 + 이들의 가중치 순으로 입력이 들어옴.
		int edges[][] = new int[E][3]; 
		// 1번부터 인덱스를 사용하기 위해서 V + 1
		parents = new int[V + 1];
		
		// 간선의 정보와 가중치 입력 받기
		for(int i = 0; i < E; i++) {
			String input2[] = br.readLine().split(" ");
			edges[i][0] = Integer.parseInt(input2[0]); // 정점1
			edges[i][1] = Integer.parseInt(input2[1]); // 정점2
			edges[i][2] = Integer.parseInt(input2[2]); // 가중치
		}
		
		// 가중치 오름차순으로 정렬
		Arrays.sort(edges, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// 2번째 인덱스에 가중치가 있으므로 가중치를 기준으로 오름차순 정렬
				return Integer.compare(o1[2], o2[2]);
			}
		});
		
		// parents를 -1로 초기화
		Arrays.fill(parents, -1);
		
		// 출력될 가중치의 합
		int result = 0;
		int cnt = 0;
		// 간선의 수만큼 loop 수행
		for(int i = 0; i < edges.length; i++) {
			// 정점과 정점이 연결될 수 있는지 확인
			if(union(edges[i][0], edges[i][1])) {
				result += edges[i][2]; // 가중치 덧셈
				cnt++;
			}
			// cnt가 정점 - 1개가 된다는 것은 모든 정점을 다 연결했다는 의미이므로 종료
			if(cnt == V - 1) break;
		}
		System.out.println(result);
	}
	
	public static int find(int x) {
		if(parents[x] < 0) return x;
		return parents[x] = find(parents[x]);
	}
	
	public static boolean union(int x, int y) {
		int xRoot = find(x); // x의 root를 찾아서 결과 받음
		int yRoot = find(y); // y의 root를 찾아서 결과 받음
		
		// 두 개의 정점의 root가 같지 않다면 같은 집합에 속하지 않은 것
		if(xRoot != yRoot) { 
			parents[yRoot] = xRoot; // 따라서 y의 root를 x의 root로 변경
			return true; // 연결되었으므로 true return
		}
		// 연결을 하지 못한 경우이므로 false return
		return false;
	}
}