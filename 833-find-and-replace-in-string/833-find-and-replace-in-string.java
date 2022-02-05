class Solution {
    
        private <T> void swap(T[] arr, int b, int e) {
        T temp = arr[b];
        arr[b] = arr[e];
        arr[e] = temp;
    }

    private void swap(int[] arr, int b, int e) {
        int temp = arr[b];
        arr[b] = arr[e];
        arr[e] = temp;
    }

    private int partition(int[] indices, String[] sources, String[] targets, int b, int e) {
        if (b > e) {
            return -1;
        }
        int el = indices[e];
        for (int i = b; i < e; i++) {
            if (indices[i] < el) {
                swap(indices, i, b);
                swap(sources, i, b);
                swap(targets, i, b);
                b++;
            }
        }
        swap(indices, e, b);
        swap(sources, e, b);
        swap(targets, e, b);
        return b;
    }

    private void quickSort(int[] indices, String[] sources, String[] targets, int lo, int hi) {
        if (lo > hi) {
            return;
        }
        int pivot = partition(indices, sources, targets, lo, hi);
        quickSort(indices, sources, targets, lo, pivot - 1);
        quickSort(indices, sources, targets, pivot + 1, hi);
    }
    
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        StringBuilder r = new StringBuilder();
        int k = indices.length;

        quickSort(indices, sources, targets, 0, k - 1);

        int prev = 0;
        for (int i = 0; i < k; i++) {
            if (sources[i].equals(s.substring(indices[i], indices[i] + sources[i].length()))) {
                if (indices[i] > prev) {
                    r.append(s.substring(prev, indices[i]));
                }
                r.append(targets[i]);
                prev = indices[i] + sources[i].length();
            }
        }
        if (prev < s.length()) {
            r.append(s.substring(prev));

        }
        return r.toString();
    }
}