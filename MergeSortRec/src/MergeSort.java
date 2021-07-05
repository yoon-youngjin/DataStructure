
public class MergeSort {
 
	private static int[] sorted;		// ��ġ�� �������� �����Ͽ� ���Ҹ� ���� �ӽù迭
	
	public static void merge_sort(int[] a) {
		
		sorted = new int[a.length];
		merge_sort(a, 0, a.length - 1);
		sorted = null;
	}
	
	// Top-Down ��� ����
	private static void merge_sort(int[] a, int left, int right) {
		
		/*
		 *  left==right ��, �κи���Ʈ�� 1���� ���Ҹ� �����ִ°�� 
		 *  ���̻� �ɰ� �� �����Ƿ� return�Ѵ�.
		 */
		if(left == right) return;
		
		int mid = (left + right) / 2;	// ���� ��ġ 
		
		merge_sort(a, left, mid);		// ���� �� ���� �κи���Ʈ(left ~ mid)
		merge_sort(a, mid + 1, right);	// ���� �� ������ �κи���Ʈ(mid+1 ~ right)
		
		merge(a, left, mid, right);		// �����۾�
		
	}
	
	/**
	 * ��ĥ �κи���Ʈ�� a�迭�� left ~ right �����̴�. 
	 * 
	 * @param a		������ �迭
	 * @param left	�迭�� ������
	 * @param mid	�迭�� �߰���
	 * @param right	�迭�� �� ��
	 */
	private static void merge(int[] a, int left, int mid, int right) {
		int l = left;		// ���� �κи���Ʈ ������
		int r = mid + 1;	// ������ �κи���Ʈ�� ������ 
		int idx = left;		// ä������ �迭�� �ε���
		
		
		while(l <= mid && r <= right) {
			/*
			 *  ���� �κи���Ʈ l��° ���Ұ� ������ �κи���Ʈ r��° ���Һ��� �۰ų� ���� ���
			 *  ������ l��° ���Ҹ� �� �迭�� �ְ� l�� idx�� 1 ������Ų��.
			 */
			if(a[l] <= a[r]) {
				sorted[idx] = a[l];
				idx++;
				l++;
			}
			/*
			 *  ������ �κи���Ʈ r��° ���Ұ� ���� �κи���Ʈ l��° ���Һ��� �۰ų� ���� ���
			 *  �������� r��° ���Ҹ� �� �迭�� �ְ� r�� idx�� 1 ������Ų��.
			 */
			else {
				sorted[idx] = a[r];
				idx++;
				r++;
			}
		}
		
		/*
		 * ���� �κи���Ʈ�� ���� ��� �� �迭�� ä������ ��� (l > mid)
		 * = ������ �κи���Ʈ ���Ұ� ���� �������� ���
		 * ������ �κи���Ʈ�� ������ ���ҵ��� �� �迭�� ä���ش�.
		 */
		if(l > mid) {
			while(r <= right) {
				sorted[idx] = a[r];
				idx++;
				r++;
			}
		}
		
		/*
		 * ������ �κи���Ʈ�� ���� ��� �� �迭�� ä������ ��� (r > right)
		 * = ���� �κи���Ʈ ���Ұ� ���� �������� ���
		 * ���� �κи���Ʈ�� ������ ���ҵ��� �� �迭�� ä���ش�.
		 */
		else {
			while(l <= mid) {
				sorted[idx] = a[l];
				idx++;
				l++;
			}
		}
		
		/*
		 * ���ĵ� �� �迭�� ������ �迭�� �����Ͽ� �Ű��ش�.
		 */
		for(int i = left; i <= right; i++) {
			a[i] = sorted[i];
		}
	}
}
//public class Merge_Sort {
//	 
//	private static int[] sorted;		// ��ġ�� �������� �����Ͽ� ���Ҹ� ���� �ӽù迭
//	
//	public static void merge_sort(int[] a) {
//		
//		sorted = new int[a.length];
//		merge_sort(a, 0, a.length - 1);
//		sorted = null;
//	}
//	
//	// Bottom-Up ��� ����
//	private static void merge_sort(int[] a, int left, int right) {
//		
//		/*
//		 * 1 - 2 - 4 - 8 - ... ������ 1���� ���긮��Ʈ�� ������ ������ �� �辿 �ø���.
//		 */
//		for(int size = 1; size <= right; size += size) {
//			
//			/*
//			 * �� �κи���Ʈ�� ������� �������ش�.
//			 * ���ε�� ���� �κи���Ʈ�� ũ�Ⱑ 1(size=1)�� ��
//			 * ���� �κи���Ʈ(low ~ mid)�� ������ �κи���Ʈ(mid + 1 ~ high)�� �����ϸ�
//			 * ���� �κи���Ʈ�� low = mid = 0 �̰�,
//			 * ������ �κи���Ʈ�� mid + 1���� low + (2 * size) - 1 = 1 �� �ȴ�.
//			 *  
//			 * �� �� high�� �迭�� �ε����� �Ѿ �� �����Ƿ� right�� �� �� ���� ����
//			 * ���յǵ��� �ؾ��Ѵ�. 
//			 */
//			for(int l = 0; l <= right - size; l += (2 * size)) {
//				int low = l;
//				int mid = l + size - 1;
//				int high = Math.min(l + (2 * size) - 1, right);
//				merge(a, low, mid, high);		// �����۾�
//			}
//		}
//		
//		
//		
//	}
//	
//	/**
//	 * ��ĥ �κи���Ʈ�� a�迭�� left ~ right �����̴�. 
//	 * 
//	 * @param a		������ �迭
//	 * @param left	�迭�� ������
//	 * @param mid	�迭�� �߰���
//	 * @param right	�迭�� �� ��
//	 */
//	private static void merge(int[] a, int left, int mid, int right) {
//		int l = left;		// ���� �κи���Ʈ ������
//		int r = mid + 1;	// ������ �κи���Ʈ�� ������ 
//		int idx = left;		// ä������ �迭�� �ε���
//		
//		
//		while(l <= mid && r <= right) {
//			/*
//			 *  ���� �κи���Ʈ l��° ���Ұ� ������ �κи���Ʈ r��° ���Һ��� �۰ų� ���� ���
//			 *  ������ l��° ���Ҹ� �� �迭�� �ְ� l�� idx�� 1 ������Ų��.
//			 */
//			if(a[l] <= a[r]) {
//				sorted[idx] = a[l];
//				idx++;
//				l++;
//			}
//			/*
//			 *  ������ �κи���Ʈ r��° ���Ұ� ���� �κи���Ʈ l��° ���Һ��� �۰ų� ���� ���
//			 *  �������� r��° ���Ҹ� �� �迭�� �ְ� r�� idx�� 1 ������Ų��.
//			 */
//			else {
//				sorted[idx] = a[r];
//				idx++;
//				r++;
//			}
//		}
//		
//		/*
//		 * ���� �κи���Ʈ�� ���� ��� �� �迭�� ä������ ��� (l > mid)
//		 * = ������ �κи���Ʈ ���Ұ� ���� �������� ���
//		 * ������ �κи���Ʈ�� ������ ���ҵ��� �� �迭�� ä���ش�.
//		 */
//		if(l > mid) {
//			while(r <= right) {
//				sorted[idx] = a[r];
//				idx++;
//				r++;
//			}
//		}
//		
//		/*
//		 * ������ �κи���Ʈ�� ���� ��� �� �迭�� ä������ ��� (r > right)
//		 * = ���� �κи���Ʈ ���Ұ� ���� �������� ���
//		 * ���� �κи���Ʈ�� ������ ���ҵ��� �� �迭�� ä���ش�.
//		 */
//		else {
//			while(l <= mid) {
//				sorted[idx] = a[l];
//				idx++;
//				l++;
//			}
//		}
//		
//		/*
//		 * ���ĵ� �� �迭�� ������ �迭�� �����Ͽ� �Ű��ش�.
//		 */
//		for(int i = left; i <= right; i++) {
//			a[i] = sorted[i];
//		}
//	}
//}
