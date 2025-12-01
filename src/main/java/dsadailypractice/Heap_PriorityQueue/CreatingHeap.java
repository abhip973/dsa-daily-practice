package dsadailypractice.Heap_PriorityQueue;

import java.util.ArrayList;
import java.util.List;

public class CreatingHeap {
    List<Integer> heap;

    public CreatingHeap() {
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

    public int extract() {
        if (heap.isEmpty()) return Integer.MIN_VALUE;
        int lowest = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapifyDown(0);
        return lowest;
    }

    public void heapifyDown(int index) {
        int leftIndex = getLeftChildIndex(index);
        int rightIndex = getRightChildIndex(index);
        int n = heap.size();
        int smallest = index;
        if (leftIndex < n && heap.get(smallest) > heap.get(leftIndex)) {
            smallest = leftIndex;
        }
        if (rightIndex < n && heap.get(smallest) > heap.get(rightIndex)) {
            smallest = rightIndex;
        }
        if (index != smallest) {
            int temp = heap.get(smallest);
            heap.set(smallest, heap.get(index));
            heap.set(index, temp);
            heapifyDown(smallest);
        }
    }

    public int peek() {
        if (heap.isEmpty()) return Integer.MIN_VALUE;
        return heap.get(0);
    }

    public void printHeap() {
        System.out.println(heap);
    }

    public static void main(String[] args) {
        CreatingHeap insertionInHeap = new CreatingHeap();
        insertionInHeap.insert(21);
        insertionInHeap.insert(0);
        insertionInHeap.insert(11);
        insertionInHeap.insert(101);
        System.out.println("Extracted Node: " + insertionInHeap.extract());
        System.out.println("Extracted Node: " + insertionInHeap.extract());
        System.out.println("Peeked Value: " + insertionInHeap.peek());
        insertionInHeap.printHeap();
    }
}
