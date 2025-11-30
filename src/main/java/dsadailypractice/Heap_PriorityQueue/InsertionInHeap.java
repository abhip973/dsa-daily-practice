package dsadailypractice.Heap_PriorityQueue;

import java.util.ArrayList;
import java.util.List;

public class InsertionInHeap {
    List<Integer> heap;

    public InsertionInHeap() {
        heap = new ArrayList<>();
        heap.add(5);
        heap.add(10);
        heap.add(20);
        heap.add(30);
    }

    public int getLeftChildIndex(int i) {
        return (2 * i) + 1;
    }

    public int getRightChildIndex(int i) {
        return (2 * i) + 2;
    }

    public int getParentIndex(int i) {
        return (i - 1) / 2;
    }

    public void insert(int val) {
        heap.add(val);
        int lastIndex = heap.size() - 1;
        heapifyUp(lastIndex);
    }

    public void heapifyUp(int index) {
        while (index > 0) {
            if (heap.get(getParentIndex(index)) > heap.get(index)) {
                int parent = getParentIndex(index);
                int temp = heap.get(parent);
                heap.set(parent, heap.get(index));
                heap.set(index, temp);
                index = parent;
            } else break;
        }
    }

    public void printHeap() {
        System.out.println(heap);
    }

    public static void main(String[] args) {
        InsertionInHeap insertionInHeap = new InsertionInHeap();
        insertionInHeap.insert(21);
        insertionInHeap.insert(0);
        insertionInHeap.insert(11);
        insertionInHeap.insert(101);
        insertionInHeap.printHeap();
    }
}
