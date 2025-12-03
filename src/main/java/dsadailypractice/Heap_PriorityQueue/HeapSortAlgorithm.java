package dsadailypractice.Heap_PriorityQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HeapSortAlgorithm {
    public List<Integer> heap;

    public int getLeftChildIndex(int index) {
        return (2 * index) + 1;
    }

    public int getRightChildIndex(int index) {
        return (2 * index) + 2;
    }

    public int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    public void heapifyDown(int index, int range) {
        int highest = index;
        int leftChild = getLeftChildIndex(index);
        int rightChild = getRightChildIndex(index);
        int size = range;
        if (leftChild < size && heap.get(leftChild) > heap.get(highest)) {
            highest = leftChild;
        }
        if (rightChild < size && heap.get(rightChild) > heap.get(highest)) {
            highest = rightChild;
        }
        if (highest != index) {
            int temp = heap.get(highest);
            heap.set(highest, heap.get(index));
            heap.set(index, temp);
            heapifyDown(highest, range);
        }
    }

    public List<Integer> heapSort(Integer[] arr) {
        heap = Arrays.asList(arr);
        int n = heap.size() - 1;

        //Converting our array to max heap
        for (int i = (n - 1) / 2; i >= 0; i--) {
            heapifyDown(i, heap.size());
        }

        // Sorting the max heap
        while (n > 0) {
            Collections.swap(heap, 0, n);
            n--;
            heapifyDown(0, n);
        }
        return heap;
    }

    public static void main(String[] args) {
        Integer[] arr = {7, 1, 10, 3, 4, 2, 8, 6};
        HeapSortAlgorithm heapSortAlgorithm = new HeapSortAlgorithm();
        System.out.println("Sorted array for " + Arrays.toString(arr) + " is: " + heapSortAlgorithm.heapSort(arr));
    }
}
