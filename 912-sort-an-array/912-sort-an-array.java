import java.util.StringJoiner;

class Solution {
    
    private static class HeapSort{
        int size;
        int[] arr;

        public HeapSort(int capacity){
            arr = new int[capacity];
            size = 0;
        }

        /**
         * We need to do min heapify, sink swim operations to maintain the heap.
         * Sorting will then simply be extracting out the min/max element based on what type of heap it is: Min-Heap
         */ 
        public int[] sort() {
            var sorted = new int[size];
            int i = 0;
            while(size > 0) {
                sorted[i++] = extractMin();
            }
            return sorted;
        }

        private int extractMin() {
            int min = 0;
            if(size > 0){
                min = arr[0];
                arr[0] = arr[--size];
                sink();
            }
            return min;
        }

        public void insert(int value){
            if(size+1 <= arr.length){
                arr[size] = value;
                swim(size);
                size++;

            }
        }

        public static HeapSort makeHeap(int[] array){
            HeapSort hs = new HeapSort(array.length);
            for(int e: array){
                hs.insert(e);
            }
            return hs;
        }

        private void swap(int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        public static <T> void show(T[] arr) {
            StringJoiner sj = new StringJoiner(", ", "[", "]");
            for (T e : arr) {
                sj.add(e.toString());
            }
            System.out.println(sj);
        }

        void swim(int index){
            if(index < 0 || index > size){
                throw new IndexOutOfBoundsException("Index is outside boundary of array");
            }

            while(index > 0){
                int parent = (index - 1)/2;
                if(arr[index] >= arr[parent]){
                    break;
                }
                swap(index, parent);
                index = parent;
                parent = index/2;
            }
        }

        void sink(){
            int index = 0;
            while(index < size-1){
                int smallest = index;
                int left = 2*index + 1;
                if(left < size){
                    smallest = (arr[smallest] > arr[left] ? left : smallest);
                }
                int right = left + 1;
                if(right < size){
                    smallest = (arr[smallest] > arr[right] ? right : smallest); 
                }
                if(smallest == index){
                    break;
                }
                swap(index, smallest);
                index = smallest;
            }
        }
    }
    
    public int[] sortArray(int[] nums) {
        HeapSort hs = HeapSort.makeHeap(nums);
        return hs.sort();
    }
}