import java.util.ArrayList;

class MinHeap {
    ArrayList<Integer> heap;

    /*heap init*/
    public MinHeap(){
        heap = new ArrayList<>();
        heap.add(0); // heap �� �ε����� �˱� ���� 0���� �����Ѵٴ� Ư���� ������.
    }
    // insertion
    void insert(int data) {
        heap.add(data);
        int position = heap.size() - 1;
        // ��Ʈ ������ �̵��߰ų�, �θ� Heap�� �ڽ� Heap���� ���� �� ���� -> up-heap bubbling
        while(position > 1 && heap.get(position / 2) > heap.get(position)) {

            /*�θ� ���� �ڽ� ��尣�� swap�� ���� ����*/
            int temp = heap.get(position / 2);
            heap.set(position / 2, heap.get(position));
            heap.set(position, temp);

            position /= 2;
        }
    }
    int delete() {
        // heap ����� 1���� ������ ��, ���� ���� ������ return 0;
        if(heap.size() - 1 < 1) {
            return 0;
        }

        int deleteData = heap.get(1); // ��� ��� ����

        heap.set(1, heap.get(heap.size() - 1)); // ��Ʈ ����� �ڸ��� ���� ����� data�� ����
        heap.remove(heap.size() - 1); // ���� ��� ����

        int position = 1;
        while((position * 2) < heap.size()) { // ���� ũ�⺸�� ���� �� ���� -> doun-heap bubbling
            int min = heap.get(position * 2); // ���� ����� ���� �ڽ� ����� ��
            int minPos = position * 2; // ���� ����� ���� �ڽ� ����� �ε���

            // ������ �ڽ� ���� ���� �ڽ� ��� �� �� ū ��忡 ���� ���ϰ� ��ȯ�ϱ� ������ ���� �ڽĳ��� ������ �ڽ� ����� ���� ���ϴ� ������ ��ģ��.
            if(((position * 2 + 1) < heap.size()) && min > heap.get(position * 2 + 1)){  // ������ �ڽ� ��尡 �� ũ�� �ٲ�����Ѵ�.
                min = heap.get(position * 2 + 1); // ������ �ڽ� ���� ����
                minPos = position * 2 + 1; // ��ġ ���� ������ �ڽ� ���� ����
            }

            if(heap.get(position) < min) break; // ���� ��庸�� �ڽ� ����� ���� �� ũ��, ���� ������ �����ϸ� �ݺ� ����

            /*�ڽİ� �θ��� SWAP ����*/
            int temp = heap.get(position);
            heap.set(position, heap.get(minPos));
            heap.set(minPos, temp);
            position = minPos;
        }
        return deleteData;
    }
    int getMin() {
    	return heap.get(1);
    }
    
}
